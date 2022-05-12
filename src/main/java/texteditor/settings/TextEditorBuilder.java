package texteditor.settings;

import texteditor.frame.MyFrame;
import texteditor.frame.MyMenuBar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.HashSet;
import java.util.Set;

public class TextEditorBuilder implements ActionListener {

    MyTextEditor myTextEditor;

    public TextEditorBuilder() {

        myTextEditor = new MyTextEditor(new MyFrame(new JFrame("TextEditor"), new JTextArea(), 500, 500),
                     new MyMenuBar(new JMenuBar(), new JMenu("File"), new JMenu("Edit"), new JMenuItem("Close"))
        );

        myTextEditor.myMenuBar.addMenuOptionsToMenu(Set.of("New", "Open", "Save", "Print"), new HashSet<>(), myTextEditor.myMenuBar.getMenuOne());
        myTextEditor.myMenuBar.addMenuOptionsToMenu(Set.of("cut", "copy", "paste"), new HashSet<>(), myTextEditor.myMenuBar.getMenuTwo());
        myTextEditor.myMenuBar.addMenusToMenuBar();

        myTextEditor.myFrame.buildFrame(myTextEditor.myMenuBar.getMenuBar());
    }

    @Override
    public void actionPerformed (ActionEvent event){

        String command = event.getActionCommand();

        switch (command) {
            case "cut" -> cut();
            case "copy" -> copy();
            case "paste" -> paste();
            case "Save" -> save();
            case "Print" -> print();
            case "Open" -> open();
            case "New" -> newDocument();
            case "Close" -> close();
        }
    }
    private void cut() {
        myTextEditor.myFrame.getTextArea().cut();
    }
    private void copy() {
        myTextEditor.myFrame.getTextArea().copy();
    }
    private void paste() {
        myTextEditor.myFrame.getTextArea().paste();
    }
    private void save() {
    }
    private void print() {
        try {
            myTextEditor.myFrame.getTextArea().print();
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }
    private void open() {

    }
    private void newDocument() {
        myTextEditor.myFrame.getTextArea().setText("");
    }
    private void close() {
        myTextEditor.myFrame.show(false);
    }
}
