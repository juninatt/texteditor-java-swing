package texteditor.console;

import javax.swing.*;
import java.util.Set;

/**
 * Holds the values that describe the menubar that is applied to the text-editor.
 */
public class MyMenuBar {

    private JMenuBar menuBar;

    public MyMenuBar(JMenuBar menuBar, Set<JMenu> menus, Set<JMenuItem> menuItems) {
        this.menuBar = menuBar;
        addMenus(menus);
        addMenuItems(menuItems);
    }
    private void addMenus(Set<JMenu> menuSet) {
        menuSet.forEach(this.menuBar::add);
    }
    private void addMenuItems(Set<JMenuItem> itemSet) {
        itemSet.forEach(this.menuBar::add);
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

}
