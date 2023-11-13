package christmas.controller;

import static christmas.model.constant.ChristmasPromotionConstant.CHRISTMAS_PROMOTION_MONTH;
import static christmas.model.constant.ChristmasPromotionConstant.CHRISTMAS_PROMOTION_YEAR;

import christmas.model.user.UserDate;
import christmas.model.user.Order;
import christmas.view.UserIoManager;

public class PromotionController {
    private final UserIoManager userIoManager;

    public PromotionController(UserIoManager userIoManager) {
        this.userIoManager = userIoManager;
    }

    public void run() {
        userIoManager.printWelcome();
        UserDate userDate = userIoManager.readDateUntilSuccess(CHRISTMAS_PROMOTION_YEAR, CHRISTMAS_PROMOTION_MONTH);
        Order order = userIoManager.readOrderUntilSuccess();
    }
}
