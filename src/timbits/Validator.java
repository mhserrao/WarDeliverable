/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timbits;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A class that is meant to creates a Validator object to validate input.
 *
 * @author Maiziel Serrao
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

    /**
     * A method to check if an object is of class String and is valid in that it
     * is not composed only of white spaces and it is not equal to null.
     *
     * @param value the object that needs to be checked as a valid String
     * @return boolean true if value is a valid String
     */
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
     * A method that takes a Scanner object and String as input and checks if
     * the input is a valid String and that it is not the same as the parameter
     * entered. If the input is not a valid String (i.e. is null or empty), or
     * the String is the same as the parameter, the method continuously
     * reprompts the user until the input is a unique valid String.
     *
     * @param scan Scanner object that takes user input.
     * @param name - String that the return value should not be equal to
     * @return a valid String.
     */
    public String checkNameString(Scanner scan, String name) {
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
                } else if (name.equals(value)) {
                    throw new IllegalArgumentException("That name is already "
                            + "taken! Please enter a new name!");
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

    /**
     * A method that takes a Scanner object as input and checks if the input is
     * a String literal that is either "yes" or "no" (case is ignored). If not,
     * the method continuously reprompts the user until the input is either
     * "yes" or "no".
     *
     * @param scan Scanner object that takes user input.
     * @return the user input which is the String literal "yes" or String
     * literal "no" (ignore case).
     */
    public String checkYesOrNo(Scanner scan) {
        String value = "";
        boolean isString = false;
        do {
            try {
                value = scan.nextLine();
                isValidString(value);
                if (!value.equalsIgnoreCase("yes")
                        && !value.equalsIgnoreCase("no")) {
                    throw new IllegalArgumentException("Please enter yes "
                            + "or no!");
                }
                isString = true;
            } catch (Exception x) {
                System.out.println(x.getMessage());
            }
        } while (!isString);
        return value;
    }

    /**
     * A method that takes a Scanner object as input and in integer as a maximum
     * number that the user can input (starting at 1).Checks if the input is an
     * integer value between 1 inclusive and the maximum number inclusive. If
     * the input is not a value between 1 and the maximum number inclusive, the
     * method continuously reprompts the user until the input is of integer data
     * type between 1 and the maximum number inclusive.
     *
     * @param scan Scanner object that takes user input.
     * @return integer value between 1 inclusive and the maximum number
     * inclusive.
     */
    public int isNumberOption(Scanner scan, int size) {
        int value = 0;
        boolean isInt = false;
        do {
            try {
                value = scan.nextInt();
                if (value > size || value < 1) {
                    throw new IllegalArgumentException("Please enter a value "
                            + "between 1 and " + size + "!");
                }
                isInt = true;
            } catch (InputMismatchException x) {
                System.out.println("Please enter a number!");
                scan.nextLine();
            } catch (Exception x) {
                System.out.println(x.getMessage());
                scan.nextLine();
            }
        } while (!isInt);
        return value;
    }

}//end of class
