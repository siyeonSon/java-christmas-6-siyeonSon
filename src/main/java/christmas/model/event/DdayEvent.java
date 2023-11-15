package christmas.model.event;

import christmas.model.date.PromotionPeriod;
import christmas.model.user.UserDate;
import christmas.model.user.UserOrder;

public class DdayEvent extends Event {
    private final long baseDiscount;
    private final long dailyDiscount;

    public DdayEvent(UserDate userDate, UserOrder userOrder, PromotionPeriod promotionPeriod, long baseDiscount, long dailyDiscount) {
        this.userDate = userDate;
        this.userOrder = userOrder;
        this.promotionPeriod = promotionPeriod;
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
        int startDayOfPromotionPeriod = promotionPeriod.getStartDate().getDayOfMonth();
        return baseDiscount + dailyDiscount * (dayOfUserDate - startDayOfPromotionPeriod);
    }
}
