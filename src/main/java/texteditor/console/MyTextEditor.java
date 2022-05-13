package texteditor.console;

import javax.swing.*;


/**
 * Holds the values that describe the frame and menubar,
 * which together make up the text-editor.
 */
public class MyTextEditor {
    MyFrame myFrame;
    JMenuBar menuBar;

    /**
     * Constructor that initializes all fields.
     * @param myFrame Holds the values that describe the general outlook of the texteditor.
     * @param menuBar  Holds the values that describe the menubar that is applied to the text-editor.
     */
    public MyTextEditor(MyFrame myFrame, JMenuBar menuBar) {
        this.myFrame = myFrame;
        this.menuBar = menuBar;
    }

    public MyFrame getMyFrame() {
        return myFrame;
    }

    public void setMyFrame(MyFrame myFrame) {
        this.myFrame = myFrame;
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }
}