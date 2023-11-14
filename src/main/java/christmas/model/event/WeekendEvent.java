package christmas.model.event;

import static christmas.model.menu.MenuCategory.MAIN;

import christmas.model.date.PromotionPeriod;
import christmas.model.menu.MenuCategory;
import christmas.model.user.UserDate;
import christmas.model.user.UserOrder;

public class WeekendEvent extends Event {
    private final long discount;

    public WeekendEvent(UserDate userDate, UserOrder userOrder, PromotionPeriod promotionPeriod, long discount) {
        this.userDate = userDate;
        this.userOrder = userOrder;
        this.discount = discount;
    }

    @Override
    public long benefit() {
        if (isValidatePromotion()) {
            return calculateDiscount();
        }
        return 0L;
    }

    private boolean isValidatePromotion() {
        return userDate.isBetween(promotionPeriod.getStartDate(), promotionPeriod.getEndDate());
    }

    private long calculateDiscount() {
        if (userDate.isWeekend()) {
            return calculateDiscountByCategory(MAIN);
        }
        return 0L;
    }

    private long calculateDiscountByCategory(MenuCategory menuCategory) {
        return userOrder.countMenuItemsByCategory(menuCategory) * discount;
    }
}
