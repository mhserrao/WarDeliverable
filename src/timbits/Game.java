/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package timbits;

import java.util.ArrayList;

/**
 * The class that models a card game. Parent class of the War class.
 *
 * @author dancye, 2018
 * @modifiedBy Carrie Aubin
 * @modifiedBy Jovanka Milosevic
 * @modifiedBy Thy Nguyen
 * @modifiedBy Maiziel Serrao
 */
public abstract class Game {

    private final String gameName;//the title of the game
    private ArrayList<Player> players;// the players of the game

    /**
     * A constructor of a Game object. Takes in a String and sets the name of
     * the game to the String.
     *
     * @param givenName - String representing the name of the Game object
     */
    public Game(String givenName) {
        gameName = givenName;
        players = new ArrayList<Player>();
    }

    /**
     * A method that returns the name of the Game object.
     *
     * @return the gameName - the String representing the name of the Game
     * object.
     */
    public String getGameName() {
        return gameName;
    }

    /**
     * A method that returns an ArrayList containing all the players within the
     * Game object.
     *
     * @return the players of this game
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * A method that takes in an ArrayList of players and sets the players of
     * the Game object to that ArrayList of players
     *
     * @param players the players of this game
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * An abstract method implemented in the War class. Allows the players to
     * play the game.
     *
     * @param me - one player of the game
     * @param opp - another player of the game
     */
    public abstract void play(Player me, Player opp);

    /**
     * An abstract method implemented in the War class. Announces the winner of
     * the game based on its players.
     *
     * @param me - one player of the game
     * @param opp - another player of the game
     */
    public abstract void declareWinner(Player me, Player opp);

}//end class
