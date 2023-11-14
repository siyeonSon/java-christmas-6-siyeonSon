package christmas.model.menu;

import static christmas.util.message.ErrorMessages.ORDER_INVALID_EXCEPTION;

import christmas.model.user.UserOrder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Waiter {
    private static final String ITEM_SEPARATOR = ",";
    private static final String QUANTITY_SEPARATOR = "-";
    private static final int MIN_ORDER_QUANTITY = 1;
    private static final int MAX_ORDER_QUANTITY = 20;

    public static UserOrder generateOrder(String order) {
        Map<MenuItem, Integer> menuItems = generateMenuItems(order);
        validateTotalQuantity(menuItems);
        return new UserOrder(menuItems);
    }

    private static Map<MenuItem, Integer> generateMenuItems(String order) {
        Map<MenuItem, Integer> menuItems = new HashMap<>();
        Arrays.stream(order.split(ITEM_SEPARATOR))
                .forEach(orderItem -> parseMenuItem(orderItem, menuItems));
        return menuItems;
    }

    private static void parseMenuItem(String orderItem, Map<MenuItem, Integer> menuItems) {
        String[] parts = orderItem.split(QUANTITY_SEPARATOR);

        String itemName = parts[0];
        MenuItem menuItem = MenuItem.from(itemName);
        validateDuplication(menuItem, menuItems);

        int quantity = convertNumeric(parts[1]);
        validateQuantity(quantity);

        menuItems.put(menuItem, quantity);
    }

    private static void validateDuplication(MenuItem menuItem, Map<MenuItem, Integer> menuItems) {
        if (menuItems.containsKey(menuItem)) {
            throw new IllegalArgumentException(ORDER_INVALID_EXCEPTION);
        }
    }

    private static int convertNumeric(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ORDER_INVALID_EXCEPTION);
        }
    }

    private static void validateQuantity(int quantity) {
        if (isInvalidQuantity(quantity)) {
            throw new IllegalArgumentException(ORDER_INVALID_EXCEPTION);
        }
    }

    private static boolean isInvalidQuantity(int quantity) {
        return quantity < MIN_ORDER_QUANTITY || MAX_ORDER_QUANTITY < quantity;
    }

    private static void validateTotalQuantity(Map<MenuItem, Integer> menuItems) {
        if (findTotalQuantity(menuItems) > MAX_ORDER_QUANTITY) {
            throw new IllegalArgumentException(ORDER_INVALID_EXCEPTION);
        }
    }

    private static int findTotalQuantity(Map<MenuItem, Integer> menuItems) {
        return menuItems.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
