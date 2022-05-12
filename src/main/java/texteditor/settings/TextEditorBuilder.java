package texteditor.settings;

import texteditor.console.MyMenuBar;
import texteditor.filechooser.FileOpener;
import texteditor.filechooser.FileSaver;
import texteditor.console.MyFrame;
import texteditor.console.MyMenuColumn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.HashSet;
import java.util.Set;

public class TextEditorBuilder implements ActionListener {

    MyTextEditor myTextEditor;

    public TextEditorBuilder() {

        MyMenuColumn menuFile = new MyMenuColumn(new JMenu("File"), new HashSet<>(), Set.of("New", "Open", "Save", "Print"));
        MyMenuColumn menuEdit = new MyMenuColumn(new JMenu("Edit"), new HashSet<>(), Set.of("cut", "copy", "paste"));
        JMenuItem close = new JMenuItem("Close");

        menuFile.connectOptionsToMenu();
        menuEdit.connectOptionsToMenu();

        MyMenuBar myMenuBar = new MyMenuBar(new JMenuBar(), menuFile.getMenu(), menuEdit.getMenu(), close);

        myMenuBar.addBars();

        myTextEditor = new MyTextEditor(new MyFrame(new JFrame("TextEditor"), new JTextArea(), 500, 500),
                (myMenuBar.getMenuBar())
        );

        menuFile.getMenuItems().forEach(item -> item.addActionListener(this));
        menuEdit.getMenuItems().forEach(item -> item.addActionListener(this));
        close.addActionListener(this);

        myTextEditor.myFrame.buildFrame(myTextEditor.getMenuBar());
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
        FileSaver fileSaver = new FileSaver(new JFileChooser("f:"));
        fileSaver.selectChosenFile();
        fileSaver.saveToFile(myTextEditor.myFrame.getTextArea());
    }
    private void print() {
        try {
            myTextEditor.myFrame.getTextArea().print();
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }
    private void open() {
        FileOpener fileOpener = new FileOpener(new JFileChooser("f:"));
        fileOpener.selectChosenFile();
        fileOpener.openFile(myTextEditor.myFrame.getTextArea());
    }
    private void newDocument() {
        myTextEditor.myFrame.getTextArea().setText("");
    }
    private void close() {
        myTextEditor.myFrame.show(false);
    }

    public MyTextEditor getMyTextEditor() {
        return myTextEditor;
    }

    public void setMyTextEditor(MyTextEditor myTextEditor) {
        this.myTextEditor = myTextEditor;
    }
}
