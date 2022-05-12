package texteditor.frame;

import javax.swing.*;
import java.util.Set;

public class MyMenuBar {

    private JMenuBar menuBar;
    private JMenu menuOne;
    private JMenu menuTwo;
    private JMenuItem close;

    public MyMenuBar(JMenuBar menuBar, JMenu menuOne, JMenu menuTwo, JMenuItem close) {
        this.menuBar = menuBar;
        this.menuOne = menuOne;
        this.menuTwo = menuTwo;
        this.close = close;
    }
    public void addMenuOptionsToMenu(Set<String> menuOptions, Set<JMenuItem> menuItems, JMenu menu) {
        menuOptions.forEach(option -> menuItems.add(new JMenuItem(option)));
        menuItems.forEach(menu::add);
    }
    public void addMenusToMenuBar() {
        menuBar.add(menuOne);
        menuBar.add(menuTwo);
        menuBar.add(close);
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public JMenu getMenuOne() {
        return menuOne;
    }

    public void setMenuOne(JMenu menuOne) {
        this.menuOne = menuOne;
    }

    public JMenu getMenuTwo() {
        return menuTwo;
    }

    public void setMenuTwo(JMenu menuTwo) {
        this.menuTwo = menuTwo;
    }

    public JMenuItem getClose() {
        return close;
    }

    public void setClose(JMenuItem close) {
        this.close = close;
    }
}
