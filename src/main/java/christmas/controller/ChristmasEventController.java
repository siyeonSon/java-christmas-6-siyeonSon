package christmas.controller;

import static christmas.util.constant.ChristmasEventConstant.CHRISTMAS_EVENT_MONTH;
import static christmas.util.constant.ChristmasEventConstant.CHRISTMAS_EVENT_YEAR;
import static christmas.util.constant.ChristmasEventConstant.GIFT_EVENT_MENU_ITEM;
import static christmas.util.constant.ChristmasEventConstant.GIFT_EVENT_MENU_ITEM_AMOUNT;

import christmas.model.event.Badge;
import christmas.model.event.Benefits;
import christmas.model.event.EventManager;
import christmas.model.user.UserDate;
import christmas.model.user.UserOrder;
import christmas.view.UserIoManager;

public class ChristmasEventController {
    private final UserIoManager userIoManager;
    private final EventManager eventManager;

    public ChristmasEventController(UserIoManager userIoManager, EventManager eventManager) {
        this.userIoManager = userIoManager;
        this.eventManager = eventManager;
    }

    public void run() {
        userIoManager.printWelcome();
        UserDate userDate = userIoManager.readDateUntilSuccess(CHRISTMAS_EVENT_YEAR, CHRISTMAS_EVENT_MONTH);
        UserOrder userOrder = userIoManager.readOrderUntilSuccess();
        userIoManager.printOrder(userOrder);
        long totalPrice = userOrder.getTotalPrice();
        userIoManager.printTotalPrice(totalPrice);
        userIoManager.printEventGuide(userDate);
        Benefits benefits = event(userDate, userOrder);
        printResult(benefits, totalPrice);
    }

    private Benefits event(UserDate userDate, UserOrder userOrder) {
        long ddayBenefit = eventManager.applyDdayEvent(userDate, userOrder);
        long weekdayBenefit = eventManager.applyWeekdayEvent(userDate, userOrder);
        long weekendBenefit = eventManager.applyWeekendEvent(userDate, userOrder);
        long specialBenefit = eventManager.applySpecialEvent(userDate, userOrder);
        long giftBenefit = eventManager.applyGiftEvent(userDate, userOrder);
        return new Benefits(ddayBenefit, weekdayBenefit, weekendBenefit, specialBenefit, giftBenefit);
    }

    private void printResult(Benefits benefits, long totalPrice) {
        userIoManager.printGiftMenuItem(benefits, GIFT_EVENT_MENU_ITEM, GIFT_EVENT_MENU_ITEM_AMOUNT);
        userIoManager.printEventAmount(benefits);
        userIoManager.printTotalBenefit(benefits);
        userIoManager.printFinalPrice(benefits.getFinalPrice(totalPrice));
        Badge badge = eventManager.getEventBadge(benefits);
        userIoManager.printBadge(badge);
    }
}
