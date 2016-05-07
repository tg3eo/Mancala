import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*  Class:	MancalaGUI
*  File:	MancalaGUI.java
*  Description:	The View part of the program. Contains the code that programs and
*  creates the GUI, or the mancala game board.
*  @author:	Riadiani Marcelita, Tom George, Thanh Bui
*  Environment:	PC, Windows 8.1, jdk1.7.0_80, Eclipse Mars Release 4.5.0
*  Date:	5/7/2016
*  @version	%1% %2%
*  @see       	java.util.EmptyStackException;
*  History Log:	Created on April 5, 2016, 07:00 PM
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class MancalaGUI {
	
	private JButton[] pitBtns;
	private JButton undoButton;
	private JButton quitButton;
	private JButton mancalaA, mancalaB;
	private JButton playerTurnButton;
	private JPanel gamePanel;
	private JPanel pitBtnsPanel;
	private JFrame frame;
	
	/**
	 * Overloaded constructor
	 * @param board : the version of the board to be displayed, either
	 * the red board or the blue board.
	 */
	public MancalaGUI(BoardLayout board){
		
		frame = new JFrame();
		
		gamePanel = new JPanel();
		JPanel buttonsPanel = new JPanel();
		pitBtnsPanel = new JPanel();
		mancalaA = new JButton("A");
		mancalaA.setBackground(Color.WHITE);
		mancalaB = new JButton("B");
		mancalaB.setBackground(Color.CYAN);
		pitBtns = new JButton[12];
		JButton temptBtns;
		gamePanel.add(mancalaB, BorderLayout.WEST);
		for(int i = 0; i < pitBtns.length; i++){
			temptBtns = new JButton();
			temptBtns.setBackground(Color.CYAN);
			pitBtns[i] = temptBtns;
			pitBtnsPanel.add(pitBtns[i]);
		}
		GridLayout grid = new GridLayout(2, 6);
		grid.setVgap(50);
		pitBtnsPanel.setLayout(grid);
		gamePanel.add(pitBtnsPanel, BorderLayout.CENTER);
		gamePanel.add(mancalaA, BorderLayout.EAST);
		
		playerTurnButton = new JButton("End Player's Turn");
		undoButton = new JButton("Undo");
		quitButton = new JButton("Quit");
		buttonsPanel.add(playerTurnButton);
		buttonsPanel.add(undoButton);
		buttonsPanel.add(quitButton);
		buttonsPanel.setLayout(new GridLayout(1, 3));
		
		frame.add(gamePanel, BorderLayout.NORTH);
		frame.add(buttonsPanel, BorderLayout.SOUTH);
		frame.setVisible(true);
		frame.setSize(600, 200);
		frame.setResizable(false);
		frame.setTitle("Team Fox Force-Five Mancala Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		board.colorChange(this);
	}

	/**
	 * Method: getFrame
	 * Gets the main JFrame that contains the game's entire GUI/visuals.
	 * @return frame : the main JFrame of the mancala board.
	 */
	public JFrame getFrame(){
		return frame;
	}
	
	/**
	 * Method: getGamePanel
	 * Gets the JPanel that contains the pits and player's mancalas.
	 * @return gamePanel : the JPanel that contains the pits and player's mancalas.
	 */
	public JPanel getGamePanel(){
		return gamePanel;
	}
	
	/**
	 * Method: getBtnsPanel
	 * Gets the JPanel that contains the pits buttons only.
	 * @return pitBtnsPanel : the JPanel that contains the pits buttons only.
	 */
	public JPanel getBtnsPanel(){
		return pitBtnsPanel;
	}
	
	/**
	 * Method: getPits
	 * Gets the buttons that make up the pits in the game.
	 * @return pitBtns : an array of JButtons that contains the buttons of pits.
	 */
	public JButton[] getPits(){
		return pitBtns;
	}
	
	/**
	 * Method: getUndoButton
	 * Gets the undo button.
	 * @return undoButton : the undo JButton.
	 */
	public JButton getUndoButton(){
		return undoButton;
	}
	
	/**
	 * Method: getEndButton
	 * Gets the button that ends the player's turn/toggles the
	 * players' turn.
	 * @return playerTurnButton : the JButton that toggles the player's turn.
	 */
	public JButton getEndButton(){
		return playerTurnButton;
	}
	
	/**
	 * Method: getQuitButton
	 * Gets the quit button.
	 * @return quitButton : the quit JButton.
	 */
	public JButton getQuitButton(){
		return quitButton;
	}
	
	/**
	 * Method: getMancalaA
	 * Gets player A's mancala.
	 * @return mancalaA : the JButton that serves as palyer A's mancala.
	 */
	public JButton getMancalaA(){
		return mancalaA;
	}
	
	/**
	 * Method: getMancalaB
	 * Gets player B's mancala.
	 * @return mancalaB : the JButton that serves as player A's mancala.
	 */
	public JButton getMancalaB(){
		return mancalaB;
	}
	
	/**
	 * Method: isUndoPressed
	 * Checks it the undo pressed is enabled or not.
	 * @return true if it's enabled, false otherwise.
	 */
	public boolean isUndoPressed(){
		return playerTurnButton.isEnabled();
	}
}