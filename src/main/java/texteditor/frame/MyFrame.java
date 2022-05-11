package texteditor.frame;

import javax.swing.*;

public class MyFrame {

    JFrame frame;
    JTextArea textArea;
    int width;
    int height;

    public MyFrame(JFrame frame, JTextArea textArea, int width, int height) {
        this.frame = frame;
        this.textArea = textArea;
        this.width = width;
        this.height = height;
    }

    public void buildFrame(JMenuBar menuBar) {
        frame.setJMenuBar(menuBar);
        frame.add(textArea);
        frame.setSize(width, height);
        frame.setVisible(true);
    }
    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}