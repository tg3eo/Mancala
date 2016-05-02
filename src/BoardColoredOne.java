import java.awt.Color;

public class BoardColoredOne extends BoardColored {

	public BoardColoredOne() {
		super(Color.RED);
	}
	
	public void setColor(MancalaGUI g){
		super.changeColor(g);
	}
}
