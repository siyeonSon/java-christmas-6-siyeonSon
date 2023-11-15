package christmas.model.event;

import static christmas.model.constant.ChristmasPromotionConstant.MIN_PRICE;

import christmas.model.date.PromotionPeriod;
import christmas.model.user.UserDate;
import christmas.model.user.UserOrder;

public abstract class Event {
    protected UserDate userDate;
    protected UserOrder userOrder;
    protected PromotionPeriod promotionPeriod;

    public abstract long benefit();

    protected boolean isValidEventPeriod() {
        return userDate.isBetween(promotionPeriod.getStartDate(), promotionPeriod.getEndDate());
    }

    protected boolean isValidPrice() {
        return userOrder.isExceed(MIN_PRICE);
    }
}
