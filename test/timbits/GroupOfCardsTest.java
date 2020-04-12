/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timbits;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;


/**
 *A class to test the methods in GroupOfCards class
 * @author carrieaubin, 2020
 */
public class GroupOfCardsTest{
 
    public GroupOfCardsTest() {
    
    }
    
    /**
     * 
     * Checks that the shuffle method shuffles a GroupOfCards
     * and checks if it is equal to a copy of the original GroupOfCards
     * using the equals method and returns false as the result.
     * 
     */
    @Test
    public void testShuffleGood() {
        System.out.println("shuffleGood");
        DeckOfCards deck = new DeckOfCards();
        ArrayList<WarCard> cards1 = new ArrayList<WarCard>();
        ArrayList<WarCard> cards2 = new ArrayList<WarCard>();
        for(int i=0;i<deck.getSize();i++){
            cards1.add(deck.showCards().get(i));
            cards2.add(deck.showCards().get(i));
        }
        GroupOfCards hand = new GroupOfCards(cards1);
        GroupOfCards handCopy = new GroupOfCards(cards2);
        hand.shuffle();
        boolean expResult = false;
        boolean result = hand.showCards().equals(handCopy.showCards());
        assertEquals(expResult,result); 
    }
    
    /**
     * 
     * A method that checks if the GroupOfCards are shuffled by comparing
     * it to the original GroupOfCards using the equals method and returns true
     * as the result, meaning that the cards were not shuffled.
     * 
     */
    @Test
    public void testShuffleBad() {
        System.out.println("shuffleBad");
        DeckOfCards deck = new DeckOfCards();
        ArrayList<WarCard> cards1 = new ArrayList<WarCard>();
        ArrayList<WarCard> cards2 = new ArrayList<WarCard>();
        for(int i=0;i<deck.getSize();i++){
            cards1.add(deck.showCards().get(i));
            cards2.add(deck.showCards().get(i));
        }
        GroupOfCards hand = new GroupOfCards(cards1);
        GroupOfCards handCopy = new GroupOfCards(cards2);
//      hand.shuffle();
        boolean expResult = true;
        boolean result = hand.showCards().equals(handCopy.showCards());
        assertEquals(expResult,result); 
    }
    
    /**
     * 
     * A method that checks that a group of cards
     * is shuffled with a minimum of two cards positioned differently.
     * 
     */
    @Test
    public void testShuffleBoundary() {
        System.out.println("shuffleBoundary");
        DeckOfCards deck = new DeckOfCards();
        ArrayList<WarCard> cards1 = new ArrayList<WarCard>();
        ArrayList<WarCard> cards2 = new ArrayList<WarCard>();
        for(int i=0;i<deck.getSize();i++){
            cards1.add(deck.showCards().get(i));
            cards2.add(deck.showCards().get(i));
        }
        GroupOfCards hand = new GroupOfCards(cards1);
        GroupOfCards handCopy = new GroupOfCards(cards2);
        WarCard card1 = new WarCard();
        WarCard card2 = new WarCard();
        card1 = hand.showCards().get(0);
        card2 = hand.showCards().get(1);
        hand.showCards().remove(0);
        hand.showCards().remove(1);
        hand.addCard(card2);
        hand.addCard(card1);
        boolean expResult = false;
        boolean result = hand.showCards().equals(handCopy.showCards());
        assertEquals(expResult,result); 
    }
    
