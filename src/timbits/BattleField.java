/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timbits;

import java.util.Scanner;

/**
 * The class where two WarPlayers come to play the game of War. Runs the logic
 * of the card game war.
 *
 * @author Carrie Aubin
 * @author Jovanka Milosevic
 * @author Thy Nguyen
 * @author Maiziel Serrao
 */
public class BattleField {

    /**
     * Contains all the logic of the card game of War.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("**************************************************"
                + "*********************");
        System.out.println("*                    WELCOME TO A GAME OF WAR!    "
                + "                    *");
        System.out.println("**************************************************"
                + "*********************");

        DeckOfCards deck = new DeckOfCards();
        War war = new War();
        WarPlayer me = new WarPlayer();
        WarPlayer opp = new WarPlayer();
        Scanner scan = new Scanner(System.in);
        Validator isValid = new Validator();

        System.out.println("\nWhat is your name?");
        String myName = isValid.checkString(scan);
        me.setPlayerID(myName);
        System.out.println("\nWho are you facing?");
        String oppName = isValid.checkString(scan);
        opp.setPlayerID(oppName);

        System.out.println("\nOkay, let's battle!\n");
        war.dealCards(me, opp, deck);

        int option = 0;
        do {
            System.out.println("What do you want to do?");
            System.out.println("1 - Draw card");
            System.out.println("2 - Check number of cards");
            System.out.println("3 - Concede");
            option = isValid.isNumberOption(scan, 3);
            System.out.println();

            if (option == 1) {
                war.play(me, opp);
            } else if (option == 2) {
                System.out.println("You have " + me.getPlayersCards().getSize()
                        + " cards in your pile and "
                        + me.getCardsWon().getSize() + " in your winning "
                        + "pile.");
                System.out.println(opp.getPlayerID() + " has "
                        + opp.getPlayersCards().getSize() + " cards in their "
                        + "pile and " + opp.getCardsWon().getSize()
                        + " in their winning pile.\n");
            } else if (option == 3) {
                war.concede();
            }
        } while (option > 0);
        
    }//end of main method

}//end of class
