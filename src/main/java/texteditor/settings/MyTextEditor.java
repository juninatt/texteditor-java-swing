package texteditor.settings;

import texteditor.frame.MyFrame;
import texteditor.frame.MyMenuBar;

public class MyTextEditor {
    MyFrame myFrame;
    MyMenuBar myMenuBar;

    public MyTextEditor(MyFrame myFrame, MyMenuBar myMenuBar) {
        this.myFrame = myFrame;
        this.myMenuBar = myMenuBar;
    }
}