    /**
     * 
     * Test of addPlayingCards method by checking if the size of the
     * GroupOfCards increased by the size of the ArrayList of WarCards
     * added.
     * 
     */
    @Test
    public void testAddPlayingCardsGood() {
        System.out.println("addPlayingCardsGood");
        DeckOfCards deck = new DeckOfCards();
        ArrayList<WarCard> cards1 = new ArrayList<WarCard>();
        ArrayList<WarCard> cards2 = new ArrayList<WarCard>();
        ArrayList<WarCard> cards3 = new ArrayList<WarCard>();
        for(int i=0;i<26;i++){
            cards1.add(deck.showCards().get(i));
            cards2.add(deck.showCards().get(i));
        }
        for(int i=26;i>=26 && i<52;i++){
            cards3.add(deck.showCards().get(i));
        }
        GroupOfCards hand = new GroupOfCards(cards1);
        GroupOfCards handCopy = new GroupOfCards(cards2);
        hand.addPlayingCards(cards3);
        boolean expResult = true;
        boolean result = hand.getSize() == handCopy.getSize()+cards3.size();
        assertEquals(expResult,result); 
    }
    /**
     * 
     * Tests the addPlayingCards method that returns results false
     * if the GroupOfCards size is not equal to the size of GroupOfCards + 
     * ArrayList of WarCards size .
     * 
     */
    @Test
    public void testAddPlayingCardsBad() {
        System.out.println("addPlayingCardsBad");
        DeckOfCards deck = new DeckOfCards();
        ArrayList<WarCard> cards1 = new ArrayList<WarCard>();
        ArrayList<WarCard> cards2 = new ArrayList<WarCard>();
        ArrayList<WarCard> cards3 = new ArrayList<WarCard>();
        for(int i=0;i<26;i++){
            cards1.add(deck.showCards().get(i));
            cards2.add(deck.showCards().get(i));
        }
        for(int i=26;i>=26 && i<52;i++){
            cards3.add(deck.showCards().get(i));
        }
        GroupOfCards hand = new GroupOfCards(cards1);
        GroupOfCards handCopy = new GroupOfCards(cards2);
//        hand.addPlayingCards(cards3);
        boolean expResult = false;
        boolean result = hand.getSize() == handCopy.getSize()+cards3.size();
        assertEquals(expResult,result); 
    }
    
    /**
     * 
     * A method that adds an ArrayList of WarCards to a GroupOfCards 
     * making its size reach its maximum 52.
     *  
     */
    @Test
    public void testAddPlayingCardsBoundary() {
        System.out.println("addPlayingCardsBoundary");
        DeckOfCards deck = new DeckOfCards();
        ArrayList<WarCard> cards1 = new ArrayList<WarCard>();
        ArrayList<WarCard> cards3 = new ArrayList<WarCard>();
        for(int i=0;i<26;i++){
            cards1.add(deck.showCards().get(i));
        }
        for(int i=26;i>=26 && i<52;i++){
            cards3.add(deck.showCards().get(i));
        }
        GroupOfCards hand = new GroupOfCards(cards1);
        hand.addPlayingCards(cards3);
        boolean expResult = true;
        boolean result = hand.getSize() == 52;
        assertEquals(expResult,result); 
    }

    /**
     * 
     * Test of addCard method checks if the size of the GroupOfCards
     * increased by one to confirm that the card was added
     * .
     */
    @Test
    public void testAddCardGood() {
        System.out.println("addCardGood");
        DeckOfCards deck = new DeckOfCards();
        ArrayList<WarCard> cards1 = new ArrayList<WarCard>();
        ArrayList<WarCard> cards2 = new ArrayList<WarCard>();
        ArrayList<WarCard> cards3 = new ArrayList<WarCard>();
        for(int i=0;i<26;i++){
            cards1.add(deck.showCards().get(i));
            cards2.add(deck.showCards().get(i));
        }
        for(int i=26;i>=26 && i<52;i++){
            cards3.add(deck.showCards().get(i));
        }
        GroupOfCards hand = new GroupOfCards(cards1);
        GroupOfCards handCopy = new GroupOfCards(cards2);
        GroupOfCards hand2 = new GroupOfCards(cards3);
        WarCard card = new WarCard();
        card = hand2.showCards().get(0);
        hand.addCard(card);
        boolean expResult = true;
        boolean result = hand.getSize() == handCopy.getSize()+1;
        assertEquals(expResult,result); 
    }
    
    /**
     * 
     * Test of addCard method that returns results false if the 
     * GroupOfCards size is not equal to the size of GroupOfCards + 1.
     * 
     */
    @Test
    public void testAddCardBad() {
        System.out.println("addCardBad");
        DeckOfCards deck = new DeckOfCards();
        ArrayList<WarCard> cards1 = new ArrayList<WarCard>();
        ArrayList<WarCard> cards2 = new ArrayList<WarCard>();
        ArrayList<WarCard> cards3 = new ArrayList<WarCard>();
        for(int i=0;i<26;i++){
            cards1.add(deck.showCards().get(i));
            cards2.add(deck.showCards().get(i));
        }
        for(int i=26;i>=26 && i<52;i++){
            cards3.add(deck.showCards().get(i));
        }
        GroupOfCards hand = new GroupOfCards(cards1);
        GroupOfCards handCopy = new GroupOfCards(cards2);
        GroupOfCards hand2 = new GroupOfCards(cards3);
        WarCard card = new WarCard();
        card = hand2.showCards().get(0);
//        hand.addCard(card);
        boolean expResult = false;
        boolean result = hand.getSize() == handCopy.getSize()+1;
        assertEquals(expResult,result); 

        
    }
    
