package texteditor.settings;

import texteditor.console.MyFrame;
import texteditor.console.MyMenuBar;
import texteditor.console.MyMenuColumn;
import texteditor.filechooser.FileHandler;

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

    Set<JMenu> menus;
    Set<JMenuItem> menuItems;

    MyMenuBar myMenuBar;

    MyMenuColumn myMenuColumnFile;
    MyMenuColumn myMenuColumnEdit;

    FileHandler fileHandler;

    /**
     * A simple no noarg-constructor to set the values of the text-editor
     */
    public TextEditorBuilder() {

        myFrame = new MyFrame(new JFrame("TextEditor"), new JTextArea());
        myFrame.getFrame().setSize(500, 500);

        myMenuColumnFile = new MyMenuColumn(new JMenu("File"), new HashSet<>(), Set.of("New", "Open", "Save", "Print"));
        myMenuColumnEdit = new MyMenuColumn(new JMenu("Edit"), new HashSet<>(), Set.of("cut", "copy", "paste"));

        menus = new HashSet<>();
        menus.add(myMenuColumnFile.getMenu());
        menus.add(myMenuColumnEdit.getMenu());

        menuItems = new HashSet<>();
        menuItems.add(new JMenuItem("Close"));

        myMenuBar = new MyMenuBar(new JMenuBar(), menus, menuItems);
        myFrame.getFrame().setJMenuBar(myMenuBar.getMenuBar());

        fileHandler = new FileHandler(new JFileChooser());


        myMenuColumnFile.getMenuItems().forEach(item -> item.addActionListener(this));
        myMenuColumnEdit.getMenuItems().forEach(item -> item.addActionListener(this));
        menuItems.forEach(item -> item.addActionListener(this));

        myFrame.getFrame().setVisible(true);
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
        myFrame.getTextArea().cut();
    }

    /**
     * Copies the selected characters in the text-field.
     */
    private void copy() {
        myFrame.getTextArea().copy();
    }

    /**
     * Pastes any copied text to the text-field.
     */
    private void paste() {
        myFrame.getTextArea().paste();
    }

    /**
     * Saves the content of the text-field to a new file.
     */
    private void save() {
        fileHandler.getSavePath();
        fileHandler.saveText(myFrame.getTextArea());
    }

    /**
     * Opens the print-dialog window and presents the user with options for printing.
     */
    private void print() {
        try {
            myFrame.getTextArea().print();
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }

    /**
     * Copies the content of the selected file to the text-field.
     */
    private void open() {
        fileHandler.getOpenPath();
        fileHandler.openFile(myFrame.getTextArea());
    }

    /**
     * Removes any text from the text-field.
     */
    private void newDocument() {
        myFrame.getTextArea().setText("");
    }

    /**
     * Closes the text-editor.
     */
    private void close() {
        myFrame.getFrame().setVisible(false);
    }
}
