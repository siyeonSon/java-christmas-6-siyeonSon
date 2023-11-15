package christmas.model.event;

import christmas.model.date.EventPeriod;
import christmas.model.user.UserDate;
import christmas.model.user.UserOrder;
import java.time.LocalDate;
import java.util.List;

public class SpecialEvent extends Event {
    private final List<LocalDate> promotionDates;
    private final long discount;

    public SpecialEvent(UserDate userDate, UserOrder userOrder, EventPeriod eventPeriod, List<LocalDate> promotionDates, long discount) {
        this.userDate = userDate;
        this.userOrder = userOrder;
        this.eventPeriod = eventPeriod;
        this.discount = discount;
        this.promotionDates = promotionDates;
    }

    @Override
    public long benefit() {
        if (isValidEventPeriod() && isValidPrice() && isSpecialPromotionDate()) {
            return discount;
        }
        return 0L;
    }

    private boolean isSpecialPromotionDate() {
        return userDate.isBetween(promotionDates);
    }
}
