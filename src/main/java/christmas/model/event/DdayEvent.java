package christmas.model.event;

import christmas.model.date.PromotionPeriod;
import christmas.model.user.User;

public class DdayEvent extends EventDecorator {
    private final long baseDiscount;
    private final long dailyDiscount;

    public DdayEvent(User user, PromotionPeriod promotionPeriod, long baseDiscount, long dailyDiscount) {
        super(user, promotionPeriod);
        this.baseDiscount = baseDiscount;
        this.dailyDiscount = dailyDiscount;
    }

    @Override
    public long benefit() {
        if (isValidatePromotion()) {
            return calculateDiscount();
        }
        return 0L;
    }

    private boolean isValidatePromotion() {
        return userDate.isBetween(promotionPeriod.getStartDate(), promotionPeriod.getEndDate());
    }

    private long calculateDiscount() {
        int dayOfUserDate = userDate.getDayOfMonth();
        int startDayOfPromotionPeriod = promotionPeriod.getStartDate().getDayOfMonth();
        return baseDiscount + dailyDiscount * (dayOfUserDate - startDayOfPromotionPeriod);
    }
}
