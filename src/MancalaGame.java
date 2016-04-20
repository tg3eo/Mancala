import javax.swing.*;	//needed for graphics
import java.awt.*;
import java.awt.event.*;  // needed for ActionEvent

public class MancalaGame 
{	
	static JFrame frame;
	static JButton play, instruction;
	static JLabel introduction, authors;
	static Container c;
	static JPanel p1;
	public static void main(String[] args)
	{
		frame = new JFrame("Mancala Game");
		frame.setSize(500, 500);
		c = frame.getContentPane();
        p1 = new JPanel();
        p1.setLayout(null);
		
		introduction= new JLabel("This is a Mancala Game.");
        authors = new JLabel("Authors: Thanh, Riri, Tom ");
        play = new JButton("Play!");
        instruction = new JButton("Instruction!");
        
        
        c.add(p1);
        p1.add(introduction);
        p1.add(play);
        p1.add(instruction);
        p1.add(authors);
        
        introduction.setFont(introduction.getFont().deriveFont(20.0f));
        introduction.setForeground(Color.BLUE);
        introduction.setBounds(125, 0, 300, 100);
        authors.setFont(authors.getFont().deriveFont(20.0f));
        authors.setForeground(Color.BLUE);
        authors.setBounds(125, 300, 300, 100);
        play.setBounds(200, 100, 80, 80);
        instruction.setBounds(165, 200, 150, 80);
        
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible(true);
        
        play.addActionListener(new PlayAction());
        instruction.addActionListener(new InstructionAction());
	}
    static class PlayAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            View p = new View();
            frame.dispose();
        }
    }
    
    static class InstructionAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
             JOptionPane.showMessageDialog(null, "The board consists of two rows of pits, each. Three pieces or four pieces of stones"+
            		 							 "\nare placed in each of the 12 holes. Each player has a large store called Mancala to"+
            		 							 "\nthe right side of the board. One player starts the game by picking up all of the "+
            		 							 "\nstones in any one of his own pits. Moving counter-clock wise, the player places one"+
            		 							 "\nin each pit starting with the next pit until the stones run out. If you run into your"+
            		 							 "\nown Mancala, place one stone in it. If there are more stones to go past your own "+
            		 							 "\nMancala, continue placing them into the opponent's pits. However, skip your opponent's"+
            		 							 "\nMancala. If the last stone you drop is your own Mancala, you get a free turn . If the"+
            		 							 "\nlast stone you drop is in an empty pit on your side, you get to take that stone and all"+
            		 							 "\nof your opponents stones that are in the opposite pit. Place all captured stones in your"+
            		 							 "\nown Mancala. The game ends when all six pits on one side of the Mancala board are empty."+
            		 							 "\nThe player who still has stones on his side of the board when the game ends captures all"+
            		 							 "\nof those pieces and place them in his Mancala. The player who has the most stones in his"+
            		 							 "\nMancala wins.");
        }
    }
}
