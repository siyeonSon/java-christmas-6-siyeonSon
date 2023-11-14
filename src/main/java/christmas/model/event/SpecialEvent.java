package christmas.model.event;

import christmas.model.date.PromotionPeriod;
import christmas.model.user.UserDate;
import christmas.model.user.UserOrder;
import java.time.LocalDate;
import java.util.List;

public class SpecialEvent extends Event {
    private final List<LocalDate> promotionDates;
    private final long discount;

    public SpecialEvent(UserDate userDate, UserOrder userOrder, PromotionPeriod promotionPeriod, List<LocalDate> promotionDates, long discount) {
        this.userDate = userDate;
        this.userOrder = userOrder;
        this.promotionPeriod = promotionPeriod;
        this.discount = discount;
        this.promotionDates = promotionDates;
    }

    @Override
    public long benefit() {
        if (isValidatePromotion() && isSpecialPromotionDate()) {
            return discount;
        }
        return 0L;
    }

    private boolean isValidatePromotion() {
        return userDate.isBetween(promotionPeriod.getStartDate(), promotionPeriod.getEndDate());
    }

    private boolean isSpecialPromotionDate() {
        return userDate.isBetween(promotionDates);
    }
}
