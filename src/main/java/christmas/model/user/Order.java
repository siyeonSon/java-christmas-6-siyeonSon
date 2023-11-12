package christmas.model.user;

import static christmas.util.message.ErrorMessages.ORDER_INVALID_EXCEPTION;

import christmas.model.menu.MenuItem;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private static final String ITEM_SEPARATOR = ",";
    private static final String QUANTITY_SEPARATOR = "-";
    private static final int MIN_ORDER_QUANTITY = 1;
    private static final int MAX_ORDER_QUANTITY = 20;

    private Map<MenuItem, Integer> menuItems;

    public Order(String order) {
        menuItems = new HashMap<>();
        parseMenuItems(order);
        validateTotalQuantity();
    }

    private void parseMenuItems(String order) {
        Arrays.stream(order.split(ITEM_SEPARATOR))
                .forEach(this::parseMenuItem);
    }

    private void parseMenuItem(String orderItem) {
        String[] parts = orderItem.split(QUANTITY_SEPARATOR);

        String itemName = parts[0];
        MenuItem menuItem = MenuItem.from(itemName);
        validateDuplication(menuItem);

        int quantity = convertNumeric(parts[1]);
        validateQuantity(quantity);

        menuItems.put(menuItem, quantity);
    }

    private void validateDuplication(MenuItem menuItem) {
        if (isContain(menuItem)) {
            throw new IllegalArgumentException(ORDER_INVALID_EXCEPTION);
        }
    }

    private boolean isContain(MenuItem menuItem) {
        return menuItems.containsKey(menuItem);
    }

    private int convertNumeric(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ORDER_INVALID_EXCEPTION);
        }
    }

    private void validateQuantity(int quantity) {
        if (isInvalidQuantity(quantity)) {
            throw new IllegalArgumentException(ORDER_INVALID_EXCEPTION);
        }
    }

    private boolean isInvalidQuantity(int quantity) {
        return quantity < MIN_ORDER_QUANTITY || MAX_ORDER_QUANTITY < quantity;
    }

    private void validateTotalQuantity() {
        if (findTotalQuantity() > MAX_ORDER_QUANTITY) {
            throw new IllegalArgumentException(ORDER_INVALID_EXCEPTION);
        }
    }

    private int findTotalQuantity() {
        return menuItems.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
