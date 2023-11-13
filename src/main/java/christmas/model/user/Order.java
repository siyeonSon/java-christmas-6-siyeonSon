package christmas.model.user;

import christmas.model.menu.MenuItem;
import java.util.Map;

public class Order {
    private final Map<MenuItem, Integer> menuItems;

    public Order(Map<MenuItem, Integer> menuItems) {
        this.menuItems = menuItems;
    }

    public Map<MenuItem, Integer> getMenuItems() {
        return menuItems;
    }
}
