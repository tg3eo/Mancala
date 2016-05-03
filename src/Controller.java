import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Controller implements ChangeListener {

	private MancalaBoard mb;
	private MancalaGUI mg;
	private JButton[] temp;
	
	private Controller(MancalaBoard mBoard, MancalaGUI mGUI){
		mb = mBoard;
		mg = mGUI;
		mb.attach(this);
		attachListeners();
		stateChanged(null);
	}
	
	public void attachListeners(){
		
		mg.undoButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				mb.undo();
			}
		});
	}
	
	public void stateChanged(ChangeEvent e){
		temp = mg.getPits();
	}
}
