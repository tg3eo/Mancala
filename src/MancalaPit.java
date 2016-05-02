
public class MancalaPit {

	private int stones, previousStones;
	private boolean player;
	
	public MancalaPit(int initialStones, boolean thisPlayer){		//thisPlayer = A if A's turn, B if B's turn.
		stones = initialStones;
		previousStones = stones;
		player = thisPlayer;
	}
	
	public boolean getSidePlayed(){
		return player;
	}
	
	public void setStone(int stonesInPit){
		previousStones = stones;
		stones = stonesInPit;
	}
	
	public int getStone(){
		return stones;
	}
	
	public void addStone(){
		previousStones = stones;
		stones++;
	}
	
	public int addAcrossStones(int stonesAcross){
		previousStones = stones;
		stones += stonesAcross;
		return stones;
	}
	
	public void clearPit(){
		stones = 0;
	}
	
	//Sets the pit's stones into what it contained previously.
	public void undo(){
		stones = previousStones;
	}
}
