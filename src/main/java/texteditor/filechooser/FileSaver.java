package texteditor.filechooser;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileSaver {

    JFileChooser fileSaver;
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;

    String file;

    int saveDialog;
    boolean choice;


    public FileSaver(JFileChooser fileSaver) {
        this.fileSaver = fileSaver;
    }

    private boolean checkOptionApproved() {
        choice = false;
        saveDialog = fileSaver.showSaveDialog(null);
        if (saveDialog == JFileChooser.APPROVE_OPTION)
            choice = true;
        return choice;
    }
    public void selectChosenFile() {
        if (checkOptionApproved())
            file = fileSaver.getSelectedFile().getAbsolutePath();
    }
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
