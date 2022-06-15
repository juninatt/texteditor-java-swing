package texteditor.console;

import javax.swing.*;

/**
 * Holds the values that describe the general outlook of the texteditor.
 */
public class MyFrame {

    private JFrame frame;
    private JTextArea textArea;

    public MyFrame(JFrame frame, JTextArea textArea) {
        this.frame = frame;
        this.textArea = textArea;
        this.frame.add(textArea);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTextArea getTextArea() {
        return textArea;
    }
    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }
}
