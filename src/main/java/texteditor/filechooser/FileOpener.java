package texteditor.filechooser;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileOpener {

    JFileChooser fileOpener;
    FileReader fileReader;
    BufferedReader bufferedReader;

    boolean choice;
    int openDialog;

    String file;

    public FileOpener(JFileChooser fileOpener) {
        this.fileOpener = fileOpener;
    }

    private boolean checkOptionApproved() {
        choice = false;
        openDialog = fileOpener.showSaveDialog(null);
        if (openDialog == JFileChooser.APPROVE_OPTION)
            choice = true;
        return choice;
    }

    public void selectChosenFile() {
        if (checkOptionApproved())
            file = fileOpener.getSelectedFile().getAbsolutePath();
    }

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

    public boolean isChoice() {
        return choice;
    }

    public void setChoice(boolean choice) {
        this.choice = choice;
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