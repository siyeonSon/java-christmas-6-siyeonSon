package christmas.controller;

import static christmas.model.constant.ChristmasPromotionConstant.CHRISTMAS_PROMOTION_MONTH;
import static christmas.model.constant.ChristmasPromotionConstant.CHRISTMAS_PROMOTION_YEAR;
import static christmas.model.constant.ChristmasPromotionConstant.GIFT_EVENT_MENU_ITEM;
import static christmas.model.constant.ChristmasPromotionConstant.GIFT_EVENT_MENU_ITEM_AMOUNT;

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
        userIoManager.printTotalPrice(totalPrice);

        long ddayBenefit = eventManager.applyDdayEvent(userDate, userOrder);
        long weekdayBenefit = eventManager.applyWeekdayEvent(userDate, userOrder);
        long weekendBenefit = eventManager.applyWeekendEvent(userDate, userOrder);
        long specialBenefit = eventManager.applySpecialEvent(userDate, userOrder);
        long giftBenefit = eventManager.applyGiftEvent(userDate, userOrder);

        long totalBenefit = calculateTotalBenefit(ddayBenefit, weekdayBenefit, weekendBenefit, specialBenefit, giftBenefit);

        userIoManager.printGiftMenuItem(giftBenefit, GIFT_EVENT_MENU_ITEM, GIFT_EVENT_MENU_ITEM_AMOUNT);
        printEventAmount(totalBenefit, ddayBenefit, weekdayBenefit, weekendBenefit, specialBenefit, giftBenefit);

        userIoManager.printTotalBenefit(totalBenefit);

        long finalPrice = totalPrice - totalBenefit + giftBenefit;
        userIoManager.printFinalPrice(finalPrice);

        Badge badge = eventManager.getEventBadge(totalPrice);
        userIoManager.printBadge(badge);
    }

    private void printEventAmount(long totalBenefit, long ddayBenefit, long weekdayBenefit, long weekendBenefit, long specialBenefit, long giftBenefit) {
        if (totalBenefit == 0) {
            userIoManager.printNone();
            return;
        }
        userIoManager.printEventAmount(ddayBenefit, weekdayBenefit, weekendBenefit, specialBenefit, giftBenefit);
    }

    private long calculateTotalBenefit(long ddayBenefit, long weekdayBenefit, long weekendBenefit, long specialBenefit, long giftBenefit) {
        return ddayBenefit + weekdayBenefit + weekendBenefit + specialBenefit + giftBenefit;
    }
}
