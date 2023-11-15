package christmas.model.event;

import static christmas.model.constant.ChristmasEventConstant.MIN_PRICE;
import static christmas.model.event.Badge.NONE;

import christmas.model.date.EventPeriod;
import christmas.model.user.UserOrder;

public class BadgeEvent {
    private UserOrder userOrder;
    private long totalBenefit;
    private EventPeriod eventPeriod;

    public BadgeEvent(UserOrder userOrder, long totalBenefit, EventPeriod eventPeriod) {
        this.userOrder = userOrder;
        this.totalBenefit = totalBenefit;
        this.eventPeriod = eventPeriod;
    }

    public Badge findBadge() {
        if (isValidPrice()) {
            return Badge.getEventBadge(userOrder.getTotalPrice());
        }
        return NONE;
    }

    private boolean isValidPrice() {
        return userOrder.isExceed(MIN_PRICE);
    }
}
