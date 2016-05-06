import java.util.ArrayList;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*  Class:	MancalaBoard
*  File:	MancalaBoard.java
*  Description:	The data model part of the program. Handles the logic and rules of
*  how to play the game. Includes handling a player's turn, a player choosing a pit
*  and playing the game, saving the state of the game, and deciding when the game
*  ends as well as who the winner is.
*  @author:	Riadiani Marcelita, Tom George, Thanh Bui
*  Environment:	PC, Windows 8.1, jdk1.7.0_80, Eclipse Mars Release 4.5.0
*  Date:	5/7/2016
*  @version	%1% %2%
*  @see       	java.util.EmptyStackException;
*  History Log:	Created on April 5, 2016, 07:00 PM
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class MancalaBoard {
    private ArrayList<ChangeListener> listeners;
    private int mancalaA;
    private int mancalaB;
    private char playerTurn;	//'A' if player A's turn, 'B' if player B's turn
    private MancalaPit[] pits;
    private SaveMancala lastState;
    private boolean toggleTurn;
    private int undos;
    private int numStones;

    /**
     * Overloaded constructor
     * @param numOfStones : the number of stones per pit initially set
     * for the game; it can either be 3 or 4 stones per pit.
     */
    public MancalaBoard(int numOfStones) {
        undos = 3;
        mancalaA = 0;
        mancalaB = 0;
        playerTurn = 'A';
        toggleTurn = false;
        numStones = numOfStones;
        pits = new MancalaPit[12];
        for(int i = 0; i < pits.length; i++)
            pits[i] = new MancalaPit(numStones);
        lastState = new SaveMancala(null);
        listeners = new ArrayList<ChangeListener>();
    }

    /**
     * Method: attach
     * Attaches the listeners to the data model to reflect
     * any changes made in the data model.
     * @param c : the ChangeListener object that handles the
     * changes made in the data model.
     */
    public void attach(ChangeListener c) {
        listeners.add(c);
    }

    /**
     * Method: update
     * Ensuring the view/GUI part of the program is updated to reflect
     * the changes made in the data model.
     */
    public void update() {
        for (ChangeListener l : listeners)
            l.stateChanged(new ChangeEvent(this));
    }

    /**
     * Method: getSwitch
     * Return state of the switch/end turn button, if it is pressed or not.
     * @return true if button is pressed, false otherwise.
     */
    public boolean getTurnButton() {
        return toggleTurn;
    }

    /**
     * Method: getPlayerTurn
     * Gets the player's turn, either A or B.
     * @return
     */
    public char getPlayerTurn() {
        return playerTurn;
    }

    /**
     * Method: getPlayerAScore
     * Gets the score of Player A, or the number of pits in player A's
     * mancala.
     * @return mancalaA : player A's score.
     */
    public int getPlayerAScore() {
        return mancalaA;
    }

    /**
     * Method: getPlayerBScore
     * Gets the score of Player B, or the number of pits in player B's mancala.
     * @return mancalaB : player B's score.
     */
    public int getPlayerBScore() {
        return mancalaB;
    }

    /**
     * Method: getPits
     * Returns the number of stones on each pit.
     * @return scores : the number of stones on the pits.
     */
    public int[] getPits() {
        int[] scores = new int[12];
        for(int i = 0; i < scores.length; i++)
            scores[i] = pits[i].getScore();
        return scores;
    }

    /**
     * Method: getPitScore
     * Gets the number of stones in any selected individual pit.
     * @param i : the index of the pit chosen/selected.
     * @return the number of stones in that particular pit.
     */
    public int getPitScore(int i) {
        return pits[i].getScore();
    }

    /**
     * Method: getLatestState
     * Returns the latest saved state of the game.
     * @return the latest saved SaveMancala object/latest state of the game.
     */
    public SaveMancala getLatestState() {
        return lastState;
    }

    /**
     * Method: getUndosLeft
     * Returns the number of times the user can still click on the undo button.
     * Each player gets 3 chances to hit the undo button.
     * @return undos : the number of times the user can still click on the undo 
     * button.
     */
    public int getUndosLeft() {
        return undos;
    }

    /**
     * Method: replaceState
     * Saves the latest state of the game into the variable lastState.
     * @param s : the SaveMancala object that contains the latest saved
     * state of the game.
     */
    public void replaceState(SaveMancala s) {
        lastState = s;
    }

    /**
     * Method: reset
     * Resets the game to the previous state.
     * @param s : the SaveMancala object that contains the latest state
     * of the game.
     */
    public void reset(SaveMancala s) {
    	if(!s.isNull()){
	        for(int i = 0; i < pits.length; i++)
	            pits[i].setScore(s.getPits()[i]);
	        mancalaA = s.getAScore();
	        mancalaB = s.getBScore();
	        playerTurn = s.getTurn();
	        toggleTurn = false;
	        update();
    	}
    	else{
    		JOptionPane.showMessageDialog(null, "Cannot undo!");
    	}
    }

    /**
     * Method: undo
     * The logic that handles what happens when the user clicks on the
     * undo button; the previous saved state of the game is restored.
     */
    public void undo() {
        if(undos > 0) {
            reset(lastState);
            lastState = new SaveMancala(null);
            undos--;
        }
        update();
    }

    /**
     * Method: switchTurn
     * Toggles the turn from player A to player B.
     */
    public void switchTurn() {
    	if(playerTurn == 'A'){
    		playerTurn = 'B';
    	}
    	else if(playerTurn == 'B'){
    		playerTurn = 'A';
    	}
        undos = 3;
        lastState = new SaveMancala(null);
        toggleTurn = false;
        update();
    }

    /**
     * Method: playGame
     * Handles the logic for making a move in the game/how to play the
     * game overall.
     * @param i : the index of the pit the user chooses to play on.
     */
    public void playGame(int i) {
        boolean move = true;
        int stones = pits[i].getScore();
        pits[i].setScore(0);
        
        if(i < 6){
            move = false;
        }
        while(stones > 0) {
            if(move){
                i++;
            }
            else{
                i--;
            }
            if(i == 12) {
                if(playerTurn == 'A'){
                    mancalaA++;
                }
                else{
                    stones++;
                }
                i = 6;
                move = false;
            } 
            else if(i == -1) {
                if(playerTurn == 'B'){
                    mancalaB++;
                }
                else{
                    stones++;
                }
                i = 5;
                
                move = true;
            } 
            else{
                pits[i].setScore(pits[i].getScore()+1);
            }
            stones--;
        }
        if(((playerTurn == 'A') && i < 6) || ((playerTurn == 'B') && i > 5)){
            toggleTurn = true;
        }
        else if((playerTurn == 'A') && i < 12 && move && pits[i].getScore() == 1) {
            mancalaA += pits[i].getScore();
            pits[i].setScore(0);
            mancalaA += pits[i-6].getScore();
            pits[i-6].setScore(0);
        } 
        else if((playerTurn == 'B') && i > -1 && !move && pits[i].getScore() == 1){
            mancalaB += pits[i].getScore();
            pits[i].setScore(0);
            mancalaB += pits[i+6].getScore();
            pits[i+6].setScore(0);
        }

        String s = " ";
        for(int j = 0; j < 12; j++) {
            s += pits[j].getScore()+" ";
            if(j == 5)
                s+= "| ";
        }

        boolean endATurn = true;
        boolean endBTurn = true;
        
        for(int j = 0; j < pits.length/2; j++)
            if(pits[j].getScore() > 0){
                endBTurn = false;
            }
        for(int j = pits.length/2; j < pits.length; j++)
            if(pits[j].getScore() > 0){
                endATurn = false;
            }
        if(endATurn || endBTurn) {
            for(int j = 0; j < pits.length/2; j++) {
                mancalaB += pits[j].getScore();
                pits[j].setScore(0);
            } 
            for(int j = pits.length/2; j < pits.length; j++) {
                mancalaA += pits[j].getScore();
                pits[j].setScore(0);
            }
            gameOver();
        }
        update();
    }

    /**
     * Method: gameOver
     * Informs the user when the game is over and declares the winner once one of the
     * player's pits are all emptied. Winner is decided based on which player's mancala 
     * has the most number of stones.
     */
    public void gameOver() {
        if(mancalaA > mancalaB){
        	JOptionPane.showMessageDialog(null, "Game Over! Player A is the winner!");
        }
        else{
        	JOptionPane.showMessageDialog(null, "Game Over! Player B is the winner!");
        }
        System.exit(0);
    }
}