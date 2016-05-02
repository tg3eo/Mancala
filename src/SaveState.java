
public class SaveState {
	private int playerAScore;
	private int playerBScore;
	private boolean sidePlayed;
	private MancalaPit[] savedMancala;
	
	public SaveState(MancalaBoard mBoard){
		playerAScore = mBoard.getAMancala();
		playerBScore = mBoard.getBMancala();
		sidePlayed = mBoard.getSidePlayed();
		savedMancala = mBoard.getMancalaPits();
	}
	
	public SaveState(MancalaPit[] pits, boolean player){
		sidePlayed = player;
		playerAScore = pits[6].getStone();
		playerBScore = pits[13].getStone();
		for(int i = 0; i < pits.length; i++){
			savedMancala[i] = pits[i+2];
		}
	}
	
	public int getAScore(){
		return playerAScore;
	}
	
	public int getBScore(){
		return playerBScore;
	}
	
	public boolean getSidePlayed(){
		return sidePlayed;
	}
	
	public MancalaPit[] getSavedMancala(){
		return savedMancala;
	}
}
