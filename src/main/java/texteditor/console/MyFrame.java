package texteditor.console;

import javax.swing.*;

/**
 * Holds the values that describe the general outlook of the texteditor.
 */
public class MyFrame {

    private JFrame frame;
    private JTextArea textArea;
    private int width;
    private int height;

    /**
     * Constructor that initializes all fields.
     * @param frame Represents the main window to which components like menus, text-fields, buttons etc. are added.
     * @param textArea The text-field where all the writing and editing is done in the text-editor.
     * @param width Starting width of the console window.
     * @param height Starting height of the console window.
     */
    public MyFrame(JFrame frame, JTextArea textArea, int width, int height) {
        this.frame = frame;
        this.textArea = textArea;
        this.width = width;
        this.height = height;
    }

    /**
     * Method that first adds menubar, text-field and size to the frame, then creates the GUI.
     * @param menuBar Is the menubar that holds File-menu, Edit-menu and Close-button
     */
    public void buildFrame(JMenuBar menuBar) {
        frame.setJMenuBar(menuBar);
        frame.add(textArea);
        frame.setSize(width, height);
    }

    /**
     * Method that controls whether the GUI is displayed on the screen.
     * @param visible If the value of 'visible' is set to True, the frame is displayed.
     */
    public void show(boolean visible) {
        frame.setVisible(visible);
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
