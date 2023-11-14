package christmas.model.event;

import christmas.model.date.PromotionPeriod;
import christmas.model.menu.MenuCategory;
import christmas.model.user.UserDate;
import christmas.model.user.UserOrder;

public class GiftEvent extends Event {
    private final long standard;
    private final long discount;

    public GiftEvent(UserDate userDate, UserOrder userOrder, PromotionPeriod promotionPeriod, long standard, long discount) {
        this.userDate = userDate;
        this.userOrder = userOrder;
        this.promotionPeriod = promotionPeriod;
        this.standard = standard;
        this.discount = discount;
    }

    @Override
    public long benefit() {
        if (isValidatePromotion() && isExceedStandard()) {
            return discount;
        }
        return 0L;
    }

    private boolean isValidatePromotion() {
        return userDate.isBetween(promotionPeriod.getStartDate(), promotionPeriod.getEndDate());
    }

    private boolean isExceedStandard() {
        return userOrder.isExceed(discount);
    }

    private long calculateDiscountByCategory(MenuCategory menuCategory) {
        return userOrder.countMenuItemsByCategory(menuCategory) * discount;
    }
}
