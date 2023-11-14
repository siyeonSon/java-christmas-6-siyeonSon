package christmas.model.user;

import christmas.model.menu.MenuItem;
import java.util.Map;

public class UserOrder {
    private final Map<MenuItem, Integer> menuItems;
    private final long totalPrice;

    public UserOrder(Map<MenuItem, Integer> menuItems) {
        this.menuItems = menuItems;
        this.totalPrice = calculateTotalPrice();
    }

    private long calculateTotalPrice() {
        return menuItems.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public Map<MenuItem, Integer> getMenuItems() {
        return menuItems;
    }

    public long getTotalPrice() {
        return totalPrice;
    }
}
