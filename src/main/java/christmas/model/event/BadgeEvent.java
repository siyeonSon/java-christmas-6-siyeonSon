package christmas.model.event;

import static christmas.model.constant.ChristmasEventConstant.MIN_PRICE;
import static christmas.model.event.Badge.NONE;

import christmas.model.date.EventPeriod;
import christmas.model.user.UserDate;
import christmas.model.user.UserOrder;

public class BadgeEvent {
    private final UserDate userDate;
    private final UserOrder userOrder;
    private final EventPeriod eventPeriod;

    public BadgeEvent(UserDate userDate, UserOrder userOrder, EventPeriod eventPeriod) {
        this.userDate = userDate;
        this.userOrder = userOrder;
        this.eventPeriod = eventPeriod;
    }

    public Badge benefit() {
        if (isValidEventPeriod() && isValidPrice()) {
            return Badge.getEventBadge(userOrder.getTotalPrice());
        }
        return NONE;
    }

    private boolean isValidEventPeriod() {
        return userDate.isBetween(eventPeriod.getStartDate(), eventPeriod.getEndDate());
    }

    private boolean isValidPrice() {
        return userOrder.isExceed(MIN_PRICE);
    }
}
