package texteditor.console;

import javax.swing.*;

/**
 * Holds the values that describe the menubar that is applied to the text-editor.
 */
public class MyMenuBar {

    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenu menuEdit;
    private JMenuItem close;

    /**
     * Constructor that initializes all fields.
     * @param menuBar  Is the menubar that holds File-menu, Edit-menu and Close-button.
     * @param menuFile Is the menu that holds the File-options.
     * @param menuEdit Is the menu that holds the Edit-options.
     * @param close Is the component that act like the Close-button on the menubar
     */
    public MyMenuBar(JMenuBar menuBar, JMenu menuFile, JMenu menuEdit, JMenuItem close) {
        this.menuBar = menuBar;
        this.menuFile = menuFile;
        this.menuEdit = menuEdit;
        this.close = close;
    }

    /**
     * Method that adds File-menu, Edit-menu and Close-button to menubar
     */
    public void addBars() {
        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(close);
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public JMenu getMenuFile() {
        return menuFile;
    }

    public void setMenuFile(JMenu menuFile) {
        this.menuFile = menuFile;
    }

    public JMenu getMenuEdit() {
        return menuEdit;
    }

    public void setMenuEdit(JMenu menuEdit) {
        this.menuEdit = menuEdit;
    }

    public JMenuItem getClose() {
        return close;
    }

    public void setClose(JMenuItem close) {
        this.close = close;
    }
}
