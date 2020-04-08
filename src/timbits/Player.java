/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package timbits;

/**
 * A class that models each Player in the game. Parent class of the WarPlayer
 * class.
 *
 * @author dancye, 2018
 * @modifiedBy Carrie Aubin
 * @modifiedBy Jovanka Milosevic
 * @modifiedBy Thy Nguyen
 * @modifiedBy Maiziel Serrao
 */
public abstract class Player {

    private String playerID; //the unique ID for this player

    Validator isValid = new Validator();

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        setPlayerID(name);
    }

    /**
     * A method that returns the String representing the player's ID.
     *
     * @return String representing the player's ID
     */
    public String getPlayerID() {
        return playerID;
    }

    /**
     * A method that takes in a string and sets the player's ID to that String.
     *
     * @param givenID the playerID to set
     */
    public void setPlayerID(String givenID) {
        if (isValid.isValidString(givenID)) {
            playerID = givenID; //ensure this is unique!
        }
    }

    /**
     * The method to instantiated in the WarPlayer class to play a round in the
     * game.
     */
    public abstract Card play();

}//end of class
