package texteditor.console;

import javax.swing.*;
import java.util.Set;

/**
 * Holds the values that make up the different menus in the menubar.
 */
public class MyMenuColumn {

    private JMenu menu;
    private Set<JMenuItem> menuItems;
    private Set<String> menuOptions;

    public MyMenuColumn(JMenu menu, Set<JMenuItem> menuItems, Set<String> menuOptions) {
        this.menu = menu;
        this.menuItems = menuItems;
        this.menuOptions = menuOptions;
        connectOptionsToMenu();
    }

    private void connectOptionsToMenu() {
        menuOptions.forEach(option -> menuItems.add(new JMenuItem(option)));
        menuItems.forEach(menu::add);
    }

    public JMenu getMenu() {
        return menu;
    }

    public void setMenu(JMenu menu) {
        this.menu = menu;
    }

    public Set<JMenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(Set<JMenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public Set<String> getMenuOptions() {
        return menuOptions;
    }

    public void setMenuOptions(Set<String> menuOptions) {
        this.menuOptions = menuOptions;
    }
}
