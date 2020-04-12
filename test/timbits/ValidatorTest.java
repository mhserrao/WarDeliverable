/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timbits;

import java.util.Scanner;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * A class that tests the methods in the Validator class.
 *
 * @author Maiziel Serrao
 */
public class ValidatorTest {

    public ValidatorTest() {
    }

    //Tests for isPositiveInt() method
    
    /**
     * A test that gives the isPositiveInt() method a valid positive integer and
     * expects a true result.
     */
    @Test
    public void testIsIntGood() {
        System.out.println("isPositiveInt");
        Object value = 15;
        Validator instance = new Validator();
        boolean expResult = true;
        boolean result = instance.isPositiveInt(value);
        assertEquals(expResult, result);
    }

    /**
     * A test that gives the isPositiveInt() method an invalid integer and
     * expects a false result.
     */
    @Test
    public void testIsIntBadInt() {
        System.out.println("isPositiveInt");
        Object value = -10;
        Validator instance = new Validator();
        boolean expResult = false;
        boolean result = instance.isPositiveInt(value);
        assertEquals(expResult, result);
    }

    /**
     * A test that gives the isPositiveInt() method a string and expects a false
     * result.
     */
    @Test
    public void testIsIntBadString() {
        System.out.println("isPositiveInt");
        Object value = "LOL";
        Validator instance = new Validator();
        boolean expResult = false;
        boolean result = instance.isPositiveInt(value);
        assertEquals(expResult, result);
    }

    /**
     * A test that gives the isPositiveInt() method a string and expects a false
     * result.
     */
    @Test
    public void testIsIntBadNull() {
        System.out.println("isPositiveInt");
        Object value = 29.5;
        Validator instance = new Validator();
        boolean expResult = false;
        boolean result = instance.isPositiveInt(value);
        assertEquals(expResult, result);
    }

    /**
     * A test that gives the isPositiveInt() method a double and expects a false
     * result.
     */
    @Test
    public void testIsIntBadDouble() {
        System.out.println("isPositiveInt");
        Object value = null;
        Validator instance = new Validator();
        boolean expResult = false;
        boolean result = instance.isPositiveInt(value);
        assertEquals(expResult, result);
    }

    /**
     * A test that gives the isPositiveInt() method a maximum positive integer
     * value and expects a true result.
     */
    @Test
    public void testIsIntUpperBoundary() {
        System.out.println("isInt");
        Object value = Integer.MAX_VALUE;
        Validator instance = new Validator();
        boolean expResult = true;
        boolean result = instance.isPositiveInt(value);
        assertEquals(expResult, result);
    }

    /**
     * A test that gives the isPositiveInt() method 0 and expects a false
     * result.
     */
    @Test
    public void testIsIntLowerBoundary() {
        System.out.println("isInt");
        Object value = 0;
        Validator instance = new Validator();
        boolean expResult = false;
        boolean result = instance.isPositiveInt(value);
        assertEquals(expResult, result);
    }

    //Tests for isValidString() method
    /**
     * A test that gives the isValidString() method a valid string and expects a
     * true result.
     */
    @Test
    public void testIsValidStringGood() {
        System.out.println("isValidString");
        Object value = "Yes, it works";
        Validator instance = new Validator();
        boolean expResult = true;
        boolean result = instance.isValidString(value);
        assertEquals(expResult, result);
    }

    /**
     * A test that gives the isValidString() method an invalid String with only
     * spaces and expects a false result.
     */
    @Test
    public void testIsValidStringBadStringSpaces() {
        System.out.println("isValidString");
        Object value = "      ";
        Validator instance = new Validator();
        boolean expResult = false;
        boolean result = instance.isValidString(value);
        assertEquals(expResult, result);
    }

    /**
     * A test that gives the isValidString() method a null String and expects a
     * false result.
     */
    @Test
    public void testIsValidStringBadStringNull() {
        System.out.println("isValidString");
        Object value = null;
        Validator instance = new Validator();
        boolean expResult = false;
        boolean result = instance.isValidString(value);
        assertEquals(expResult, result);
    }

    /**
     * A test that gives the isValidString() method a String with one character
     * and expects a true result.
     */
    @Test
    public void testIsValidStringBoundary() {
        System.out.println("isValidString");
        Object value = "m";
        Validator instance = new Validator();
        boolean expResult = true;
        boolean result = instance.isValidString(value);
        assertEquals(expResult, result);
    }

    //Tests for isZeroAndGreaterInt() method
    
    /**
     * A test that gives the isZeroAndGreaterInt() method a valid integer and
     * expects a true result.
     */
    @Test
    public void testIsZeroAndGreaterIntGood() {
        System.out.println("isZeroAndGreaterInt");
        Object value = 15;
        Validator instance = new Validator();
        boolean expResult = true;
        boolean result = instance.isZeroAndGreaterInt(value);
        assertEquals(expResult, result);
    }

    /**
     * A test that gives the isZeroAndGreaterInt() method an integer below zero
     * expects a false result.
     */
    @Test
    public void testIsZeroAndGreaterBadInteger() {
        System.out.println("isZeroAndGreaterInt");
        Object value = -15;
        Validator instance = new Validator();
        boolean expResult = false;
        boolean result = instance.isZeroAndGreaterInt(value);
        assertEquals(expResult, result);
    }

    /**
     * A test that gives the isZeroAndGreaterInt() method a String value and
     * expects a false result.
     */
    @Test
    public void testIsZeroAndGreaterBadString() {
        System.out.println("isZeroAndGreaterInt");
        Object value = "hi";
        Validator instance = new Validator();
        boolean expResult = false;
        boolean result = instance.isZeroAndGreaterInt(value);
        assertEquals(expResult, result);
    }

    /**
     * A test that gives the isZeroAndGreaterInt() method a null value and
     * expects a false result.
     */
    @Test
    public void testIsZeroAndGreaterBadNull() {
        System.out.println("isZeroAndGreaterInt");
        Object value = null;
        Validator instance = new Validator();
        boolean expResult = false;
        boolean result = instance.isZeroAndGreaterInt(value);
        assertEquals(expResult, result);
    }

    /**
     * A test that gives the isZeroAndGreaterInt() method a double value and
     * expects a false result.
     */
    @Test
    public void testIsZeroAndGreaterBadDouble() {
        System.out.println("isZeroAndGreaterInt");
        Object value = 29.5;
        Validator instance = new Validator();
        boolean expResult = false;
        boolean result = instance.isZeroAndGreaterInt(value);
        assertEquals(expResult, result);
    }

    /**
     * A test that gives the isZeroAndGreaterInt() method the maximum positive
     * integer value and expects a true result.
     */
    @Test
    public void testIsZeroAndGreaterUpperBoundary() {
        System.out.println("isZeroAndGreaterInt");
        Object value = Integer.MAX_VALUE;
        Validator instance = new Validator();
        boolean expResult = true;
        boolean result = instance.isZeroAndGreaterInt(value);
        assertEquals(expResult, result);
    }

    /**
     * A test that gives the isZeroAndGreaterInt() method the minimum valid
     * integer value and expects a true result.
     */
    @Test
    public void testIsZeroAndGreaterLowerBoundary() {
        System.out.println("isZeroAndGreaterInt");
        Object value = 0;
        Validator instance = new Validator();
        boolean expResult = true;
        boolean result = instance.isZeroAndGreaterInt(value);
        assertEquals(expResult, result);
    }

}//end of class

