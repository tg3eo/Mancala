import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MancalaGUI {
	
	private JButton[] pitBtn;
	private JButton undoButton;
	private JPanel gamePanel;
	private JPanel pitBtnsPanel;
	private JFrame frame;
	private MancalaBoard mb;
	
	public MancalaGUI(BoardLayout board){
		
		frame = new JFrame();
		
		gamePanel = new JPanel();
		JPanel buttonsPanel = new JPanel();
		pitBtnsPanel = new JPanel();
		JButton mancalaA = new JButton("A");
		JButton mancalaB = new JButton("B");
		JButton pitButtons;
		pitBtn = new JButton[12];
		gamePanel.add(mancalaA, BorderLayout.WEST);
		for(int i = 0; i < pitBtn.length; i++){
			pitButtons = new JButton("3");
			pitBtn[i] = pitButtons;
			pitBtnsPanel.add(pitButtons);
		}
		pitBtnsPanel.setLayout(new GridLayout(2, 6));
		gamePanel.add(pitBtnsPanel, BorderLayout.CENTER);
		gamePanel.add(mancalaB, BorderLayout.EAST);
		
		JButton playerTurnButton = new JButton("End Player's Turn");
		undoButton = new JButton("Undo");
		JButton quitButton = new JButton("Quit");
		buttonsPanel.add(playerTurnButton);
		buttonsPanel.add(undoButton);
		buttonsPanel.add(quitButton);
		buttonsPanel.setLayout(new GridLayout(1, 3));
		
		frame.add(gamePanel, BorderLayout.NORTH);
		frame.add(buttonsPanel, BorderLayout.SOUTH);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle("Team Fox Force-Five Mancala Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}

	public JFrame getFrame(){
		return frame;
	}
	
	public JPanel getGamePanel(){
		return gamePanel;
	}
	
	public JPanel getBtnsPanel(){
		return pitBtnsPanel;
	}
	
	public JButton[] getPits(){
		return pitBtn;
	}
	
	public JButton undoButton(){
		return undoButton;
	}
}
