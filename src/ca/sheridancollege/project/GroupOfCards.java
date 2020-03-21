/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 * @author dancye
 */
public class GroupOfCards {
   
    //uses PlayingCard class (child of the abstract Card class)
    
    //The group of cards, stored in an ArrayList
    private ArrayList <WarCard> cards = new ArrayList <WarCard>();
    private int size = this.cards.size();//the size of the grouping
    
    Validator isValid = new Validator();
    
    public GroupOfCards(int givenSize) {
        setSize(givenSize);
    }

    public GroupOfCards() {
    }
    
    public GroupOfCards(ArrayList<WarCard> cards){
        setPlayingCards(cards);
    }
    
    /**
     * A method that will get the group of cards as an ArrayList
     * @return the group of cards.
     */
    public ArrayList<WarCard> showCards() {
        return cards;
    }
    
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param givenSize the max size for the group of cards
     */
    public void setSize(int givenSize) throws IllegalArgumentException {
        if(!isValid.isZeroAndGreaterInt(givenSize)){
            throw new IllegalArgumentException("Please enter a non-negative number!");
        }
        this.size = givenSize;
    }
    
    /**
     * @param cards the cards to set
     */
    public void setPlayingCards(ArrayList <WarCard> cards) {
        this.cards = cards;
        this.size = this.cards.size();
    }
    
    public void addPlayingCards(ArrayList <WarCard> cards) {
        this.cards.addAll(cards);
        this.size = this.cards.size();
    }
    
    public void addCard(WarCard cardWon){
        this.cards.add(cardWon);
        this.size = this.cards.size();
    }
    
    public ArrayList<WarCard> removePlayingCards(int n) {
        ArrayList<WarCard> lostCards = new ArrayList<WarCard>();
        if(n<=this.cards.size()){
            for(int i = 0; i<n; i++){
                lostCards.add(this.cards.remove(cards.size()-1));
            }
        }
        this.size = this.cards.size();
        return lostCards;
    }
}//end class
