package christmas.model.event;

import static christmas.model.menu.MenuCategory.DESSERT;

import christmas.model.date.EventPeriod;
import christmas.model.menu.MenuCategory;
import christmas.model.user.UserDate;
import christmas.model.user.UserOrder;

public class WeekdayEvent extends Event {
    private final long discount;

    public WeekdayEvent(UserDate userDate, UserOrder userOrder, EventPeriod eventPeriod, long discount) {
        this.userDate = userDate;
        this.userOrder = userOrder;
        this.eventPeriod = eventPeriod;
        this.discount = discount;
    }

    @Override
    public long benefit() {
        if (isValidEventPeriod() && isValidPrice()) {
            return calculateDiscount();
        }
        return 0L;
    }

    private long calculateDiscount() {
        if (!userDate.isWeekend()) {
            return calculateDiscountByCategory(DESSERT);
        }
        return 0L;
    }

    private long calculateDiscountByCategory(MenuCategory menuCategory) {
        return userOrder.countMenuItemsByCategory(menuCategory) * discount;
    }
}
