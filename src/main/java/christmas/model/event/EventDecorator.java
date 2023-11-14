package christmas.model.event;

import christmas.model.date.PromotionPeriod;
import christmas.model.user.User;

public abstract class EventDecorator extends User {
    protected PromotionPeriod promotionPeriod;

    public EventDecorator(User user, PromotionPeriod promotionPeriod) {
        super(user.getUserDate(), user.getOrder());
        this.promotionPeriod = promotionPeriod;
    }

    public abstract long event();
}
