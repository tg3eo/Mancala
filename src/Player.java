public class Player {

	private int stonesInMancala;
	private int undoCounter;
	
	public Player(){
		setMancalaStones(0);
	}
	
	public void setMancalaStones(int n){
		stonesInMancala = n;
	}
	
	public void addStoneToMancala(){
		stonesInMancala++;
	}
	
	public int getMancalaStones(){
		return stonesInMancala;
	}
	
	public void undoClicked(){
		undoCounter++;
	}
	
	public int getUndoClicked(){
		return undoCounter;
	}
}
