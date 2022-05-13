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

    /**
     * Constructor that initializes all fields.
     * @param menu Represents a pull-down-menu assigned to the menu bar
     * @param menuItems Is the list of components to fill the menu, that the user can interact with.
     * @param menuOptions Is the list of options that will be applied to the components in the menu.
     */
    public MyMenuColumn(JMenu menu, Set<JMenuItem> menuItems, Set<String> menuOptions) {
        this.menu = menu;
        this.menuItems = menuItems;
        this.menuOptions = menuOptions;
    }

    /**
     * Method that iterates Set{@link #menuOptions} and for each option creates a new component
     * to which it applies its value and adds to Set{@link #menuItems}.
     */
    public void connectOptionsToMenu() {
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
