package christmas.model.event;

import christmas.model.date.PromotionPeriod;
import christmas.model.user.UserDate;
import christmas.model.user.UserOrder;

public abstract class Event {
    protected UserDate userDate;
    protected UserOrder userOrder;
    protected PromotionPeriod promotionPeriod;

    public abstract long benefit();

    protected boolean isValidatePromotion() {
        return userDate.isBetween(promotionPeriod.getStartDate(), promotionPeriod.getEndDate());
    }
}
