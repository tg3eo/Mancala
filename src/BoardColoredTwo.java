import java.awt.Color;

public class BoardColoredTwo extends BoardColored {

	public BoardColoredTwo() {
		super(Color.BLUE);
	}
	
	public void setColor(MancalaGUI g){
		super.changeColor(g);
	}
}
