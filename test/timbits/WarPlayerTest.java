/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timbits;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

/**
 * Tests for the methods in the WarPlayer Class
 * @author Jovanka Milosevic
 */
public class WarPlayerTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    public WarPlayerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of play method, of class WarPlayer. This test shows that app will end
     * if player doesn't have any cards in both of his piles.
     */
    @Test
    public void testPlaySystemExit() {
        WarPlayer player = new WarPlayer();
        exit.expectSystemExitWithStatus(0);
        player.play();
    }

    /**
     * Test of play method, of class WarPlayer. This test shows that the user can play
     * if there is at least one card in his playing deck.
     */
    @Test
    public void testPlaySuccesfull() {
        GroupOfCards cards = new GroupOfCards();
        WarCard card = new WarCard();
        cards.addCard(card);
        WarPlayer player = new WarPlayer();
        player.setPlayersCards(cards);
        assertEquals(card, player.play());
        assertTrue(player.getPlayersCards().getSize() == 0);
    }
    
    /**
     * Test of play method, of class WarPlayer. This test shows that if he has cards in his won cards pile,
     * but not his playing deck is empty, he'll use won cards as playing cards to continue the game.
     */
    @Test
    public void testPlaySwapDecks() {
        GroupOfCards cards = new GroupOfCards();
        WarCard card = new WarCard();
        cards.addCard(card);
        WarPlayer player = new WarPlayer();
        player.setCardsWon(cards);
        assertEquals(card, player.play());
        assertTrue(player.getPlayersCards().getSize() == 0);
        assertTrue(player.getCardsWon().getSize() == 0);
    }

    /**
     * Test of checkPile method, of class WarPlayer. This methods checks if player's
     * pile with playing cards is empty.
     */
    @Test
    public void testCheckPileEmpty() {
        WarPlayer player = new WarPlayer();
        boolean expResult = false;
        boolean result = player.checkPile();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkPile method, of class WarPlayer. This methods checks if player's
     * pile with playing cards is not empty.
     */
    @Test
    public void testCheckPileNotEmpty() {
        GroupOfCards cards = new GroupOfCards();
        WarCard card = new WarCard();
        cards.addCard(card);
        WarPlayer player = new WarPlayer();
        player.setPlayersCards(cards);
        boolean expResult = true;
        boolean result = player.checkPile();
        assertEquals(expResult, result);
    }

    /**
     * Test of drawCard method, of class WarPlayer.This test shows that if there is no card in
     * the the pile to draw.
     */
    @Test
    public void testDrawCardPileEmpty() {
        WarPlayer player = new WarPlayer();
        WarCard expResult = null;
        WarCard result = player.drawCard();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of drawCard method, of class WarPlayer.This test shows that if there is a card in
     * the player's pile to draw, it will be removed from it, added to the new ArrayList, and used to play.
     */
    @Test
    public void testDrawCardPileNotEmpty() {
        GroupOfCards cards = new GroupOfCards();
        WarCard card = new WarCard();
        cards.addCard(card);
        WarPlayer player = new WarPlayer();
        player.setPlayersCards(cards);
        assertEquals(card, player.drawCard());
        assertTrue(player.getPlayersCards().getSize() == 0);
    }
    
    /**
     * Test of drawCard method, of class WarPlayer.This test shows that if there is no card in
     * the player's pile to draw, it will be removed from the won cards pile and added to player's deck,
     * so it can be drawn and the player can continue to play.
     */
    @Test
    public void testDrawCardWonPileNotEmpty() {
        GroupOfCards cards = new GroupOfCards();
        WarCard card = new WarCard();
        cards.addCard(card);
        WarPlayer player = new WarPlayer();
        player.setCardsWon(cards);
        assertEquals(card, player.drawCard());
        assertTrue(player.getPlayersCards().getSize() == 0);
        assertTrue(player.getCardsWon().getSize() == 0);
    }

    /**
     * Test of changePiles method, of class WarPlayer. This test shows if both piles
     * are empty.
     */
    @Test
    public void testChangePilesBothEmpty() {
        WarPlayer player = new WarPlayer();
        player.changePiles();
        assertTrue(player.getPlayersCards().getSize() == 0);
        assertTrue(player.getCardsWon().getSize() == 0);
    }
    
    /**
     * Test of changePiles method, of class WarPlayer. This test shows that, if player's deck is empty, 
     * a card will be removed from the won cards pile and added to player's deck.
     */
    @Test
    public void testChangePilesPlayerCardsEmpty() {
        GroupOfCards cards = new GroupOfCards();
        WarCard card = new WarCard();
        cards.addCard(card);
        WarPlayer player = new WarPlayer();
        player.setCardsWon(cards);
        player.changePiles();
        assertTrue(player.getPlayersCards().getSize() == 1);
        assertTrue(player.getCardsWon().getSize() == 0);
    }

    /**
     * Test of checkCardsWonPile method, of class WarPlayer. This test shows if won cards
     * pile is empty.
     */
    @Test
    public void testCheckCardsWonPileEmpty() {
        WarPlayer player = new WarPlayer();
        boolean expResult = false;
        boolean result = player.checkCardsWonPile();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkCardsWonPile method, of class WarPlayer. This test shows if the won cards
     * pile wasn't empty. 
     */
    @Test
    public void testCheckCardsWonPileNotEmpty() {
        GroupOfCards cards = new GroupOfCards();
        WarCard card = new WarCard();
        cards.addCard(card);
        WarPlayer player = new WarPlayer();
        player.setCardsWon(cards);
        assertEquals(card, player.drawCard());
        assertTrue(player.getCardsWon().getSize() == 0);
    }

    /**
     * Test of checkForAnyCards method, of class WarPlayer. This test shows that
     * both piles are empty.
     */
    @Test
    public void testCheckForAnyCardsBothEmpty() {
        WarPlayer player = new WarPlayer();
        boolean expResult = false;
        boolean result = player.checkForAnyCards();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkForAnyCards method, of class WarPlayer. This test shows that
     * players pile is not empty.
     */
    @Test
    public void testCheckForAnyCardPlayersPileNotEmpty() {
        GroupOfCards cards = new GroupOfCards();
        WarCard card = new WarCard();
        cards.addCard(card);
        WarPlayer player = new WarPlayer();
        player.setPlayersCards(cards);
        assertTrue(player.checkForAnyCards());
    }
    
    /**
     * Test of checkForAnyCards method, of class WarPlayer. This test shows that
     * players won cards pile is not empty.
     */
    @Test
    public void testCheckForAnyCardWonPileNotEmpty() {
        GroupOfCards cards = new GroupOfCards();
        WarCard card = new WarCard();
        cards.addCard(card);
        WarPlayer player = new WarPlayer();
        player.setCardsWon(cards);
        assertTrue(player.checkForAnyCards());
    }

    /**
     * Test of addToWonCards method, of class WarPlayer. This test shows that if a card is null,
     * it will not be added to the won cards pile.
     */
    @Test
    public void testAddToWonCards_WarCardNull() {
        WarCard cardWon = null;
        WarPlayer player = new WarPlayer();
        player.addToWonCards(cardWon);
        assertTrue(player.getCardsWon().getSize() == 0);
    }
    
    /**
     * Test of addToWonCards method, of class WarPlayer. This test shows that if 
     * a card is valid, it will be added to the won cards pile.
     */
    @Test
    public void testAddToWonCards_WarCardNotNull() {
        GroupOfCards cards = new GroupOfCards();
        WarCard card = new WarCard();
        cards.addCard(card);
        WarPlayer player = new WarPlayer();
        player.setCardsWon(cards);
        assertTrue(player.getCardsWon().getSize() == 1);
    }
    
    
    /**
     * Test of addToWonCards method, of class WarPlayer. This test shows if the array list
     * of WarCard objects is empty.
     */
    @Test
    public void testAddToWonCards_ArrayListEmpty() {
        ArrayList<WarCard> cardsWon = new ArrayList<>();
        WarPlayer player = new WarPlayer();
        player.addToWonCards(cardsWon);
        assertTrue(player.getCardsWon().getSize() == 0);
    }
    
    /**
     * Test of addToWonCards method, of class WarPlayer.  This test shows if the array list
     * of WarCards is not empty and added to the won cards pile.
     */
    @Test
    public void testAddToWonCards_ArrayListNotEmpty() {
        ArrayList<WarCard> cardsWon = new ArrayList<>();
        cardsWon.add(new WarCard());
        WarPlayer player = new WarPlayer();
        player.addToWonCards(cardsWon);
        assertTrue(player.getCardsWon().getSize() == 1);
    }

    /**
     * Test of getTotalCardsAmount method, of class WarPlayer. This test shows that both player's
     * piles are not empty.
     */
    @Test
    public void testGetTotalCardsAmountBothNotEmpty() {
        GroupOfCards playersCards = new GroupOfCards();
        WarCard playersCard = new WarCard();
        playersCards.addCard(playersCard);

        GroupOfCards cardsWon = new GroupOfCards();
        WarCard cardWon = new WarCard();
        cardsWon.addCard(cardWon);

        WarPlayer player = new WarPlayer();
        player.setCardsWon(playersCards);
        player.setPlayersCards(playersCards);

        int expResult = 2;
        int result = player.getTotalCardsAmount();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getTotalCardsAmount method, of class WarPlayer. This test shows that both player's
     * piles are empty.
     */
    @Test
    public void testGetTotalCardsAmountBothEmpty() {
        GroupOfCards playersCards = new GroupOfCards();

        GroupOfCards cardsWon = new GroupOfCards();

        WarPlayer player = new WarPlayer();
        player.setCardsWon(playersCards);
        player.setPlayersCards(playersCards);

        int expResult = 0;
        int result = player.getTotalCardsAmount();
        assertEquals(expResult, result);
    }
    

}
