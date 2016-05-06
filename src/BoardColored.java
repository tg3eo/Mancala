import java.awt.Color;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*  Class:	BoardColored
*  File:	BoardColored.java
*  Description:	A class that handles the re-coloring of the board. Implements the
*  BoardLayout interface, and uses the strategy pattern.
*  @author:	Riadiani Marcelita, Tom George, Thanh Bui
*  Environment:	PC, Windows 8.1, jdk1.7.0_80, Eclipse Mars Release 4.5.0
*  Date:	5/7/2016
*  @version	%1% %2%
*  @see       	java.util.EmptyStackException;
*  History Log:	Created on April 5, 2016, 07:00 PM
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class BoardColored implements BoardLayout{

	private Color color;
	
	/**
	 * Overloaded constructor
	 * @param c : the color to set the board into.
	 */
	public BoardColored(Color c){
		color = c;
	}
	
	/**
	 * Overriden constructor from BoardLayout. Calls the method
	 * changeColor.
	 */
	@Override
	public void colorChange(MancalaGUI g) {
		changeColor(g);
	}
	
	/**
	 * Method: changeColor
	 * Calls in the method changeColor and passes in the MancalaGUI object
	 * which color is to be modified.
	 * @param g : the MancalaGUI object which color is to be modified.
	 */
	public void changeColor(MancalaGUI g){
		changeColor(g, color);
	}
	
	/**
	 * Method: changeColor
	 * Changes the background color of some parts of the MancalaGUI.
	 * @param g : the MancalaGUI object that contains the components to be
	 * recolored.
	 * @param c : the color the GUI components are to be recolored into.
	 */
	public void changeColor(MancalaGUI g, Color c){
		g.getGamePanel().setBackground(c);
		g.getGamePanel().setForeground(c);
		g.getBtnsPanel().setBackground(c);
		g.getBtnsPanel().setForeground(c);
		g.getFrame().setBackground(c);
	}
}