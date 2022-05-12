package texteditor.settings;

import texteditor.console.MyMenuBar;
import texteditor.console.MyTextEditor;
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

        myTextEditor.getMyFrame().buildFrame(myTextEditor.getMenuBar());
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
        myTextEditor.getMyFrame().getTextArea().cut();
    }
    private void copy() {
        myTextEditor.getMyFrame().getTextArea().copy();
    }
    private void paste() {
        myTextEditor.getMyFrame().getTextArea().paste();
    }
    private void save() {
        FileSaver fileSaver = new FileSaver(new JFileChooser("f:"));
        fileSaver.selectChosenFile();
        fileSaver.saveToFile(myTextEditor.getMyFrame().getTextArea());
    }
    private void print() {
        try {
            myTextEditor.getMyFrame().getTextArea().print();
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }
    private void open() {
        FileOpener fileOpener = new FileOpener(new JFileChooser("f:"));
        fileOpener.selectChosenFile();
        fileOpener.openFile(myTextEditor.getMyFrame().getTextArea());
    }
    private void newDocument() {
        myTextEditor.getMyFrame().getTextArea().setText("");
    }
    private void close() {
        myTextEditor.getMyFrame().show(false);
    }

    public MyTextEditor getMyTextEditor() {
        return myTextEditor;
    }

    public void setMyTextEditor(MyTextEditor myTextEditor) {
        this.myTextEditor = myTextEditor;
    }
}
