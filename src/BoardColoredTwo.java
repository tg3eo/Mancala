import java.awt.Color;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*  Class:	BoardColoredTwo
*  File:	BoardColoredTwo.java
*  Description:	The second version of the colored Mancala board. Extends the class
*  BoardColored. Implements the strategy pattern, and colors the board blue.
*  @author:	Riadiani Marcelita, Tom George, Thanh Bui
*  Environment:	PC, Windows 8.1, jdk1.7.0_80, Eclipse Mars Release 4.5.0
*  Date:	5/7/2016
*  @version	%1% %2%
*  @see       	java.util.EmptyStackException;
*  History Log:	Created on April 5, 2016, 07:00 PM
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class BoardColoredTwo extends BoardColored {

	/**
	 * Constructor, calls in the super constructor from
	 * BoardColored, and passes in the color blue.
	 */
	public BoardColoredTwo() {
		super(Color.BLUE);
	}
	
	/**
	 * Method: setColor
	 * Sets the color of the board to blue.
	 * @param g : the MancalaGUI object which parts is being recolored.
	 */
	public void setColor(MancalaGUI g){
		super.changeColor(g);
	}
}
