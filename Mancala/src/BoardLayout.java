/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*  Interface:	BoardLayout
*  File:	BoardLayout.java
*  Description:	The interface that deals with the color change in the mancala
*  boards. The interface used in the implementation of the strategy pattern for
*  the program.
*  @author:	Riadiani Marcelita, Tom George, Thanh Bui
*  Environment:	PC, Windows 8.1, jdk1.7.0_80, Eclipse Mars Release 4.5.0
*  Date:	5/7/2016
*  @version	%1% %2%
*  @see       	java.util.EmptyStackException;
*  History Log:	Created on April 5, 2016, 07:00 PM
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public interface BoardLayout {
	
	/**
	 * Constructor
	 * @param g : the MancalaGUI object which color is to be changed.
	 */
	public void colorChange(MancalaGUI g);
}
