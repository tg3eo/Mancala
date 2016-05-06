/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*  Class:	MancalaPit
*  File:	MancalaPit.java
*  Description:	Part of the data model for the program. Handles each individual
*  pit in the game.
*  @author:	Riadiani Marcelita, Tom George, Thanh Bui
*  Environment:	PC, Windows 8.1, jdk1.7.0_80, Eclipse Mars Release 4.5.0
*  Date:	5/7/2016
*  @version	%1% %2%
*  @see       	java.util.EmptyStackException;
*  History Log:	Created on April 5, 2016, 07:00 PM
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class MancalaPit {
    private int score;

    /**
     * Overloaded constructor
     * Sets the number of stones in a particular pit.
     * @param i : the index of the pit.
     */
	public MancalaPit(int i) {
        score = i;
    }

	/**
	 * Method: getScore
	 * Gets the number of stones in a particular pit.
	 * @return
	 */
    public int getScore() {
        return score;
    }

    /**
     * Method: setScore
     * Sets the number of stones in a particular pit.
     * @param i : the index of the pit.
     */
    public void setScore(int i) {
        score = i;
    }
}