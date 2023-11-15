package christmas.model.event;

import static christmas.util.constant.ChristmasEventConstant.CHRISTMAS_EVENT_END_DATE;
import static christmas.util.constant.ChristmasEventConstant.CHRISTMAS_EVENT_MONTH;
import static christmas.util.constant.ChristmasEventConstant.CHRISTMAS_EVENT_START_DATE;
import static christmas.util.constant.ChristmasEventConstant.CHRISTMAS_EVENT_YEAR;
import static christmas.util.constant.ChristmasEventConstant.GIFT_EVENT_STANDARD_AMOUNT;
import static christmas.util.constant.ChristmasEventConstant.WEEK_EVENT_DISCOUNT;
import static christmas.model.menu.MenuItem.BARBECUE_LIBS;
import static christmas.model.menu.MenuItem.CHOCOLATE_CAKE;
import static christmas.model.menu.MenuItem.ICE_CREAM;
import static christmas.model.menu.MenuItem.T_BONE_STAKE;
import static christmas.model.menu.MenuItem.ZERO_COKE;

import christmas.model.date.EventPeriod;
import christmas.model.menu.MenuItem;
import christmas.model.user.UserDate;
import christmas.model.user.UserOrder;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GiftEventTest {
    UserDate userDate;
    UserOrder userOrder;
    EventPeriod eventPeriod;

    @BeforeEach
    void setUp() {
        userDate = new UserDate(2023, 12, 3);
        Map<MenuItem, Integer> menuItems = new HashMap<>();
        menuItems.put(T_BONE_STAKE, 1);
        menuItems.put(BARBECUE_LIBS, 1);
        menuItems.put(CHOCOLATE_CAKE, 2);
        menuItems.put(ZERO_COKE, 1);
        userOrder = new UserOrder(menuItems);
        eventPeriod = new EventPeriod(
                LocalDate.of(CHRISTMAS_EVENT_YEAR, CHRISTMAS_EVENT_MONTH, CHRISTMAS_EVENT_START_DATE),
                LocalDate.of(CHRISTMAS_EVENT_YEAR, CHRISTMAS_EVENT_MONTH, CHRISTMAS_EVENT_END_DATE)
        );
    }

    @Test
    void 증정_이벤트를_적용한다() {
        Event giftEvent = new GiftEvent(userDate, userOrder, eventPeriod, GIFT_EVENT_STANDARD_AMOUNT, WEEK_EVENT_DISCOUNT);
        Assertions.assertThat(giftEvent.benefit()).isNotZero();
    }

    @Test
    void 방문_날짜가_프로모션_기간이_아니다() {
        userDate = new UserDate(2023, 11, 2);
        Event giftEvent = new GiftEvent(userDate, userOrder, eventPeriod, GIFT_EVENT_STANDARD_AMOUNT, WEEK_EVENT_DISCOUNT);
        Assertions.assertThat(giftEvent.benefit()).isZero();
    }

    @Test
    void 총주문_금액_10000원_미만일_경우_이벤트가_적용되지_않는다() {
        Map<MenuItem, Integer> menuItems = new HashMap<>();
        menuItems.put(ICE_CREAM, 1);
        userOrder = new UserOrder(menuItems);
        Event giftEvent = new GiftEvent(userDate, userOrder, eventPeriod, GIFT_EVENT_STANDARD_AMOUNT, WEEK_EVENT_DISCOUNT);
        Assertions.assertThat(giftEvent.benefit()).isZero();
    }
}