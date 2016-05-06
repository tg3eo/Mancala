import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*  Class:	MancalaTester
*  File:	MancalaTester.java
*  Description:	The tester class of the program. Includes an opening screen that
*  allows the user to choose to play with 3 or 4 stones, then which board to play
*  with, either the red board or the blue board.
*  @author:	Riadiani Marcelita, Tom George, Thanh Bui
*  Environment:	PC, Windows 8.1, jdk1.7.0_80, Eclipse Mars Release 4.5.0
*  Date:	5/7/2016
*  @version	%1% %2%
*  @see       	java.util.EmptyStackException;
*  History Log:	Created on April 5, 2016, 07:00 PM
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class MancalaTester {

	private static int stones;
    private static JFrame frame, viewFrame;
    private static JButton stone3;
    private static JButton stone4;
    private static JButton viewOne, viewTwo;
    private static JLabel stoneLabel, viewLabel;
    private static Container pane, pane2;
    private static JPanel p2, p3;

	
	public static void main(String[] args){		
	    	stones = 0;
	        frame = new JFrame();
	        pane = frame.getContentPane();
	        stone3 = new JButton("3");
	        stone4 = new JButton("4");
	        
	        System.out.println(stone3.getText());
	        stoneLabel = new JLabel("Select Number of Stones: ");
	        p2 = new JPanel();
	        p2.setLayout(null);
	        frame.setSize(300, 200);
	        frame.setTitle("Welcome to Mancala!");

	        pane.add(p2);
	        p2.add(stone3);
	        p2.add(stoneLabel);
	        p2.add(stone4);
	        
	        stoneLabel.setBounds(50, 20, 250, 50);
	        stone3.setBounds(70, 80, 50, 50);
	        stone4.setBounds(150, 80, 50, 50);
	        frame.setVisible(true);
	        
	        stones = 0;
	        viewFrame = new JFrame();
	        pane2 = viewFrame.getContentPane();
	        viewOne = new JButton("Red Board");
	        viewTwo = new JButton("Blue Board");
	        
	        viewLabel = new JLabel("Select View: ");
	        p3 = new JPanel();
	        p3.setLayout(null);
	        viewFrame.setSize(300, 200);

	        pane2.add(p3);
	        p3.add(viewOne);
	        p3.add(viewLabel);
	        p3.add(viewTwo);
	        
	        viewLabel.setBounds(150, 20, 250, 50);
	        viewOne.setBounds(70, 80, 100, 100);
	        viewTwo.setBounds(200, 80, 100, 100);
	        viewFrame.setTitle("Select View");
	        viewFrame.setSize(400, 400);
	        stone3.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					stones = 3;
					frame.dispose();
					viewFrame.setVisible(true);
				}
	        });
	        stone4.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					stones = 4;
					frame.dispose();
					viewFrame.setVisible(true);
				}
	        });
	        
	        viewOne.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		MancalaGUI mg = new MancalaGUI(new BoardColoredOne());
	        		MancalaBoard mb = new MancalaBoard(stones);
	        		Controller c = new Controller(mb, mg);
	        		viewFrame.dispose();
	        	}
	        });
	        viewTwo.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		MancalaGUI mg = new MancalaGUI(new BoardColoredTwo());
	        		MancalaBoard mb = new MancalaBoard(stones);
	        		Controller c = new Controller(mb, mg);
	        		viewFrame.dispose();
	        	}
	        });
	}
}
