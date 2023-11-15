package christmas.controller;

import static christmas.model.constant.ChristmasEventConstant.CHRISTMAS_PROMOTION_MONTH;
import static christmas.model.constant.ChristmasEventConstant.CHRISTMAS_PROMOTION_YEAR;
import static christmas.model.constant.ChristmasEventConstant.GIFT_EVENT_MENU_ITEM;
import static christmas.model.constant.ChristmasEventConstant.GIFT_EVENT_MENU_ITEM_AMOUNT;

import christmas.model.event.Badge;
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
        UserDate userDate = userIoManager.readDateUntilSuccess(CHRISTMAS_PROMOTION_YEAR, CHRISTMAS_PROMOTION_MONTH);
        UserOrder userOrder = userIoManager.readOrderUntilSuccess();
        userIoManager.printOrder(userOrder);
        long totalPrice = userOrder.getTotalPrice();
        userIoManager.printTotalPrice(totalPrice);
        userIoManager.printEventGuide(userDate);
        event(userDate, userOrder, totalPrice);
    }

    private void event(UserDate userDate, UserOrder userOrder, long totalPrice) {
        long ddayBenefit = eventManager.applyDdayEvent(userDate, userOrder);
        long weekdayBenefit = eventManager.applyWeekdayEvent(userDate, userOrder);
        long weekendBenefit = eventManager.applyWeekendEvent(userDate, userOrder);
        long specialBenefit = eventManager.applySpecialEvent(userDate, userOrder);
        long giftBenefit = eventManager.applyGiftEvent(userDate, userOrder);
        long totalBenefit = calculateTotalBenefit(ddayBenefit, weekdayBenefit, weekendBenefit, specialBenefit, giftBenefit);
        Badge badge = eventManager.getEventBadge(userOrder, totalBenefit);
        long finalPrice = totalPrice - totalBenefit + giftBenefit;

        userIoManager.printGiftMenuItem(giftBenefit, GIFT_EVENT_MENU_ITEM, GIFT_EVENT_MENU_ITEM_AMOUNT);
        userIoManager.printEventAmount(totalBenefit, ddayBenefit, weekdayBenefit, weekendBenefit, specialBenefit, giftBenefit);
        userIoManager.printTotalBenefit(totalBenefit);
        userIoManager.printFinalPrice(finalPrice);
        userIoManager.printBadge(giftBenefit, badge);
    }

    private long calculateTotalBenefit(long ddayBenefit, long weekdayBenefit, long weekendBenefit, long specialBenefit, long giftBenefit) {
        return ddayBenefit + weekdayBenefit + weekendBenefit + specialBenefit + giftBenefit;
    }
}
