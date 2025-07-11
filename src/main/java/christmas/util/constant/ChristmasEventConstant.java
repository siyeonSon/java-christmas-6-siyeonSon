package christmas.util.constant;

import christmas.model.menu.MenuItem;
import java.util.List;

public class ChristmasEventConstant {
    public static final int CHRISTMAS_EVENT_YEAR = 2023;
    public static final int CHRISTMAS_EVENT_MONTH = 12;
    public static final int CHRISTMAS_EVENT_START_DATE = 1;
    public static final int CHRISTMAS_D_DAY_DATE = 25;
    public static final int CHRISTMAS_EVENT_END_DATE = 31;
    public static final int MIN_ORDER_QUANTITY = 1;
    public static final int MAX_ORDER_QUANTITY = 20;
    public static final long MIN_PRICE = 10000;
    public static final long CHRISTMAS_D_DAY_EVENT_BASE_DISCOUNT = 1000;
    public static final long CHRISTMAS_D_DAY_EVENT_DAILY_DISCOUNT = 100;
    public static final long WEEK_EVENT_DISCOUNT = 2023;
    public static final long SPECIAL_EVENT_DISCOUNT = 1000;
    public static final List<Integer> SPECIAL_EVENT_DAYS = List.of(3, 7, 10, 17, 24, 25, 31);
    public static final long GIFT_EVENT_STANDARD_AMOUNT = 120000;
    public static final MenuItem GIFT_EVENT_MENU_ITEM = MenuItem.CHAMPAGNE;
    public static final int GIFT_EVENT_MENU_ITEM_AMOUNT = 1;
}
