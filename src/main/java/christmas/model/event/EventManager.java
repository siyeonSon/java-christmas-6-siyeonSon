package christmas.model.event;

import static christmas.util.constant.ChristmasEventConstant.CHRISTMAS_D_DAY_DATE;
import static christmas.util.constant.ChristmasEventConstant.CHRISTMAS_D_DAY_EVENT_BASE_DISCOUNT;
import static christmas.util.constant.ChristmasEventConstant.CHRISTMAS_D_DAY_EVENT_DAILY_DISCOUNT;
import static christmas.util.constant.ChristmasEventConstant.CHRISTMAS_EVENT_END_DATE;
import static christmas.util.constant.ChristmasEventConstant.CHRISTMAS_EVENT_MONTH;
import static christmas.util.constant.ChristmasEventConstant.CHRISTMAS_EVENT_START_DATE;
import static christmas.util.constant.ChristmasEventConstant.CHRISTMAS_EVENT_YEAR;
import static christmas.util.constant.ChristmasEventConstant.GIFT_EVENT_MENU_ITEM;
import static christmas.util.constant.ChristmasEventConstant.GIFT_EVENT_STANDARD_AMOUNT;
import static christmas.util.constant.ChristmasEventConstant.SPECIAL_EVENT_DAYS;
import static christmas.util.constant.ChristmasEventConstant.SPECIAL_EVENT_DISCOUNT;
import static christmas.util.constant.ChristmasEventConstant.WEEK_EVENT_DISCOUNT;

import christmas.model.date.EventPeriod;
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

    public Badge getEventBadge(Benefits benefits) {
        return Badge.getEventBadge(benefits.getTotalBenefit());
    }

    private EventPeriod getDdayPromotionPeriod() {
        return new EventPeriod(
                LocalDate.of(CHRISTMAS_EVENT_YEAR, CHRISTMAS_EVENT_MONTH, CHRISTMAS_EVENT_START_DATE),
                LocalDate.of(CHRISTMAS_EVENT_YEAR, CHRISTMAS_EVENT_MONTH, CHRISTMAS_D_DAY_DATE)
        );
    }

    private EventPeriod getPromotionPeriod() {
        return new EventPeriod(
                LocalDate.of(CHRISTMAS_EVENT_YEAR, CHRISTMAS_EVENT_MONTH, CHRISTMAS_EVENT_START_DATE),
                LocalDate.of(CHRISTMAS_EVENT_YEAR, CHRISTMAS_EVENT_MONTH, CHRISTMAS_EVENT_END_DATE)
        );
    }

    private List<LocalDate> getSpecialPromotionDays() {
        return SPECIAL_EVENT_DAYS.stream()
                .map(day -> LocalDate.of(CHRISTMAS_EVENT_YEAR, CHRISTMAS_EVENT_MONTH, day))
                .toList();
    }
}
