package christmas.model.event;

import static christmas.model.constant.ChristmasPromotionConstant.CHRISTMAS_D_DAY_DATE;
import static christmas.model.constant.ChristmasPromotionConstant.CHRISTMAS_D_DAY_EVENT_BASE_DISCOUNT;
import static christmas.model.constant.ChristmasPromotionConstant.CHRISTMAS_D_DAY_EVENT_DAILY_DISCOUNT;
import static christmas.model.constant.ChristmasPromotionConstant.CHRISTMAS_PROMOTION_END_DATE;
import static christmas.model.constant.ChristmasPromotionConstant.CHRISTMAS_PROMOTION_MONTH;
import static christmas.model.constant.ChristmasPromotionConstant.CHRISTMAS_PROMOTION_START_DATE;
import static christmas.model.constant.ChristmasPromotionConstant.CHRISTMAS_PROMOTION_YEAR;
import static christmas.model.constant.ChristmasPromotionConstant.GIFT_EVENT_MENU_ITEM;
import static christmas.model.constant.ChristmasPromotionConstant.GIFT_EVENT_STANDARD_AMOUNT;
import static christmas.model.constant.ChristmasPromotionConstant.SPECIAL_EVENT_DAYS;
import static christmas.model.constant.ChristmasPromotionConstant.SPECIAL_EVENT_DISCOUNT;
import static christmas.model.constant.ChristmasPromotionConstant.WEEK_EVENT_DISCOUNT;

import christmas.model.date.PromotionPeriod;
import christmas.model.user.UserDate;
import christmas.model.user.UserOrder;
import java.time.LocalDate;
import java.util.List;

public class EventManager {
    public long applyDdayEvent(UserDate userDate, UserOrder userOrder) {
        Event ddayEvent = new DdayEvent(userDate, userOrder, getDdayPromotionPeriod(),
                CHRISTMAS_D_DAY_EVENT_BASE_DISCOUNT, CHRISTMAS_D_DAY_EVENT_DAILY_DISCOUNT);
        return ddayEvent.benefit();
    }

    public long applyWeekdayEvent(UserDate userDate, UserOrder userOrder) {
        Event weekdayEvent = new WeekdayEvent(userDate, userOrder, getPromotionPeriod(), WEEK_EVENT_DISCOUNT);
        return weekdayEvent.benefit();
    }

    public long applyWeekendEvent(UserDate userDate, UserOrder userOrder) {
        Event weekendEvent = new WeekendEvent(userDate, userOrder, getPromotionPeriod(), WEEK_EVENT_DISCOUNT);
        return weekendEvent.benefit();
    }

    public long applySpecialEvent(UserDate userDate, UserOrder userOrder) {
        Event specialEvent = new SpecialEvent(userDate, userOrder, getPromotionPeriod(),
                getSpecialPromotionDays(), SPECIAL_EVENT_DISCOUNT);
        return specialEvent.benefit();
    }

    public long applyGiftEvent(UserDate userDate, UserOrder userOrder) {
        Event ddayEvent = new GiftEvent(userDate, userOrder, getPromotionPeriod(),
                GIFT_EVENT_STANDARD_AMOUNT, GIFT_EVENT_MENU_ITEM.getPrice());
        return ddayEvent.benefit();
    }

    public Badge getEventBadge(UserDate userDate, UserOrder userOrder) {
        BadgeEvent badgeEvent = new BadgeEvent(userDate, userOrder, getPromotionPeriod());
        return badgeEvent.benefit();
    }

    private PromotionPeriod getDdayPromotionPeriod() {
        return new PromotionPeriod(
                LocalDate.of(CHRISTMAS_PROMOTION_YEAR, CHRISTMAS_PROMOTION_MONTH, CHRISTMAS_PROMOTION_START_DATE),
                LocalDate.of(CHRISTMAS_PROMOTION_YEAR, CHRISTMAS_PROMOTION_MONTH, CHRISTMAS_D_DAY_DATE)
        );
    }

    private PromotionPeriod getPromotionPeriod() {
        return new PromotionPeriod(
                LocalDate.of(CHRISTMAS_PROMOTION_YEAR, CHRISTMAS_PROMOTION_MONTH, CHRISTMAS_PROMOTION_START_DATE),
                LocalDate.of(CHRISTMAS_PROMOTION_YEAR, CHRISTMAS_PROMOTION_MONTH, CHRISTMAS_PROMOTION_END_DATE)
        );
    }

    private List<LocalDate> getSpecialPromotionDays() {
        return SPECIAL_EVENT_DAYS.stream()
                .map(day -> LocalDate.of(CHRISTMAS_PROMOTION_YEAR, CHRISTMAS_PROMOTION_MONTH, day))
                .toList();
    }
}
