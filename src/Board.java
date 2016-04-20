import javax.swing.*;	//needed for graphics
import java.awt.*;
import java.awt.event.*;  // needed for ActionEvent


public class Board 
{
	private JFrame frame;
    private Container c;
    {
	// Entry for graphics application
		frame = new JFrame("Mancala Game");
		
		c = frame.getContentPane();
		pro.init(c);

		// pack up and show the window, don't touch this part
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.pack();
	    frame.setVisible(true);
	}

}

class pro {

	static JLabel labelBside = new JLabel("Player B");
	static JLabel labelAside = new JLabel("Player A");
	/* the bins are laid out as follows:
	   12	11	10	9	8	7
	13							6
       0	1	2	3	4	5
	*/
	static JButton bins[] = {
		new JButton("A6     "),
		new JButton("A5     "),
		new JButton("A4     "),
		new JButton("A3     "),
		new JButton("A2     "),
		new JButton("A1     "),
		new JButton("A's mancala     "),
		new JButton("B6     "),
		new JButton("B5     "),
		new JButton("B4     "),
		new JButton("B3     "),
		new JButton("B2     "),
		new JButton("B1     "),
		new JButton("B's mancala     ")};

	static String buttonTexts[] = {
			"A6","A5", "A4", "A3", "A2", "A1",
			"A's mancala",
			"B6","B5", "B4", "B3", "B2", "B1",
			"B's mancala"};
		
	static void init(Container c)
		{
		Container topLine = new Container(); // Create a container
		topLine.setLayout( new FlowLayout() ); // Layout from left to right
		for(int i=12; i>=7; i--) topLine.add(pro.bins[i]);
		
		Container bottomLine = new Container();
		// Layout from left to right
		bottomLine.setLayout( new FlowLayout() );
		for(int i=0; i<=5; i++) bottomLine.add(pro.bins[i]);

		Container twoLines = new Container();
		// layout from top to bottom
		twoLines.setLayout( new BoxLayout(twoLines, BoxLayout.Y_AXIS) );
		twoLines.add(topLine);
		twoLines.add(bottomLine);

		// Conbine the two lines with the mancalas on both sides
		Container binsContainer = new Container();		// Create another container
		binsContainer.setLayout(new FlowLayout());		// Layout from left to right
		binsContainer.add(pro.bins[13]);				// On left: mancala for B
		binsContainer.add(twoLines);					// then the two lines of bins
		binsContainer.add(pro.bins[6]);					// and mancala for A on right

		// Now, add some lables on top and bottom of the board
		c.setLayout( new BoxLayout(c, BoxLayout.Y_AXIS) ); // layout from top to bottom
		
		c.add(labelBside);		// labelBside are on top
		c.add(binsContainer);	// below is the board
		c.add(labelAside);		// then labelAside
		
	}
}
