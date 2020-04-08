/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timbits;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author maizi
 */
public class WarTest {
    
    public WarTest() {
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
//    public ArrayList<WarCard> tieMechanics(WarPlayer me, WarPlayer opp,
//            ArrayList<WarCard> bettingCards, int n) {
//        for (int i = 0; i < n; i++) {
//            bettingCards.add(me.drawCard());
//            bettingCards.add(opp.drawCard());
//        }
//
//        return bettingCards;
//    }
//    
//    
//    /**
//     * A method that checks whether two WarPlayers have enough cards to
//     * participate in a tie during war. If the players have enough cards, the
//     * cards are drawn. If the player has less cards, the amount of cards drawn
//     * are equivalent to the amount the player with the lowest number of cards
//     * has. If there is a player with no cards, the game quits.
//     *
//     * @param me WarPlayer who may participate in a tie
//     * @param opp other WarPlayer who may participate in a tie
//     * @param bettingCards ArrayList of WarCard objects representing the WarCard
//     * objects placed face-down during the tie
//     */
//    public void canParticipateInTie(WarPlayer me, WarPlayer opp,
//            ArrayList<WarCard> bettingCards) {
//        if ((me.getTotalCardsAmount() > 4) && (opp.getTotalCardsAmount() > 4)) {
//            tieMechanics(me, opp, bettingCards, 4);
//        } else {
//            if ((me.getTotalCardsAmount() > 0) && (opp.getTotalCardsAmount()
//                    > 0)) {
//                if (me.getTotalCardsAmount() < opp.getTotalCardsAmount()) {
//                    tieMechanics(me, opp, bettingCards,
//                            me.getTotalCardsAmount());
//                } else if ((me.getTotalCardsAmount()
//                        > opp.getTotalCardsAmount())) {
//                    tieMechanics(me, opp, bettingCards,
//                            opp.getTotalCardsAmount());
//                } else if (me.getTotalCardsAmount() == 0) {
//                    System.out.println("You have lost this war. Thank you for "
//                            + "playing.");
//                    System.exit(0);
//                } else if (opp.getTotalCardsAmount() == 0) {
//                    System.out.println(opp.getPlayerID() + " has lost this war."
//                            + " Thank you for playing.");
//                    System.exit(0);
//                }
//            }
//        }
//    }
//    
//    /**
//     * A method that takes in two WarPlayer objects and determines the winner of
//     * a tie in a round. The winner gets the cards added to their cardsWon pile.
//     * If the WarPlayer runs out of cards or has less than 4 cards total, the
//     * method gives the cards by default to the WarPlayer with the most cards.
//     *
//     * @param me WarPlayer involved in the tie
//     * @param opp other WarPlayer involved in the tie
//     * @param bettingCards ArrayList of WarCard objects representing the WarCard
//     * objects placed face-down during the tie
//     */
//    public void tie(WarPlayer me, WarPlayer opp,
//            ArrayList<WarCard> bettingCards) {
//        boolean stillATie = true;
//        WarPlayer winner = me;
//        int counter = 0;
//
//        do {
//            canParticipateInTie(me, opp, bettingCards);
//
//            WarCard yourBet = bettingCards.get(bettingCards.size() - 1);
//            WarCard myBet = bettingCards.get(bettingCards.size() - 2);
//
//            System.out.println(me.getPlayerID() + " drew " + myBet.toString()
//                    + "!");
//            System.out.println(opp.getPlayerID() + " drew " + yourBet.toString()
//                    + "!");
//
//            if (myBet.getRank().getCardNumber()
//                    > yourBet.getRank().getCardNumber()) {
//                System.out.println("\n" + me.getPlayerID() + " is the winner of"
//                        + " this war!\n");
//                me.addToWonCards(bettingCards);
//                winner = me;
//                stillATie = false;
//            } else if (myBet.getRank().getCardNumber()
//                    < yourBet.getRank().getCardNumber()) {
//                System.out.println("\n" + opp.getPlayerID() + " is the winner "
//                        + "of this war!\n");
//                opp.addToWonCards(bettingCards);
//                winner = opp;
//                stillATie = false;
//            } else {
//                System.out.println("\nIt's still a tie! You must enter another"
//                        + " war!\n");
//                counter++;
//                if (counter > 0 && me.getTotalCardsAmount() <= 4) {
//                    opp.addToWonCards(bettingCards);
//                    System.out.println(opp.getPlayerID() + " won by default.");
//                    break;
//                } else if (counter > 1 && opp.getTotalCardsAmount() <= 4) {
//                    me.addToWonCards(bettingCards);
//                    System.out.println(me.getPlayerID() + " won by default.");
//                    break;
//                }
//            }
//        } while (stillATie);
//
//        showCardsBetWon(winner, bettingCards);
//    }
    
    /* Manual test script for canParticipateInTie() method - when both 
    WarPlayers have more than 4 cards
    
    - User calls the canParticipateInTie() method with a parameter of WarPlayer 
    w1 that has a total of 25 cards, a parameter of WarPlayer w2 that has a 
    total of 25 cards, an ArrayList of WarCard (bettingCards) containing 2 
    WarCards, and another parameter of 4 (representing the number of cards bet 
    in the war).
    - Since both w1 and w2 will have a total amount of cards greater than 4, the
    first condition.
    - Call the tieMechanics() method with parameters w1, w2, bettingCards and 4.,
    - The tieMechanics() method should produce an ArrayList of a total of 10 
    WarCard objects (2 from the parameter itself, 4 from w1 and 4 from w2).
    - 
    */
    
    
}//end of class


/**
//     * MANUAL
//     */
//    @Test
//    public void testPlay() {
//        System.out.println("play");
//        Player me = null;
//        Player opp = null;
//        War instance = new War();
//        instance.play(me, opp);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of declareWinner method, of class War.
//     */
//    @Test
//    public void testDeclareWinner() {
//        System.out.println("declareWinner");
//        Player me = null;
//        Player opp = null;
//        War instance = new War();
//        instance.declareWinner(me, opp);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of dealCards method, of class War.
//     */
//    @Test
//    public void testDealCards() {
//        System.out.println("dealCards");
//        WarPlayer me = null;
//        WarPlayer opp = null;
//        DeckOfCards deck = null;
//        War instance = new War();
//        instance.dealCards(me, opp, deck);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of round method, of class War.
//     */
//    @Test
//    public void testRound() {
//        System.out.println("round");
//        WarPlayer me = null;
//        WarPlayer opp = null;
//        War instance = new War();
//        instance.round(me, opp);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of tie method, of class War.
//     */
//    @Test
//    public void testTie() {
//        System.out.println("tie");
//        WarPlayer me = null;
//        WarPlayer opp = null;
//        ArrayList<WarCard> bettingCards = null;
//        War instance = new War();
//        instance.tie(me, opp, bettingCards);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of canParticipateInTie method, of class War.
//     */
//    @Test
//    public void testCanParticipateInTie() {
//        System.out.println("canParticipateInTie");
//        WarPlayer me = null;
//        WarPlayer opp = null;
//        ArrayList<WarCard> bettingCards = null;
//        War instance = new War();
//        instance.canParticipateInTie(me, opp, bettingCards);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of tieMechanics method, of class War.
//     */
//    @Test
//    public void testTieMechanics() {
//        System.out.println("tieMechanics");
//        WarPlayer me = null;
//        WarPlayer opp = null;
//        ArrayList<WarCard> bettingCards = null;
//        int n = 0;
//        War instance = new War();
//        ArrayList<WarCard> expResult = null;
//        ArrayList<WarCard> result = instance.tieMechanics(me, opp, bettingCards, n);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of showCardsBetWon method, of class War.
//     */
//    @Test
//    public void testShowCardsBetWon() {
//        System.out.println("showCardsBetWon");
//        WarPlayer winner = null;
//        ArrayList<WarCard> bettingCards = null;
//        War instance = new War();
//        instance.showCardsBetWon(winner, bettingCards);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of concede method, of class War.
//     */
//    @Test
//    public void testConcede() {
//        System.out.println("concede");
//        War instance = new War();
//        instance.concede();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }