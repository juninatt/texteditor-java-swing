package texteditor.filechooser;

import javax.swing.*;
import java.io.*;

public class FileHandler {

    JFileChooser fileChooser;

    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;

    String file;

    public FileHandler(JFileChooser fileChooser) {
        this.fileChooser = fileChooser;
    }

    public void getSavePath() {
        if (showSaveDialog())
            getAbsolutePath();
    }

    public void getOpenPath() {
        if (showOpenDialog())
            getAbsolutePath();
    }

    private void getAbsolutePath() {
        file = fileChooser.getSelectedFile().getAbsolutePath();
    }

    private boolean showSaveDialog() {
        return fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION;
    }

    private boolean showOpenDialog() {
        return fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION;
    }

    public void saveText(JTextArea textArea) {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file, false));
            bufferedWriter.write(textArea.getText());
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException evt) {
            evt.printStackTrace();
        }
    }

    public void openFile(JTextArea textArea) {
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
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
}
