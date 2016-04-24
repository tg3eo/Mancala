import javax.swing.JOptionPane;

public class MancalaBoard {
	
	private MancalaPit[] mancalaPits;
	private final int MANCALA_A = 6;
	private final int MANCALA_B = 13;
	private char playedTurn = 'A';
	private int stonesPlayed;
	
	public MancalaBoard(int initialStones){
		mancalaPits = new MancalaPit[14];
		for(int i = 0; i < MANCALA_A + 1; i++){
			mancalaPits[i] = new MancalaPit(initialStones, 'A');
			if(i == 6){
				mancalaPits[i] = new MancalaPit(0, 'A');
			}
		}
		for(int j = MANCALA_A + 1; j < MANCALA_B + 1; j++){
			mancalaPits[j] = new MancalaPit(initialStones, 'B');
			if(j == 13){
				mancalaPits[j] = new MancalaPit(0, 'B');
			}
		}
	}
	
	public char getPlayer(){
		return playedTurn;
	}
	
	public void playGame(int index){
		
		stonesPlayed = mancalaPits[index].getStone();
		mancalaPits[index].clearPit();
		for(int i = index + 1; i < stonesPlayed + 1; i++){
			mancalaPits[i].addStone();
			if(stonesPlayed == 0 || index == MANCALA_A || index == MANCALA_B || 
					mancalaPits[i].sidePlayed() != playedTurn){
				//JOptionPane.showMessageDialog(parentComponent, "Invalid move!");
			}
			if(i == stonesPlayed){	//Checking where the last stone is dropped.
				if(playedTurn == 'A' && index == 6){
					//Go again;
				}
				else if(playedTurn == 'A' && mancalaPits[i].sidePlayed() == 'B'){
					//End turn;
				}
				else if(playedTurn == 'A' && mancalaPits[i].sidePlayed() == 'A'){
					int stonesAcross = mancalaPits[i].addAcrossStones(12 - i);
					mancalaPits[6].setStone(stonesAcross);
				}
				//If player = A, land on Mancala, go again.
				//If player = A, land on B's empty pit, end turn.
				//If player = A, land on A's empty pit, int stones = mancalaPits[i].getStonesAcross(), 
					//mancalaPits[6] = stones;
			}
		}
	}
}
