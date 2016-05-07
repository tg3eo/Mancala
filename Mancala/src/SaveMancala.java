/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*  Class:	SaveMancala
*  File:	SaveMancala.java
*  Description:	A class that handles the saved state of the mancala game, to later
*  be used for the undo button in the game.
*  @author:	Riadiani Marcelita, Tom George, Thanh Bui
*  Environment:	PC, Windows 8.1, jdk1.7.0_80, Eclipse Mars Release 4.5.0
*  Date:	5/7/2016
*  @version	%1% %2%
*  @see       	java.util.EmptyStackException;
*  History Log:	Created on April 5, 2016, 07:00 PM
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class SaveMancala {
    private int playerA;
    private int playerB;
    private char playerTurn;
    private int[] pitPoints;
    private boolean isNull = false;

    /**
     * Overloaded constructor.
     * @param d : the MancalaBoard that serves as the data model of the program.
     */
    public SaveMancala(MancalaBoard d) {
        if(d == null)
            isNull = true;
        else {
            playerA = d.getPlayerAScore();
            playerB = d.getPlayerBScore();
            pitPoints = d.getPits();
            playerTurn = d.getPlayerTurn();
        }
    }

    /**
     * Method: isNull
     * Returns a boolean that decides if the saved state is null,
     * or initially if the user has not made a move and no state
     * can be saved yet.
     * @return isNull : true if no state is to be saved yet, false otherwise.
     */
    public boolean isNull() {
        return isNull;
    }

    /**
     * Method: getPits
     * Gets the integer array that contains the pits and its number of stones
     * in each pit.
     * @return pitPoints : the array that contains the pits and the number of
     * stones in them.
     */
    public int[] getPits() {
        return pitPoints;
    }

    /**
     * Method: getAScore
     * Gets the number of stones in player A's mancala.
     * @return playerA : the number of stones in player A's mancala.
     */
    public int getAScore() {
        return playerA;
    }

    /**
     * Method: getBScore
     * Gets the number of stones in player B's mancala.
     * @return playerA : the number of stones in player B's mancala.
     */
    public int getBScore() {
        return playerB;
    }

    /**
     * Method: getTurn
     * Gets the current player's turn.
     * @return playerTurn : the current player's turn.
     */
    public char getTurn() {
        return playerTurn;
    }
}