package christmas.model.menu;

import static christmas.model.menu.MenuCategory.APPETIZER;
import static christmas.model.menu.MenuCategory.DESSERT;
import static christmas.model.menu.MenuCategory.DRINK;
import static christmas.model.menu.MenuCategory.MAIN;
import static christmas.util.constant.ErrorMessages.ORDER_INVALID_EXCEPTION;

import java.util.Arrays;

public enum MenuItem {
    MUSHROOM_SOUP("양송이수프", 6000, APPETIZER),
    TAPAS("타파스", 5500, APPETIZER),
    CAESAR_SALAD("시저샐러드", 8000, APPETIZER),
    T_BONE_STAKE("티본스테이크", 55000, MAIN),
    BARBECUE_LIBS("바비큐립", 54000, MAIN),
    SEAFOOD_PASTA("해산물파스타", 35000, MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, MAIN),
    CHOCOLATE_CAKE("초코케이크", 15000, DESSERT),
    ICE_CREAM("아이스크림", 5000, DESSERT),
    ZERO_COKE("제로콜라", 3000, DRINK),
    RED_WINE("레드와인", 60000, DRINK),
    CHAMPAGNE("샴페인", 25000, DRINK);

    private final String name;
    private final int price;
    private final MenuCategory menuCategory;

    MenuItem(String name, int price, MenuCategory menuCategory) {
        this.name = name;
        this.price = price;
        this.menuCategory = menuCategory;
    }

    public static MenuItem from(String name) {
        return Arrays.stream(values())
                .filter(item -> item.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ORDER_INVALID_EXCEPTION));
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public MenuCategory getMenuCategory() {
        return menuCategory;
    }
}
