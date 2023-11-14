package christmas.model.event;

import static christmas.model.menu.MenuCategory.DESSERT;
import static christmas.model.menu.MenuCategory.MAIN;

import christmas.model.date.PromotionPeriod;
import christmas.model.menu.MenuCategory;
import christmas.model.user.User;

public class WeekEvent extends EventDecorator {
    private final long discount;

    public WeekEvent(User user, PromotionPeriod promotionPeriod, long discount) {
        super(user, promotionPeriod);
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
        return calculateDiscountByCategory(DESSERT);
    }

    private long calculateDiscountByCategory(MenuCategory menuCategory) {
        return userOrder.countMenuItemsByCategory(menuCategory) * discount;
    }
}
