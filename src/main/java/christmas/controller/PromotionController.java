package christmas.controller;

import static christmas.model.constant.ChristmasPromotionConstant.CHRISTMAS_D_DAY_DATE;
import static christmas.model.constant.ChristmasPromotionConstant.CHRISTMAS_D_DAY_EVENT_BASE_DISCOUNT;
import static christmas.model.constant.ChristmasPromotionConstant.CHRISTMAS_D_DAY_EVENT_DAILY_DISCOUNT;
import static christmas.model.constant.ChristmasPromotionConstant.CHRISTMAS_PROMOTION_MONTH;
import static christmas.model.constant.ChristmasPromotionConstant.CHRISTMAS_PROMOTION_START_DATE;
import static christmas.model.constant.ChristmasPromotionConstant.CHRISTMAS_PROMOTION_YEAR;

import christmas.model.date.PromotionPeriod;
import christmas.model.event.DdayEvent;
import christmas.model.user.User;
import christmas.model.user.UserDate;
import christmas.model.user.UserOrder;
import christmas.view.UserIoManager;
import java.time.LocalDate;

public class PromotionController {
    private final UserIoManager userIoManager;

    public PromotionController(UserIoManager userIoManager) {
        this.userIoManager = userIoManager;
    }

    public void run() {
        userIoManager.printWelcome();
        UserDate userDate = userIoManager.readDateUntilSuccess(CHRISTMAS_PROMOTION_YEAR, CHRISTMAS_PROMOTION_MONTH);
        UserOrder userOrder = userIoManager.readOrderUntilSuccess();
        userIoManager.printEventGuide(userDate);
        userIoManager.printOrder(userOrder);
        long totalPrice = userOrder.getTotalPrice();

        User user = new User(userDate, userOrder);
        PromotionPeriod ddayPromotionPeriod = new PromotionPeriod(
                LocalDate.of(CHRISTMAS_PROMOTION_YEAR, CHRISTMAS_PROMOTION_MONTH, CHRISTMAS_PROMOTION_START_DATE),
                LocalDate.of(CHRISTMAS_PROMOTION_YEAR, CHRISTMAS_PROMOTION_MONTH, CHRISTMAS_D_DAY_DATE)
        );
        user = new DdayEvent(user, ddayPromotionPeriod, CHRISTMAS_D_DAY_EVENT_BASE_DISCOUNT, CHRISTMAS_D_DAY_EVENT_DAILY_DISCOUNT);

        userIoManager.printTotalPrice(totalPrice);
    }
}
