/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author maizi
 */
public class DeckOfCards extends GroupOfCards {
    
    //uses PlayingCard class (child of Card class) and Suit and Value enum classes of 
    //the Card class

    public DeckOfCards() {
        super(52);
        ArrayList<PlayingCard> newDeck = new ArrayList<PlayingCard>(52);

        int countCards = 0;
        Suit[] suitArray = Suit.values();
        Value[] valuesArray = Value.values();

        for (int i = 0; i < suitArray.length; i++) {
            Suit newSuit = suitArray[i];
            for (int j = 0; j < valuesArray.length; j++) {
                Value newValue = valuesArray[j];
                PlayingCard newCard = new PlayingCard(newValue, newSuit);
                newDeck.add(newCard);
            }
        }
        setPlayingCards(newDeck);
    }
}
