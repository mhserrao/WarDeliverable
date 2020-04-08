/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timbits;

import java.util.ArrayList;

/**
 * This class is used to create a War card game Player.
 *
 * @author Jovanka Milosevic
 * @modifiedby Maiziel Serrao
 */
public class WarPlayer extends Player {

    private GroupOfCards playersCards = new GroupOfCards();
    //represents the cards the WarPlayer has in their pile
    private GroupOfCards cardsWon = new GroupOfCards();
    //represents the cards the WarPlayer has won

    /**
     * Constructor of the WarPlayer object. Takes in a String and sets the
     * WarPlayer's player ID to that String.
     *
     * @param name
     */
    public WarPlayer(String name) {
        super(name);
    }

    /**
     * Default constructor of the WarPlayer object. Sets the player ID of the
     * WarPlayer to "Trump".
     */
    public WarPlayer() {
        super("Trump");
    }

    /**
     * A method that allows a WarPlayer to draw a card if they have cards in
     * their pile. If the WarPlayer doesn't have cards in their pile, they can
     * shuffle their cards from their cards won pile into their pile. If the
     * player has no more cards, they exit the game.
     *
     * @return WarCard representing the card drawn
     */
    @Override
    public WarCard play() {
        WarCard card = new WarCard();
        if (checkPile()) {
            card = drawCard();
        } else if (!checkPile() && checkCardsWonPile()) {
            changePiles();
            card = drawCard();
        } else {
            System.out.println("You have no more cards!");
            System.out.println("You have lost this war. Thanks for playing!");
            System.exit(0);
        }
        return card;
    }

    /**
     * A method that checks if a WarPlayer has any cards at all in either of
     * their piles.
     *
     * @return true if a WarPlayer owns any WarCards at all
     */
    public boolean checkPile() {
        if (this.getPlayersCards().getSize() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * A method that allows the WarPlayer to draw a WarCard from their pile if
     * they have any cards.
     *
     * @return WarCard representing the card drawn.
     */
    public WarCard drawCard() {
        changePiles();
        WarCard betCard = new WarCard();
        betCard = (this.getPlayersCards().removePlayingCards(1)).get(0);
        return betCard;
    }

    /**
     * A method that allows the WarPlayer to shuffle cards from the cardsWon
     * pile into their players cards pile, if they have cards in their cardsWon
     * pile.
     */
    public void changePiles() {
        ArrayList<WarCard> newCards = new ArrayList<WarCard>();
        if (!checkPile() && checkCardsWonPile()) {
            newCards = this.getCardsWon().
                    removePlayingCards(getCardsWon().getSize());
            this.getPlayersCards().addPlayingCards(newCards);
            System.out.println(getPlayerID() + "'s deck is being shuffled. "
                    + getPlayerID() + " has " + getPlayersCards().getSize()
                    + " cards.");
        }
    }

    /**
     * A method that checks if there are cards in a WarPlayer's cardsWon pile.
     *
     * @return true if there are cards in the cardsWon pile.
     */
    public boolean checkCardsWonPile() {
        if (this.getCardsWon().getSize() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * A method that returns the WarPlayer's players cards.
     *
     * @return the playersCards associated with a WarPlayer.
     */
    public GroupOfCards getPlayersCards() {
        return playersCards;
    }

    /**
     * A method that takes in a GroupOfCards and sets the players cards to be
     * those GroupOfCards.
     *
     * @param playersCards GroupOfCards that represents the players cards.
     */
    public void setPlayersCards(GroupOfCards playersCards) {
        this.playersCards = playersCards;
    }

    /**
     * A method that returns a GroupOfCards object that represents the
     * WarPlayer's cards won pile.
     *
     * @return GroupOfCards object representing the cards won pile of the
     * WarPlayer
     */
    public GroupOfCards getCardsWon() {
        return cardsWon;
    }

    /**
     * A method that takes in a GroupOfCards object and sets the WarPlayer's
     * cards won pile to the GroupOfCards object.
     *
     * @param cardsWon GroupOfCards object representing the new cards won pile
     * of the WarPlayer
     */
    public void setCardsWon(GroupOfCards cardsWon) {
        this.cardsWon = cardsWon;
    }

    /**
     * A method that returns true if a WarPlayer owns any cards in either of its
     * piles.
     *
     * @return true if the WarPlayer owns at least one WarCard
     */
    public boolean checkForAnyCards() {
        if (!checkPile() && !checkCardsWonPile()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * A method that takes in a WarCard and adds it to the won cards pile of a
     * WarPlayer object.
     *
     * @param cardWon WarCard won by the WarPlayer
     */
    public void addToWonCards(WarCard cardWon) {
        this.cardsWon.addCard(cardWon);
    }

    /**
     * A method that takes in an ArrayList of WarCard objects and adds it to the
     * won cards pile of a WarPlayer object.
     *
     * @param cardWon ArrayList of WarCard won by the WarPlayer
     */
    public void addToWonCards(ArrayList<WarCard> cardsWon) {
        this.cardsWon.addPlayingCards(cardsWon);
    }

    /**
     * A method that returns the total amount of cards a WarPlayer owns in both
     * the players cards pile and the cards won pile.
     *
     * @return integer representing the total number of cards owned by a
     * WarPlayer
     */
    public int getTotalCardsAmount() {
        return playersCards.getSize() + cardsWon.getSize();
    }
    
}//end of class
