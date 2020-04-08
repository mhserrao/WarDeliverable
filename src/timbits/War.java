/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timbits;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that represents a War object. This class contains all the logic of
 * the card game of war between two players.
 *
 * @author Maiziel Serrao
 */
public class War extends Game {

    Scanner scan = new Scanner(System.in); //Scanner for user input
    Validator isValid = new Validator(); //Validator to test user input

    /**
     * The default constructor of the War object. Sets the name of the game to
     * "War" and the players to an ArrayList of 2 players.
     */
    public War() {
        super("War");
        ArrayList<Player> players = new ArrayList<Player>(2);
        setPlayers(players);
    }

    /**
     * A method that takes in two Player objects and allows them to participate
     * in a round, given that they own some cards in their players cards piles.
     * If either player does not have cards in their players cards piles, they
     * can take cards from their cards won pile, given that they have cards in
     * that pile. If they have no more cards left, the winner is declared.
     *
     * @param me player who may participate in the round
     * @param opp player who may participate in the round
     */
    @Override
    public void play(Player me, Player opp) {
        if ((me instanceof WarPlayer) && (opp instanceof WarPlayer)) {
            WarPlayer newMe = (WarPlayer) me;
            WarPlayer newOpp = (WarPlayer) opp;

            if (newMe.checkPile() && newOpp.checkPile()) { //from war player
                round(newMe, newOpp);
            } else if ((!newMe.checkPile() && newMe.checkCardsWonPile())
                    || (!newOpp.checkPile() && newOpp.checkCardsWonPile())) {
                if (!newMe.checkPile()) {
                    System.out.println("You have run out of cards in your pile "
                            + "but have " + newMe.getCardsWon().getSize()
                            + " cards in your winning cards pile.");
                    concede();
                }
                newMe.changePiles();
                newOpp.changePiles();
                System.out.println();
            }

            me = newMe;
            opp = newOpp;
            if (!newMe.checkForAnyCards() || !newOpp.checkForAnyCards()) {
                declareWinner(newMe, newOpp);
            }
        }
    }

    /**
     * A method that takes in two players and determines the winner based on the
     * number of WarCard objects each player owns. If a player owns no more
     * WarCard objects, then they have lost.
     *
     * @param me Player who is participating in the game of war
     * @param opp another Player who is participating in the game of war
     */
    @Override
    public void declareWinner(Player me, Player opp) {
        if ((me instanceof WarPlayer) && (opp instanceof WarPlayer)) {
            WarPlayer newMe = (WarPlayer) me;
            WarPlayer newOpp = (WarPlayer) opp;

            if (newMe.checkForAnyCards() && !newOpp.checkForAnyCards()) {
                System.out.println(newMe.getPlayerID() + " is the winner of "
                        + "this game of war!");
                System.exit(0);
            } else if (newOpp.checkForAnyCards() && !newMe.checkForAnyCards()) {
                System.out.println(newOpp.getPlayerID() + " is the winner of "
                        + "this game of war!");
                System.exit(0);
            } else {
                System.out.println("You both still have cards! Unless...");
                concede();
            }
        }
    }

    /**
     * A method that splits a DeckOfCards object between two players.
     *
     * @param me Player who receives one half of the DeckOfCards object
     * @param opp Player who receives the other half of the DeckOfCards object
     * @param deck DeckOfCards object to be split
     */
    public void dealCards(WarPlayer me, WarPlayer opp, DeckOfCards deck) {
        deck.shuffle();

        ArrayList<WarCard> myCards = new ArrayList<WarCard>();
        ArrayList<WarCard> oppCards = new ArrayList<WarCard>();

        int halfPoint = deck.getSize() / 2;

        for (int i = 0; i < halfPoint; i++) {
            myCards.add(deck.showCards().get(i));
        }

        for (int i = halfPoint; i < deck.getSize(); i++) {
            oppCards.add(deck.showCards().get(i));
        }

        me.setPlayersCards(new GroupOfCards(myCards)); 
        opp.setPlayersCards(new GroupOfCards(oppCards));
    }

    /**
     * A method that allows two players to participate in a round of war where
     * both players draw a card (provided they both have any) and call on other
     * methods if they reach a tie.
     *
     * @param me WarPlayer participating in a round of war
     * @param opp other WarPlayer participating in a round of war
     */
    public void round(WarPlayer me, WarPlayer opp) {
        WarCard myCard = me.play();
        WarCard yourCard = opp.play();
        System.out.println(me.getPlayerID() + " drew " + myCard.toString()
                + "!");
        System.out.println(opp.getPlayerID() + " drew " + yourCard.toString()
                + "!");
        if (myCard.getRank().getCardNumber()
                > yourCard.getRank().getCardNumber()) {
            System.out.println("\n" + me.getPlayerID() + " is the winner of "
                    + "this round!\n");
            me.addToWonCards(myCard);
            me.addToWonCards(yourCard);
        } else if (myCard.getRank().getCardNumber()
                < yourCard.getRank().getCardNumber()) {
            System.out.println("\n" + opp.getPlayerID() + " is the winner of "
                    + "this round!\n");
            opp.addToWonCards(myCard);
            opp.addToWonCards(yourCard);
        } else {
            System.out.println("\nThis is WAR!\n");

            ArrayList<WarCard> bettingCards = new ArrayList<WarCard>();
            bettingCards.add(myCard);
            bettingCards.add(yourCard);
            tie(me, opp, bettingCards);
        }
    }

