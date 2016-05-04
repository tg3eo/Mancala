import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Controller implements ChangeListener {
    private MancalaBoard dataModel;
    private MancalaGUI gui;

    public Controller(MancalaBoard d, MancalaGUI g) {
        gui = g;
        dataModel = d;
        dataModel.attach(this);
        attachControllers();
        stateChanged(null);
    }

    public void attachControllers() {
        for(PitJButtons btn : gui.getPits())
            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dataModel.replaceState(new SaveState(dataModel));
                    dataModel.clicked(btn.getIndex());
                    dataModel.update();
                }
            });
        gui.getUndoButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dataModel.popUndo();
            }
        });
        gui.getEndButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dataModel.switchTurn();
            }
        });
        gui.getQuitButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Thank you!\n");
                System.exit(0);
            }
        });
    }

    public void stateChanged(ChangeEvent e) {
        gui.getMancalaA().setText("A: "+dataModel.getPlayerAScore());
        gui.getMancalaB().setText("B: "+dataModel.getPlayerBScore());
        gui.getEndButton().setEnabled(!dataModel.getLatestState().isNull() && dataModel.getUndosLeft() > 0);
        gui.getEndButton().setEnabled(dataModel.getSwitch());
        if(dataModel.getPlayerTurn())
            gui.getEndButton().setText("End Turn Player A");
        else
            gui.getEndButton().setText("End Turn Player B");
        for(int i = 0; i < gui.getPits().length; i++)
            if(i < 6) {
                gui.getPits()[i].setEnabled(!dataModel.getPlayerTurn() && !dataModel.getSwitch() && dataModel.getPitScore(i) > 0);
                gui.getPits()[i].setText("B"+(i+1)+": "+dataModel.getPitScore(i));
            } else {
                gui.getPits()[i].setEnabled(dataModel.getPlayerTurn() && !dataModel.getSwitch() && dataModel.getPitScore(i) > 0);
                gui.getPits()[i].setText("A"+(i-5)+": "+dataModel.getPitScore(i));
            }
    }
}