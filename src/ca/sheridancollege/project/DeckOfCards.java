/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import ca.sheridancollege.project.WarCard.Rank;
import ca.sheridancollege.project.WarCard.Suit;
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
        ArrayList<WarCard> newDeck = new ArrayList<WarCard>(52);

        int countCards = 0;
        Suit[] suitArray = Suit.values();
        Rank[] valuesArray = Rank.values();

        for (int i = 0; i < suitArray.length; i++) {
            Suit newSuit = suitArray[i];
            for (int j = 0; j < valuesArray.length; j++) {
                Rank newRank = valuesArray[j];
                WarCard newCard = new WarCard(newSuit, newRank);
                newDeck.add(newCard);
            }
        }
        setPlayingCards(newDeck);
    }
}
