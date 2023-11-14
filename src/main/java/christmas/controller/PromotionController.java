package christmas.controller;

import static christmas.model.constant.ChristmasPromotionConstant.CHRISTMAS_PROMOTION_MONTH;
import static christmas.model.constant.ChristmasPromotionConstant.CHRISTMAS_PROMOTION_YEAR;

import christmas.model.event.Badge;
import christmas.model.event.EventManager;
import christmas.model.user.UserDate;
import christmas.model.user.UserOrder;
import christmas.view.UserIoManager;

public class PromotionController {
    private final UserIoManager userIoManager;
    private final EventManager eventManager;

    public PromotionController(UserIoManager userIoManager, EventManager eventManager) {
        this.userIoManager = userIoManager;
        this.eventManager = eventManager;
    }

    public void run() {
        userIoManager.printWelcome();
        UserDate userDate = userIoManager.readDateUntilSuccess(CHRISTMAS_PROMOTION_YEAR, CHRISTMAS_PROMOTION_MONTH);
        UserOrder userOrder = userIoManager.readOrderUntilSuccess();
        userIoManager.printEventGuide(userDate);
        userIoManager.printOrder(userOrder);
        long totalPrice = userOrder.getTotalPrice();

        long ddayEventDiscount = eventManager.applyDdayEvent(userDate, userOrder);
        long weekdayEventDiscount = eventManager.applyWeekdayEvent(userDate, userOrder);
        long weekendEventDiscount = eventManager.applyWeekendEvent(userDate, userOrder);
        long specialEventDiscount = eventManager.applySpecialEvent(userDate, userOrder);
        long giftEventDiscount = eventManager.applyGiftEvent(userDate, userOrder);
        String eventBadge = eventManager.getEventBadge(totalPrice);

        userIoManager.printTotalPrice(totalPrice);
    }
}
