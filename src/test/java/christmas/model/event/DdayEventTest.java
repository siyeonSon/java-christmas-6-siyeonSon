package christmas.model.event;

import static christmas.model.constant.ChristmasEventConstant.CHRISTMAS_D_DAY_DATE;
import static christmas.model.constant.ChristmasEventConstant.CHRISTMAS_D_DAY_EVENT_BASE_DISCOUNT;
import static christmas.model.constant.ChristmasEventConstant.CHRISTMAS_D_DAY_EVENT_DAILY_DISCOUNT;
import static christmas.model.constant.ChristmasEventConstant.CHRISTMAS_PROMOTION_MONTH;
import static christmas.model.constant.ChristmasEventConstant.CHRISTMAS_PROMOTION_START_DATE;
import static christmas.model.constant.ChristmasEventConstant.CHRISTMAS_PROMOTION_YEAR;
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

class DdayEventTest {
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
                LocalDate.of(CHRISTMAS_PROMOTION_YEAR, CHRISTMAS_PROMOTION_MONTH, CHRISTMAS_PROMOTION_START_DATE),
                LocalDate.of(CHRISTMAS_PROMOTION_YEAR, CHRISTMAS_PROMOTION_MONTH, CHRISTMAS_D_DAY_DATE)
        );
    }

    @Test
    void 크리스마스_디데이_할인을_적용한다() {
        Event ddayEvent = new DdayEvent(userDate, userOrder, eventPeriod,
                CHRISTMAS_D_DAY_EVENT_BASE_DISCOUNT, CHRISTMAS_D_DAY_EVENT_DAILY_DISCOUNT);
        Assertions.assertThat(ddayEvent.benefit()).isNotZero();
    }

    @Test
    void 방문_날짜가_프로모션_기간이_아니다() {
        userDate = new UserDate(2023, 11, 3);
        Event ddayEvent = new DdayEvent(userDate, userOrder, eventPeriod,
                CHRISTMAS_D_DAY_EVENT_BASE_DISCOUNT, CHRISTMAS_D_DAY_EVENT_DAILY_DISCOUNT);
        Assertions.assertThat(ddayEvent.benefit()).isZero();
    }

    @Test
    void 총주문_금액_10000원_미만일_경우_이벤트가_적용되지_않는다() {
        Map<MenuItem, Integer> menuItems = new HashMap<>();
        menuItems.put(ICE_CREAM, 1);
        userOrder = new UserOrder(menuItems);
        Event ddayEvent = new DdayEvent(userDate, userOrder, eventPeriod,
                CHRISTMAS_D_DAY_EVENT_BASE_DISCOUNT, CHRISTMAS_D_DAY_EVENT_DAILY_DISCOUNT);
        Assertions.assertThat(ddayEvent.benefit()).isZero();
    }
}