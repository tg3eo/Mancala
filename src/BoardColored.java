import java.awt.Color;

public class BoardColored implements BoardLayout{

	private Color color;
	
	public BoardColored(Color c){
		color = c;
	}
	
	@Override
	public void colorChange(MancalaGUI g) {
		changeColor(g);
	}
	
	public void changeColor(MancalaGUI g){
		changeColor(g, color);
	}
	
	public void changeColor(MancalaGUI g, Color c){
		g.getGamePanel().setBackground(c);
		g.getGamePanel().setForeground(c);
		g.getBtnsPanel().setBackground(c);
		g.getBtnsPanel().setForeground(c);
		g.getFrame().setBackground(c);
		System.out.println("It should work...");
		//		g.getBtnsPanel().setBackground(c);
//		g.getBtnsPanel().setForeground(c);
	}
}
