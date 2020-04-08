/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timbits;

import timbits.WarCard.Rank;
import timbits.WarCard.Suit;
import java.util.ArrayList;

/**
 * A class that represents a deck of playing cards. Contains 52 card objects
 * that contain all combinations of a suit and rank to imitate real-life playing
 * cards.
 *
 * @author Thy Nguyen
 */
public class DeckOfCards extends GroupOfCards {

    /**
     * The default constructor for the DeckOfCards object. Creates a DeckOfCards
     * object that contains 52 playing cards. Each playing card is composed of a
     * different combination of a suit and rank.
     */
    public DeckOfCards() {
        super(52);
        ArrayList<WarCard> newDeck = new ArrayList<WarCard>(52);

        int countCards = 0;
        Suit[] suitArray = Suit.values();
        Rank[] valuesArray = Rank.values();

//        for (int i = 0; i < 4; i++){
//            Suit newSuit = Suit.SPADES;
//            for (int j =0 ; j < 5; j++) {
//                Rank newRank = valuesArray[j];
//                WarCard newCard = new WarCard(newSuit, newRank);
//                newDeck.add(newCard);
//            } 
//        }
        for (int i = 0; i < suitArray.length; i++) {
            Suit newSuit = suitArray[i];
            for (int j = 0; j < valuesArray.length; j++) {
                Rank newRank = valuesArray[j];
                WarCard newCard = new WarCard(newSuit, newRank);
                newDeck.add(newCard);
            }
        }
        setPlayingCards(newDeck);
    }//end of constructor

}//end class
