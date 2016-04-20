import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * A frame that asks the user how many stones to put in each pit in the beginning of the game
 * @author Thanh, Riri, Tom
 *
 */
public class View
{
    private JFrame frame;
    private JButton stone3;
    private JButton stone4;
    private JLabel stoneLabel;
    private Container pane;
    private JPanel p2;

    {
        frame = new JFrame();
        pane = frame.getContentPane();
        stone3 = new JButton("3");
        stone4 = new JButton("4");
        
        System.out.println(stone3.getText());
        stoneLabel = new JLabel("Select Number of Stones: ");
        p2 = new JPanel();
        p2.setLayout(null);
        frame.setSize(300, 200);
        

        pane.add(p2);
        p2.add(stone3);
        p2.add(stoneLabel);
        p2.add(stone4);
        
        stoneLabel.setForeground(Color.BLUE);
        stoneLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
        stoneLabel.setBounds(50, 20, 250, 50);
        stone3.setBounds(70, 80, 50, 50);
        stone4.setBounds(150, 80, 50, 50);

        frame.setVisible(true);
        

        stone3.addActionListener(new Select_Action_3());
        stone4.addActionListener(new Select_Action_4());

    }

    /**
     * @author Thanh, Riri, Tom
     *Action listener for selecting 3 stones. The program will then run with the configured layout and stones set.
     */
    public class Select_Action_3 implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
                Model model = new Model();
                model.setPits(3);
        		Board b1 = new Board();
                frame.dispose();
        }
    }

    /**
     * @author Thanh, Riri, Tom
     *Action listener for selecting 4 stones. The program will then run with the configured layout and stones set.
     */
    public class Select_Action_4 implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
        		Model model = new Model();
        		model.setPits(4);
        		Board b1 = new Board();
                frame.dispose();
            
        }
    }

}