    /**
     * 
     * A method that adds a card to a deck of cards with 51 cards
     * is accepted, 52 being the maximum amount of cards a 
     * GroupOfCards can have.
     * 
     */
    @Test
    public void testAddCardBoundary() {
        System.out.println("addCardBoundary");
        DeckOfCards deck = new DeckOfCards();
        ArrayList<WarCard> cards1 = new ArrayList<WarCard>();
        ArrayList<WarCard> cards2 = new ArrayList<WarCard>();
        for(int i=0;i<deck.getSize()-1;i++){
            cards1.add(deck.showCards().get(i));
        }
        cards2.add(deck.showCards().get(51));
        GroupOfCards hand = new GroupOfCards(cards1);
        GroupOfCards hand2 = new GroupOfCards(cards2);
        WarCard cardAdded = new WarCard();
        cardAdded = hand2.showCards().get(0);
        hand.addCard(cardAdded);
        boolean expResult = true;
        boolean result = hand.getSize() == 52;
        assertEquals(expResult,result); 
    }

    /**
     * 
     * A test that gives the method removePlayingCards an int 
     * value to remove the number of cards from hand and 
     * checks of correct number of cards are removed by 
     * comparing it to handCopy.
     * 
     */
    @Test
    public void testRemovePlayingCardsGood() {
        System.out.println("removePlayingCardsGood");
        DeckOfCards deck = new DeckOfCards();
        ArrayList<WarCard> cards1 = new ArrayList<WarCard>();
        ArrayList<WarCard> cards2 = new ArrayList<WarCard>();
        for(int i=0;i<deck.getSize();i++){
            cards1.add(deck.showCards().get(i));
            cards2.add(deck.showCards().get(i));
        }
        GroupOfCards hand = new GroupOfCards(cards1);
        GroupOfCards handCopy = new GroupOfCards(cards2);
        hand.removePlayingCards(4);
        boolean expResult = true;
        boolean result = hand.getSize() == handCopy.getSize()-4;
        assertEquals(expResult,result); 
    }
    
    /**
     * 
     * Test of removePlayingCards method, that returns the results true if the 
     * GroupOfCards size equals the original GroupOfCards size.
     * 
     */
    @Test
    public void testRemovePlayingCardsBad() {
        System.out.println("removePlayingCardsBad");
        DeckOfCards deck = new DeckOfCards();
        ArrayList<WarCard> cards1 = new ArrayList<WarCard>();
        ArrayList<WarCard> cards2 = new ArrayList<WarCard>();
        for(int i=0;i<5;i++){
            cards1.add(deck.showCards().get(i));
            cards2.add(deck.showCards().get(i));
        }
        GroupOfCards hand = new GroupOfCards(cards1);
        GroupOfCards handCopy = new GroupOfCards(cards2);
//        hand.removePlayingCards(5);
        boolean expResult = true;
        boolean result = hand.getSize() == handCopy.getSize();
        assertEquals(expResult,result); 
    }
    
    /**
     * 
     * A method that checks that the number of cards removed is 
     * equal to the size of the GroupOfCards is accepted by the
     * removePlayingCards method.
     *
     */
    @Test
    public void testRemovePlayingCardsBoundary() {
        System.out.println("removePlayingCardsBoundary");
        DeckOfCards deck = new DeckOfCards();
        ArrayList<WarCard> cards1 = new ArrayList<WarCard>();
        ArrayList<WarCard> cards2 = new ArrayList<WarCard>();
        ArrayList<WarCard> cards3 = new ArrayList<WarCard>();
        for(int i=0;i<5;i++){
            cards1.add(deck.showCards().get(i));
            cards2.add(deck.showCards().get(i));
        }
        GroupOfCards hand = new GroupOfCards(cards1);
        GroupOfCards handCopy = new GroupOfCards(cards2);
        hand.removePlayingCards(4);
        boolean expResult = true;
        boolean result = hand.getSize() == handCopy.getSize()-4;
        assertEquals(expResult,result); 
    }
    
}//end of class
