package texteditor.filechooser;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Holds the functions used when a user wants to open a file in the text-editor.
 */
public class FileOpener {

    JFileChooser fileOpener;
    FileReader fileReader;
    BufferedReader bufferedReader;

    boolean isApproved;

    int openDialog;

    String file;


    /**
     * Constructor that initializes the fileOpener-field.
     * @param fileOpener Provides the mechanism for the user to choose and open a file.
     */
    public FileOpener(JFileChooser fileOpener) {
        this.fileOpener = fileOpener;
    }

    /**
     * Method that invokes the showOpenDialog- function to show the open-dialog window to the user
     * and returns true if the user chooses a file to open.
     */
    private boolean checkOptionApproved() {
        isApproved = false;
        openDialog = fileOpener.showOpenDialog(null);
        if (openDialog == JFileChooser.APPROVE_OPTION)
            isApproved = true;
        return isApproved;
    }

    /**
     * Method that sets the label to the path of the selected directory,
     * if it passed the {@link #checkOptionApproved()} method.
     */
    public void selectChosenFile() {
        if (checkOptionApproved())
            file = fileOpener.getSelectedFile().getAbsolutePath();
    }

    /**
     * Method that reads the content of the file to be opened and copies the text to the text-field given
     * to the method as a parameter, which it then returns.
     * @param textArea The text-field where all the writing and editing is done in the text-editor.
     */
    public void openFile(JTextArea textArea) {
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            StringBuilder fullText = new StringBuilder(bufferedReader.readLine());
            String text;
            while ((text = bufferedReader.readLine()) != null) {
                fullText.append("\n").append(text);
            }
            textArea.setText(fullText.toString());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public JFileChooser getFileOpener() {
        return fileOpener;
    }

    public void setFileOpener(JFileChooser fileOpener) {
        this.fileOpener = fileOpener;
    }

    public FileReader getFileReader() {
        return fileReader;
    }

    public void setFileReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        this.isApproved = approved;
    }

    public int getOpenDialog() {
        return openDialog;
    }

    public void setOpenDialog(int openDialog) {
        this.openDialog = openDialog;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}