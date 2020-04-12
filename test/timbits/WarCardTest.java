/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timbits;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A class that tests the WarCard class.
 *
 * @author Thy Nguyen
 */
public class WarCardTest {

    public WarCardTest() {
    }

    /**
     * Test of toString method, of class WarCard.
     */
    @Test
    public void testToStringGood() {
        System.out.println("toString");
        WarCard instance = new WarCard(WarCard.Suit.CLUBS, WarCard.Rank.ACE);
        String expResult = "ACE of CLUBS";
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    //Test of equals method of WarCard class.
    
    /**
     * A test that gives the equals() method a null object and expects a false
     * result.
     */
    @Test
    public void testEqualsBad() {
        System.out.println("equals");
        Object object = null;
        WarCard instance = new WarCard();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * A test that gives the equals() method the DIAMONDS(SUIT - enum) object
     * and expects a false result.
     */
    @Test
    public void testEqualsBoundarySuit() {
        System.out.println("equals");
        WarCard instance = new WarCard();
        boolean expResult = false;
        boolean result = instance.equals(WarCard.Suit.valueOf("DIAMONDS"));
        assertEquals(expResult, result);

    }

    /**
     * A test that gives the equals() method the JACK(RANK - enum) object and
     * expects a false result.
     */
    @Test
    public void testEqualsBoundaryRank() {
        System.out.println("equals");
        WarCard instance = new WarCard();
        boolean expResult = false;
        boolean result = instance.equals(WarCard.Rank.valueOf("JACK"));
        assertEquals(expResult, result);

    }

    /**
     * A test that gives the equals() method the JACK(RANK - enum) object and
     * the ACE(RANK- enum) and expects a true result.
     */
    @Test
    public void testEqualsGood() {
        System.out.println("equals");
        WarCard instance = new WarCard(WarCard.Suit.CLUBS, WarCard.Rank.ACE);
        boolean expResult = true;
        boolean result = instance.equals(instance);
        assertEquals(expResult, result);

    }

}//end of class
