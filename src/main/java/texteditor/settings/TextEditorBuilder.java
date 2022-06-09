package texteditor.settings;

import texteditor.console.MyFrame;
import texteditor.console.MyMenuBar;
import texteditor.console.MyMenuColumn;
import texteditor.console.MyTextEditor;
import texteditor.filechooser.FileOpener;
import texteditor.filechooser.FileSaver;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.HashSet;
import java.util.Set;

/**
 * The class where the values are set to the text-editor you want to build and
 * that holds the action-menu that handles user interaction.
 */
public class TextEditorBuilder implements ActionListener {

    MyFrame myFrame;
    MyMenuColumn menuFile;
    MyMenuColumn menuEdit;
    JMenuItem close;
    MyMenuBar myMenuBar;

    MyTextEditor myTextEditor;

    FileSaver fileSaver;
    FileOpener fileOpener;

    /**
     * A simple no noarg-constructor to set the values of the text-editor
     */
    public TextEditorBuilder() {

        /*  Creates an instance of MyFrame-class with a frame, text-field, width and length  */
        myFrame = new MyFrame(new JFrame("TextEditor"), new JTextArea(), 500, 500);

        /*  Creates an instance of MyMenuColumn-class with a menu named 'File' that holds options 'New', 'Open', 'Save' and 'Print'  */
        menuFile = new MyMenuColumn(new JMenu("File"), new HashSet<>(), Set.of("New", "Open", "Save", "Print"));

        /*  Creates an instance of MyMenuColumn-class with a menu named 'Edit' that holds the options 'cut', 'copy' and 'paste'  */
        menuEdit = new MyMenuColumn(new JMenu("Edit"), new HashSet<>(), Set.of("cut", "copy", "paste"));

        /*  Creates a Close-button  */
        close = new JMenuItem("Close");

        /*  Creates an instance of MyMenuBar-class with the File-menu, Edit-menu och Close-button  */
        myMenuBar = new MyMenuBar(new JMenuBar(), menuFile.getMenu(), menuEdit.getMenu(), close);

        /*  Creates an instance of MyTextEditor-class with the values from myFrame and the menuBar in myMenuBar  */
        myTextEditor = new MyTextEditor(myFrame, myMenuBar.getMenuBar());

        menuFile.connectOptionsToMenu();
        menuEdit.connectOptionsToMenu();
        myMenuBar.addBars();

        /*  Creates an instance of FileOpener-class with a JFileChooser pointing to the users default directory  */
        fileSaver = new FileSaver(new JFileChooser());
        fileOpener = new FileOpener(new JFileChooser());

        /*  Register menu components with the ActionListener in order for the user to interact with the menus  */
        menuFile.getMenuItems().forEach(item -> item.addActionListener(this));
        menuEdit.getMenuItems().forEach(item -> item.addActionListener(this));
        close.addActionListener(this);

        /*  Builds and displays the texteditor based on the values given to it in the code above  */
        myTextEditor.getMyFrame().buildFrame(myTextEditor.getMenuBar());
        myTextEditor.getMyFrame().show(true);
    }

    /**
     * Method that is invoked automatically whenever the user interacts with any of the registered components.
     * @param event Represents the mouse-click of a user.
     */
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

    /**
     * Copies and then removes the selected characters from the text-field.
     */
    private void cut() {
        myTextEditor.getMyFrame().getTextArea().cut();
    }

    /**
     * Copies the selected characters in the text-field.
     */
    private void copy() {
        myTextEditor.getMyFrame().getTextArea().copy();
    }

    /**
     * Pastes any copied text to the text-field.
     */
    private void paste() {
        myTextEditor.getMyFrame().getTextArea().paste();
    }

    /**
     * Saves the content of the text-field to a new file.
     */
    private void save() {
        fileSaver.selectChosenFile();
        fileSaver.saveToFile(myTextEditor.getMyFrame().getTextArea());
    }

    /**
     * Opens the print-dialog window and presents the user with options for printing.
     */
    private void print() {
        try {
            myTextEditor.getMyFrame().getTextArea().print();
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }

    /**
     * Copies the content of the selected file to the text-field.
     */
    private void open() {
        fileOpener.selectChosenFile();
        fileOpener.openFile(myTextEditor.getMyFrame().getTextArea());
    }

    /**
     * Removes any text from the text-field.
     */
    private void newDocument() {
        myTextEditor.getMyFrame().getTextArea().setText("");
    }

    /**
     * Closes the text-editor.
     */
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
