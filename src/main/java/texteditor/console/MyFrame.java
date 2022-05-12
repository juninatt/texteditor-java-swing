package texteditor.console;

import javax.swing.*;

public class MyFrame {

    private JFrame frame;
    private JTextArea textArea;
    private int width;
    private int height;

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
        show(true);
    }

    public void show(boolean visible) {
        frame.setVisible(visible);
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
