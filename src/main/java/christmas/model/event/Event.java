package christmas.model.event;

import static christmas.util.constant.ChristmasEventConstant.MIN_PRICE;

import christmas.model.date.EventPeriod;
import christmas.model.user.UserDate;
import christmas.model.user.UserOrder;

public abstract class Event {
    protected UserDate userDate;
    protected UserOrder userOrder;
    protected EventPeriod eventPeriod;

    public abstract long benefit();

    protected boolean isValidEventPeriod() {
        return userDate.isBetween(eventPeriod.getStartDate(), eventPeriod.getEndDate());
    }

    protected boolean isValidPrice() {
        return userOrder.isExceed(MIN_PRICE);
    }
}