    /**
     * A method that takes in two WarPlayer objects and determines the winner of
     * a tie in a round. The winner gets the cards added to their cardsWon pile.
     * If the WarPlayer runs out of cards or has less than 4 cards total, the
     * method gives the cards by default to the WarPlayer with the most cards.
     *
     * @param me WarPlayer involved in the tie
     * @param opp other WarPlayer involved in the tie
     * @param bettingCards ArrayList of WarCard objects representing the WarCard
     * objects placed face-down during the tie
     */
    public void tie(WarPlayer me, WarPlayer opp,
            ArrayList<WarCard> bettingCards) {
        boolean stillATie = true;
        WarPlayer winner = me;
        int counter = 0;

        do {
            canParticipateInTie(me, opp, bettingCards);

            WarCard yourBet = bettingCards.get(bettingCards.size() - 1);
            WarCard myBet = bettingCards.get(bettingCards.size() - 2);

            System.out.println(me.getPlayerID() + " drew " + myBet.toString()
                    + "!");
            System.out.println(opp.getPlayerID() + " drew " + yourBet.toString()
                    + "!");

            if (myBet.getRank().getCardNumber()
                    > yourBet.getRank().getCardNumber()) {
                System.out.println("\n" + me.getPlayerID() + " is the winner of"
                        + " this war!\n");
                me.addToWonCards(bettingCards);
                winner = me;
                stillATie = false;
            } else if (myBet.getRank().getCardNumber()
                    < yourBet.getRank().getCardNumber()) {
                System.out.println("\n" + opp.getPlayerID() + " is the winner "
                        + "of this war!\n");
                opp.addToWonCards(bettingCards);
                winner = opp;
                stillATie = false;
            } else {
                System.out.println("\nIt's still a tie! You must enter another"
                        + " war!\n");
                counter++;
                if (counter > 0 && me.getTotalCardsAmount() <= 4) {
                    opp.addToWonCards(bettingCards);
                    System.out.println(opp.getPlayerID() + " won by default.");
                    break;
                } else if (counter > 1 && opp.getTotalCardsAmount() <= 4) {
                    me.addToWonCards(bettingCards);
                    System.out.println(me.getPlayerID() + " won by default.");
                    break;
                }
            }
        } while (stillATie);

        showCardsBetWon(winner, bettingCards);
    }

    /**
     * A method that checks whether two WarPlayers have enough cards to
     * participate in a tie during war. If the players have enough cards, the
     * cards are drawn. If the player has less cards, the amount of cards drawn
     * are equivalent to the amount the player with the lowest number of cards
     * has. If there is a player with no cards, the game quits.
     *
     * @param me WarPlayer who may participate in a tie
     * @param opp other WarPlayer who may participate in a tie
     * @param bettingCards ArrayList of WarCard objects representing the WarCard
     * objects placed face-down during the tie
     */
    public void canParticipateInTie(WarPlayer me, WarPlayer opp,
            ArrayList<WarCard> bettingCards) {
        if ((me.getTotalCardsAmount() > 4) && (opp.getTotalCardsAmount() > 4)) {
            tieMechanics(me, opp, bettingCards, 4);
        } else {
            if ((me.getTotalCardsAmount() > 0) && (opp.getTotalCardsAmount()
                    > 0)) {
                if (me.getTotalCardsAmount() < opp.getTotalCardsAmount()) {
                    tieMechanics(me, opp, bettingCards,
                            me.getTotalCardsAmount());
                } else if ((me.getTotalCardsAmount()
                        > opp.getTotalCardsAmount())) {
                    tieMechanics(me, opp, bettingCards,
                            opp.getTotalCardsAmount());
                } else if (me.getTotalCardsAmount() == 0) {
                    System.out.println("You have lost this war. Thank you for "
                            + "playing.");
                    System.exit(0);
                } else if (opp.getTotalCardsAmount() == 0) {
                    System.out.println(opp.getPlayerID() + " has lost this war."
                            + " Thank you for playing.");
                    System.exit(0);
                }
            }
        }
    }

    /**
     * A method that draws cards face-down from the Player's card during a tie
     * between two Players. Returns an ArrayList of WarCard objects that were
     * drawn during the tie.
     *
     * @param me Player involved in the tie
     * @param opp other Player involved in the tie
     * @param bettingCards cards already drawn in the tie
     * @param n integer representing the number of cards to be drawn
     * @return ArrayList of WarCard objects that were drawn during the tie
     */
    public ArrayList<WarCard> tieMechanics(WarPlayer me, WarPlayer opp,
            ArrayList<WarCard> bettingCards, int n) {
        for (int i = 0; i < n; i++) {
            bettingCards.add(me.drawCard());
            bettingCards.add(opp.drawCard());
        }

        return bettingCards;
    }

    /**
     * A method that prints to the console the cards that a WarPlayer has won
     * during a tie from an ArrayList of WarCards.
     *
     * @param winner WarPlayer who won the tie
     * @param bettingCards ArrayList of WarCard representing the cards involved
     * in the tie
     */
    public void showCardsBetWon(WarPlayer winner,
            ArrayList<WarCard> bettingCards) {
        System.out.println(winner.getPlayerID() + " won: ");
        for (int i = 0; i < bettingCards.size(); i++) {
            System.out.println(bettingCards.get(i));
        }
        System.out.println();
    }

    /**
     * A method that allows the user to quit the program if they agree to do so.
     */
    public void concede() {
        System.out.println("Do you want to continue playing? (Yes/No)");
        String should = isValid.checkYesOrNo(scan);

        if (should.equalsIgnoreCase("no")) {
            System.out.println("You are conceding this war. Thank you for "
                    + "playing!");
            System.exit(0);
        } else {
            System.out.println("\nOkay, let's keep playing!\n");
        }
    }

}//end of class
