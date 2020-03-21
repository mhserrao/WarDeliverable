/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the
 * code should remember to add themselves as a modifier.
 *
 * @author dancye, 2018
 */
public abstract class Card {

    public enum Suit {
        HEARTS(4),
        DIAMONDS(3),
        SPADES(2),
        CLUBS(1);

        private final int SHAPE;

        Suit(int shape) {
            this.SHAPE = shape;
        }

        public int getShape() {
            return SHAPE;
        }
    }

    public enum Rank {
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13),
        ACE(14);

        private final int CARDNUMBER;

        Rank(int i) {
            this.CARDNUMBER = i;
        }

        public int getCardNumber() {
            return CARDNUMBER;
        }
    }
    //default modifier for child classes

    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a
     * regular playing card etc.
     */
    @Override
    public abstract String toString();

}
