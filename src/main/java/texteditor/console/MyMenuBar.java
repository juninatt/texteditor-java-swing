package texteditor.console;

import javax.swing.*;

public class MyMenuBar {

    JMenuBar menuBar;
    JMenu menuFile;
    JMenu menuEdit;
    JMenuItem close;

    public MyMenuBar(JMenuBar menuBar, JMenu menuFile, JMenu menuEdit, JMenuItem close) {
        this.menuBar = menuBar;
        this.menuFile = menuFile;
        this.menuEdit = menuEdit;
        this.close = close;
    }
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
