import javax.swing.*;

public class PitJButtons extends JButton {
    private int buttonIndex;

    public PitJButtons(String s, int i) {
        super(s);
        buttonIndex = i;
    }

    public int getIndex() {
        return buttonIndex;
    }
}