package christmas.model.event;

import christmas.model.date.EventPeriod;
import christmas.model.user.UserDate;
import christmas.model.user.UserOrder;

public class GiftEvent extends Event {
    private final long standard;
    private final long discount;

    public GiftEvent(UserDate userDate, UserOrder userOrder, EventPeriod eventPeriod, long standard, long discount) {
        this.userDate = userDate;
        this.userOrder = userOrder;
        this.eventPeriod = eventPeriod;
        this.standard = standard;
        this.discount = discount;
    }

    @Override
    public long benefit() {
        if (isValidEventPeriod() && isValidPrice()) {
            return discount;
        }
        return 0L;
    }

    @Override
    protected boolean isValidPrice() {
        return userOrder.isExceed(discount);
    }
}
