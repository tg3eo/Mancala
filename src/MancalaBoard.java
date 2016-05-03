import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeListener;

public class MancalaBoard {
	
	private MancalaPit[] mancalaPits;
	private final int MANCALA_A = 6;
	private final int MANCALA_B = 13;
	private boolean playedTurn = true;
	private int stonesPlayed;
	public int initStones;
	private SaveState state;
	private ArrayList<ChangeListener> listener;
	
	public MancalaBoard(){
		mancalaPits = new MancalaPit[14];
		listener = new ArrayList<>();
	}
	
	public int getAMancala(){
		return mancalaPits[6].getStone();
	}
	
	public int getBMancala(){
		return mancalaPits[13].getStone();
	}
	
	public MancalaPit[] getMancalaPits(){
		return mancalaPits;
	}
	
	public boolean getSidePlayed(){
		return playedTurn;
	}
	
	public MancalaBoard(int initialStones){
		initStones = initialStones;
		mancalaPits = new MancalaPit[14];
		for(int i = 0; i < MANCALA_A + 1; i++){
			mancalaPits[i] = new MancalaPit(initStones, true);
			if(i == 6){
				mancalaPits[i] = new MancalaPit(0, true);
			}
		}
		for(int j = MANCALA_A + 1; j < MANCALA_B + 1; j++){
			mancalaPits[j] = new MancalaPit(initStones, false);
			if(j == 13){
				mancalaPits[j] = new MancalaPit(0, false);
			}
		}
	}
	
	public int getInitialStones(){
		return initStones;
	}
	
	public void playGame(int index){
		stonesPlayed = mancalaPits[index].getStone();
		mancalaPits[index].clearPit();
		for(int i = index + 1; i < stonesPlayed + 1; i++){
			mancalaPits[index += 1].addStone();
			if(stonesPlayed == 0 || index == MANCALA_A || index == MANCALA_B || 
					mancalaPits[i].getSidePlayed() != playedTurn){
				JOptionPane.showMessageDialog(null, "Invalid move!");
			}
			if(i == stonesPlayed){	//Checking where the last stone is dropped.
				if(playedTurn){
					if(index == 6){
						playedTurn = true;
					}
					else if((index == 13) && (playedTurn != mancalaPits[i].getSidePlayed())){
						mancalaPits[index].setStone(mancalaPits[index].getStone() -1);
						i++;
					}
					else if(mancalaPits[i].getSidePlayed() && mancalaPits[i].getStone() == 0){
						playedTurn = false;
					}
					else if(mancalaPits[i].getSidePlayed() && mancalaPits[i].getStone() == 0){
						int stonesAcross = mancalaPits[i].addAcrossStones(12 - i);
						mancalaPits[6].setStone(stonesAcross);
					}
				}
				else if(!playedTurn){
					if(index == 13){
						playedTurn = false;
					}
					else if((index == 6) && (playedTurn != mancalaPits[i].getSidePlayed())){
						mancalaPits[index].setStone(mancalaPits[index].getStone() -1);
						i++;
					}
					else if(mancalaPits[i].getSidePlayed() && mancalaPits[i].getStone() == 0){
						playedTurn = true;
					}
					else if(mancalaPits[i].getSidePlayed() && mancalaPits[i].getStone() == 0){
						int stonesAcross = mancalaPits[i].addAcrossStones(12 - i);
						mancalaPits[6].setStone(stonesAcross);
					}
				}
			}
		}
	}
	
	public void attach(ChangeListener c){
		listener.add(c);
	}
	
	public void winner(){
		if(mancalaPits[MANCALA_A].getStone() > mancalaPits[MANCALA_B].getStone()){
			JOptionPane.showMessageDialog(null, "Player A is the winner!");
		}
		else if(mancalaPits[MANCALA_B].getStone() > mancalaPits[MANCALA_A].getStone()){
			JOptionPane.showMessageDialog(null, "Player B is the winner!");
		}
	}
	
	public boolean gameOver(){
		boolean gameOver = true;
		for(int i = 0; i < mancalaPits.length; i++){
			if(mancalaPits[i].getStone() != 0){
				gameOver = false;
			}
		}
		return gameOver;
	}
	
	public void undo(){
		System.out.println("Undo");
	}
}
