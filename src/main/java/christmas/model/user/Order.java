package christmas.model.user;

import christmas.model.menu.MenuItem;
import java.util.Map;

public class Order {
    private Map<MenuItem, Integer> menuItems;

    public Order(Map<MenuItem, Integer> menuItems) {
        this.menuItems = menuItems;
    }
}
