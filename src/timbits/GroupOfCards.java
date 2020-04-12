/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package timbits;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for War. Every
 * GroupOfCards object is composed of an ArrayList of WarCard of a specific
 * size.
 *
 * @author dancye
 * @modifiedBy Carrie Aubin
 */
public class GroupOfCards {

    //uses PlayingCard class (child of the abstract Card class)
    //The group of cards, stored in an ArrayList
    private ArrayList<WarCard> cards = new ArrayList<WarCard>();
    private int size = this.cards.size();//the size of the grouping

    Validator isValid = new Validator(); //used for validation of inputs

    /**
     * A constructor for a GroupOfCards object. Takes in an integer value
     * representing the desired size of the GroupOfCards object.
     *
     * @param givenSize - integer representing the desired size
     */
    public GroupOfCards(int givenSize) {
        setSize(givenSize);
    }

    /**
     * The default constructor of the GroupOfCards object.
     */
    public GroupOfCards() {
    }

    /**
     * A constructor of the GroupOfCards object. Takes in an ArrayList of
     * WarCard objects and sets the cards of the GroupOfCards object to this
     * ArrayList.
     *
     * @param cards - ArrayList of WarCard objects representing the cards within
     * the GroupOfCards object.
     */
    public GroupOfCards(ArrayList<WarCard> cards) {
        setPlayingCards(cards);
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<WarCard> showCards() {
        return cards;
    }

    /**
     * A method that the reorders the cards within the GroupOfCards objects in a
     * random fashion.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * A method that returns the size of the GroupOfCards object.
     *
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * A method that takes in an integer parameter and sets the size of the
     * GroupOfCards object based on that integer.
     *
     * @param givenSize the max size for the group of cards
     * @throws IllegalArgumentException if the size is a negative integer
     */
    public void setSize(int givenSize) throws IllegalArgumentException {
        if (!isValid.isZeroAndGreaterInt(givenSize)) {
            throw new IllegalArgumentException("Please enter a non-negative "
                    + "number!");
        }
        this.size = givenSize;
    }

    /**
     * A method that sets the cards of the GroupOfCards object to an ArrayList
     * of WarCard objects.
     *
     * @param cards the cards to set
     */
    public void setPlayingCards(ArrayList<WarCard> cards) {
        this.cards = cards;
        this.size = this.cards.size();
    }

    /**
     * A method that adds an ArrayList of WarCard object to the cards of a
     * GroupOfCards object.
     *
     * @param cards - WarCard objects to be added to the cards of a GroupOfCards
     * object
     */
    public void addPlayingCards(ArrayList<WarCard> cards) {
        this.cards.addAll(cards);
        this.size = this.cards.size();
    }

    /**
     * A method that adds a WarCard object to the cards of a GroupOfCards
     * object.
     *
     * @param cardWon the WarCard to be added to the cards of the GroupOfCards
     * object
     */
    public void addCard(WarCard cardWon) {
        this.cards.add(cardWon);
        this.size = this.cards.size();
    }

    /**
     * A method that removes a specified number of WarCard objects from the
     * cards of a GroupOfCards object. Once removed, the WarCard objects are
     * returned as an ArrayList of WarCard objects.
     *
     * @param n the number of WarCard objects to be removed
     * @return ArrayList of WarCard objects that were removed from the cards of
     * the GroupOfCards object
     */
    public ArrayList<WarCard> removePlayingCards(int n) {
        ArrayList<WarCard> lostCards = new ArrayList<WarCard>();
        if (n <= this.cards.size() && isValid.isPositiveInt(n)) {
            for (int i = 0; i < n; i++) {
                lostCards.add(this.cards.remove(cards.size() - 1));
            }
        }
        this.size = this.cards.size();
        return lostCards;
    }

}//end of class
