package christmas.model.event;

import static christmas.model.constant.ChristmasPromotionConstant.MIN_PRICE;
import static christmas.model.event.Badge.NONE;

import christmas.model.date.PromotionPeriod;
import christmas.model.user.UserDate;
import christmas.model.user.UserOrder;

public class BadgeEvent {
    private final UserDate userDate;
    private final UserOrder userOrder;
    private final PromotionPeriod promotionPeriod;

    public BadgeEvent(UserDate userDate, UserOrder userOrder, PromotionPeriod promotionPeriod) {
        this.userDate = userDate;
        this.userOrder = userOrder;
        this.promotionPeriod = promotionPeriod;
    }

    public Badge benefit() {
        if (isValidEventPeriod() && isValidPrice()) {
            return Badge.getEventBadge(userOrder.getTotalPrice());
        }
        return NONE;
    }

    private boolean isValidEventPeriod() {
        return userDate.isBetween(promotionPeriod.getStartDate(), promotionPeriod.getEndDate());
    }

    private boolean isValidPrice() {
        return userOrder.isExceed(MIN_PRICE);
    }
}
