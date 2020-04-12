/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timbits;

/**
 * This class represents a class we use to make a Card object for the War card
 * game.
 *
 * @author Jovanka Milosevic
 */
public class WarCard extends Card {

    // Card's suite is implemented as an enum
    public enum Suit {

        CLUBS, DIAMONDS, HEARTS, SPADES

    } //end of Suit enum

    // Card's value is implemented as an enum
    public enum Rank {

        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9),
        TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);

        private final int CARDNUMBER;

        /**
         * Constructor of the Rank enumeration constant.
         *
         * @param i integer that represents the card number of the constant
         */
        Rank(int i) {
            this.CARDNUMBER = i;
        }

        /**
         * A method that returns the card number associated with the rank.
         *
         * @return integer representing the card number associated with the rank
         */
        public int getCardNumber() {
            return CARDNUMBER;
        }

    }//end of Rank enum

    //instance variables of WarCard object
    private Suit suit;
    private Rank rank;

    /**
     * Default constructor of a WarCard object.
     */
    WarCard() {
    }

    /**
     * A 2-parameter constructor that takes in suit and rank as parameters and
     * creates a new WarCard object with those parameters.
     *
     * @param suit The suit of the card as a parameter
     * @param rank The value of the card as a parameter
     */
    public WarCard(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * A getter that access the suit value.
     *
     * @return suit suit of the WarCard object
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * A getter that access the rank value.
     *
     * @return rank Rank of the WarCard object
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * A method that neatly prints the suit and rank of a WarCard.
     *
     * @return a String representation of a WarCard.
     */
    @Override
    public String toString() {
        return (rank + " of " + suit);
    }

    /**
     * The overridden equals method. It takes object as a parameter, checks if
     * object is instance of Card class, and if it is, compares two instances -
     * this object and the object that is passed as parameter
     *
     * @param object the object to be compared with the WarCard object.
     * @return true if objects have the same rank
     */
    @Override
    public boolean equals(Object object) {
        if (object == this) {//returns true if instances are the same
            return true;
        }
        if (object instanceof WarCard) {
            return (this.getRank().equals(((WarCard) object).getRank()));
        }
        return false;
    }

}//end of class
