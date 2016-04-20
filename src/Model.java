public class Model {
	
	private int[] pits;
	private View view;
	private Player player1;
	private Player player2;
	
	public Model(){
		pits = new int[14];
		view = new View();
		player1 = new Player();
		player2 = new Player();
	}

	public void setPits(int n){
		for(int i = 0; i < n; i++){
			if(i == 6 || i == 13){
				pits[i] = 0;
			}
			pits[i] = n;
		}
	}
	
	public int getStonesInPits(int index){
		return pits[index];
	}
	
	public void setStonesInPits(int index, int stonesNum){
		pits[index] = stonesNum;
	}
	
	
}
