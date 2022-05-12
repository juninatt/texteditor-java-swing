package texteditor.settings;

import texteditor.console.MyFrame;

import javax.swing.*;

public class MyTextEditor {
    MyFrame myFrame;
    JMenuBar menuBar;

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