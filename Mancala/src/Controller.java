import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*  Class:	Controller
*  File:	Controller.java
*  Description:	A class that handles the controller part of the program. Defines
*  listeners for the GUI; informs data model of any actions done by user through
*  the GUI, then sends back changes made in the data model to be reflected in the
*  GUI accordingly.
*  @author:	Riadiani Marcelita, Tom George, Thanh Bui
*  Environment:	PC, Windows 8.1, jdk1.7.0_80, Eclipse Mars Release 4.5.0
*  Date:	5/7/2016
*  @version	%1% %2%
*  @see       	java.util.EmptyStackException;
*  History Log:	Created on April 5, 2016, 07:00 PM
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class Controller implements ChangeListener {
    private MancalaBoard mb;
    private MancalaGUI gui;

    /**
     * Overloaded constructor
     * @param d : MancalaBoard object, the data model object of the program.
     * @param g : MancalaGUI object, the GUI or view object of the program.
     */
    public Controller(MancalaBoard d, MancalaGUI g) {
        gui = g;
        mb = d;
        mb.attach(this);
        controllers();
        stateChanged(null);
    }

    /**
     * Method: stateChanged
     * Modifies the GUI to reflect the data processed by the data model part
     * of the program.
     */
    public void stateChanged(ChangeEvent e) {
        gui.getMancalaA().setText("A: "+mb.getPlayerAScore());
        gui.getMancalaB().setText("B: "+mb.getPlayerBScore());
        gui.getEndButton().setEnabled(!mb.getLatestState().isNull() && mb.getUndosLeft() > 0);
        gui.getEndButton().setEnabled(mb.getTurnButton());
        if(mb.getPlayerTurn() == 'A')
            gui.getEndButton().setText("End Turn Player A");
        else
            gui.getEndButton().setText("End Turn Player B");
        
        for(int i = 0; i < gui.getPits().length; i++)
            if(i < 6) {
                gui.getPits()[i].setText("B"+(i+1)+": "+mb.getPitScore(i));
                gui.getPits()[i].setBackground(Color.CYAN);
            } else {
                gui.getPits()[i].setText("A"+(i-5)+": "+mb.getPitScore(i));
                gui.getPits()[i].setBackground(Color.WHITE);
            }
    }
    
    /**
     * Method: controllers
     * Attaches listeners to all the buttons on MancalaGUI, and define each button's
     * actions accordingly.
     */
    public void controllers() {
        for(final JButton btn : gui.getPits())
            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	String side = btn.getText().substring(0, 1);
                	int index = Integer.parseInt(btn.getText().substring(1, 2));
                    mb.replaceState(new SaveMancala(mb));
                    if(mb.getPlayerTurn() == 'A' && side.equals("B")){
                    	JOptionPane.showMessageDialog(null, "Invalid move!");
                    }
                    else if(mb.getPlayerTurn() == 'B' && side.equals("A")){
                    	JOptionPane.showMessageDialog(null, "Invalid move!");
                    }
                    else if(gui.isUndoPressed() && gui.getEndButton().getText().equals("End Turn Player A") &&
                    		side.equals("A")){
                    	JOptionPane.showMessageDialog(null, "Invalid move! Please switch turn.");
                    }
                    else if(gui.isUndoPressed() && gui.getEndButton().getText().equals("End Turn Player B") &&
                    		side.equals("B")){
                    	JOptionPane.showMessageDialog(null, "Invalid move! Please switch turn.");
                    }
                    else{
	                    if(side.equals("A")){
	                    	mb.playGame((index-1)+6);
	                    }
	                    else{
	                    	mb.playGame(index-1);
	                    }
	                    mb.update();
                    }
                }
            });
        gui.getUndoButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mb.undo();
            }
        });
        gui.getEndButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mb.switchTurn();
            }
        });
        gui.getQuitButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}