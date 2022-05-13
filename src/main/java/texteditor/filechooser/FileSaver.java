package texteditor.filechooser;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Holds the functions used when a user wants to save a file from the text-editor.
 */
public class FileSaver {

    JFileChooser fileSaver;
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;

    String file;

    int saveDialog;
    boolean isApproved;


    /**
     * Constructor that initializes the fileSaver-field.
     * @param fileSaver Provides the mechanism for the user to choose where to save the file.
     */
    public FileSaver(JFileChooser fileSaver) {
        this.fileSaver = fileSaver;
    }

    /**
     * Method that invokes the showSaveDialog- function to show the save-dialog window to the user
     * and returns true if the user chooses save the text as a new file.
     */
    private boolean checkOptionApproved() {
        isApproved = false;
        saveDialog = fileSaver.showSaveDialog(null);
        if (saveDialog == JFileChooser.APPROVE_OPTION)
            isApproved = true;
        return isApproved;
    }

    /**
     * Method that sets the label to the path of the selected directory,
     * if it passed the {@link #checkOptionApproved()} method.
     */
    public void selectChosenFile() {
        if (checkOptionApproved())
            file = fileSaver.getSelectedFile().getAbsolutePath();
    }

    /**
     * Method that takes the text from the text-field given to the method as a parameter
     * and copies it into the new file.
     * @param textArea The text-field where all the writing and editing is done in the text-editor.
     */
    public void saveToFile(JTextArea textArea) {
        try {
            fileWriter = new FileWriter(file, false);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(textArea.getText());
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException evt) {
            evt.printStackTrace();
        }
    }
}
