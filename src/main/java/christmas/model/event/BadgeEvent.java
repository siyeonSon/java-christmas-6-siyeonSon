package christmas.model.event;

import static christmas.model.event.Badge.NONE;

import christmas.model.date.EventPeriod;
import christmas.model.user.UserDate;
import christmas.model.user.UserOrder;

public class BadgeEvent extends Event {
    public BadgeEvent(UserDate userDate, UserOrder userOrder, EventPeriod eventPeriod) {
        this.userDate = userDate;
        this.userOrder = userOrder;
        this.eventPeriod = eventPeriod;
    }

    public Badge findBadge() {
        if (isValidEventPeriod() && isValidPrice()) {
            return Badge.getEventBadge(userOrder.getTotalPrice());
        }
        return NONE;
    }

    @Override
    public long benefit() {
        return 0L;
    }
}
