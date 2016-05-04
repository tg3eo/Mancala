import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MancalaGUI {
	
	private JButton[] pitBtn;
	private PitJButtons[] pitBtns;
	private JButton undoButton;
	private JButton quitButton;
	private JButton mancalaA, mancalaB;
	private JButton playerTurnButton;
	private JPanel gamePanel;
	private JPanel pitBtnsPanel;
	private JFrame frame;
	private MancalaBoard mb;
	
	public MancalaGUI(BoardLayout board){
		
		frame = new JFrame();
		
		gamePanel = new JPanel();
		JPanel buttonsPanel = new JPanel();
		pitBtnsPanel = new JPanel();
		mancalaA = new JButton("A");
		mancalaB = new JButton("B");
		JButton pitButtons;
		pitBtn = new JButton[12];
		pitBtns = new PitJButtons[12];
		PitJButtons temptBtns;
		gamePanel.add(mancalaB, BorderLayout.WEST);
		for(int i = 0; i < pitBtns.length; i++){
			temptBtns = new PitJButtons("3", i);
			pitBtns[i] = temptBtns;
			pitBtnsPanel.add(pitBtns[i]);
		}
		pitBtnsPanel.setLayout(new GridLayout(2, 6));
		gamePanel.add(pitBtnsPanel, BorderLayout.CENTER);
		gamePanel.add(mancalaA, BorderLayout.EAST);
		
		playerTurnButton = new JButton("End Player's Turn");
		undoButton = new JButton("Undo");
		quitButton = new JButton("Quit");
		buttonsPanel.add(playerTurnButton);
		buttonsPanel.add(undoButton);
		buttonsPanel.add(quitButton);
		buttonsPanel.setLayout(new GridLayout(1, 3));
		
		frame.add(gamePanel, BorderLayout.NORTH);
		frame.add(buttonsPanel, BorderLayout.SOUTH);
		frame.setVisible(true);
		frame.setSize(600, 200);
		frame.setResizable(false);
		frame.setTitle("Team Fox Force-Five Mancala Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.pack();
		board.colorChange(this);
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
	
	public PitJButtons[] getPits(){
		return pitBtns;
	}
	
	public JButton getUndoButton(){
		return undoButton;
	}
	
	public JButton getEndButton(){
		return playerTurnButton;
	}
	
	public JButton getQuitButton(){
		return quitButton;
	}
	
	public JButton getMancalaA(){
		return mancalaA;
	}
	
	public JButton getMancalaB(){
		return mancalaB;
	}
}
