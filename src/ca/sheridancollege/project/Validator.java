/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author maizi
 */
public class Validator {
    
    /**
     * A method to check if an object is of class Integer and is greater than
     * zero.
     *
     * @param value the object that needs to be checked as an Integer object
     * greater than zero.
     * @return boolean true if value is of class Integer and is greater than
     * zero or false if not.
     */
    public boolean isPositiveInt(Object value) {
        boolean isPositiveInt = false;
        if (value instanceof Integer) {
            int newVal = (int) value;
            if (newVal > 0) {
                isPositiveInt = true;
            }
        }
        return isPositiveInt;
    }
    
    public boolean isValidString(Object value) {
        boolean isString = false;
        if (value instanceof String) {
            String newVal = (String) value;
            if (!newVal.trim().equals("")) {
                isString = true;
            }
        }
        return isString;
    }
    
    /**
     * A method that takes a Scanner object as input and checks if the input is
     * a valid String. If the input is not a valid String (i.e. is null or
     * empty), the method continuously reprompts the user until the input is a
     * valid String.
     *
     * @param scan Scanner object that takes user input.
     * @return a valid String.
     */
    public String checkString(Scanner scan) {
        String value = "";
        boolean isString = false;
        do {
            try {
                value = scan.nextLine();
                if (value == null) {
                    throw new NullPointerException("The string can't be a null"
                            + " object!");
                } else if (value.trim().equals("")) {
                    throw new IllegalArgumentException("Your string can't be "
                            + "empty!");
                }
                isString = true;
            } catch (Exception x) {
                System.out.println(x.getMessage());
            }
        } while (!isString);
        return value;
    }
    
    /**
     * A method to check if an object is of class Integer and is zero or greater
     * than zero.
     *
     * @param value the object that needs to be checked as an Integer object
     * that is zero or greater than zero.
     * @return boolean true if value is of class Integer and is zero or greater
     * than zero or false if not.
     */
    public boolean isZeroAndGreaterInt(Object value) {
        boolean isInt = false;
        if (value instanceof Integer) {
            int newVal = (int) value;
            if (newVal > -1) {
                isInt = true;
            }
        }
        return isInt;
    }
    
}
