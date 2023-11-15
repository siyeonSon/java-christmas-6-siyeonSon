package christmas.model.event;

import christmas.model.date.EventPeriod;
import christmas.model.user.UserDate;
import christmas.model.user.UserOrder;

public class DdayEvent extends Event {
    private final long baseDiscount;
    private final long dailyDiscount;

    public DdayEvent(UserDate userDate, UserOrder userOrder, EventPeriod eventPeriod, long baseDiscount, long dailyDiscount) {
        this.userDate = userDate;
        this.userOrder = userOrder;
        this.eventPeriod = eventPeriod;
        this.baseDiscount = baseDiscount;
        this.dailyDiscount = dailyDiscount;
    }

    @Override
    public long benefit() {
        if (isValidEventPeriod() && isValidPrice()) {
            return calculateDiscount();
        }
        return 0L;
    }

    private long calculateDiscount() {
        int dayOfUserDate = userDate.getDayOfMonth();
        int startDayOfPromotionPeriod = eventPeriod.getStartDate().getDayOfMonth();
        return baseDiscount + dailyDiscount * (dayOfUserDate - startDayOfPromotionPeriod);
    }
}
