package christmas.view;

import static christmas.model.constant.ChristmasPromotionConstant.CHRISTMAS_PROMOTION_MONTH;
import static christmas.util.message.ErrorMessages.PREFIX;
import static christmas.util.message.ViewMessages.INPUT_DATE;
import static christmas.util.message.ViewMessages.INPUT_ORDER;
import static christmas.util.message.ViewMessages.OUTPUT_CHRISTMAS_D_DAY_EVENT;
import static christmas.util.message.ViewMessages.OUTPUT_EVENT_AMOUNT_GUIDE;
import static christmas.util.message.ViewMessages.OUTPUT_BADGE_GUIDE;
import static christmas.util.message.ViewMessages.OUTPUT_EVENT_GUIDE;
import static christmas.util.message.ViewMessages.OUTPUT_FINAL_PRICE_GUIDE;
import static christmas.util.message.ViewMessages.OUTPUT_GIFT_EVENT;
import static christmas.util.message.ViewMessages.OUTPUT_GIFT_MENU_ITEM;
import static christmas.util.message.ViewMessages.OUTPUT_GIFT_MENU_ITEM_GUIDE;
import static christmas.util.message.ViewMessages.OUTPUT_MENU;
import static christmas.util.message.ViewMessages.OUTPUT_NONE;
import static christmas.util.message.ViewMessages.OUTPUT_ORDER_GUIDE;
import static christmas.util.message.ViewMessages.OUTPUT_PRICE;
import static christmas.util.message.ViewMessages.OUTPUT_SPECIAL_EVENT;
import static christmas.util.message.ViewMessages.OUTPUT_TOTAL_BENEFIT;
import static christmas.util.message.ViewMessages.OUTPUT_TOTAL_BENEFIT_GUIDE;
import static christmas.util.message.ViewMessages.OUTPUT_TOTAL_PRICE_GUIDE;
import static christmas.util.message.ViewMessages.OUTPUT_WEEKDAY_EVENT;
import static christmas.util.message.ViewMessages.OUTPUT_WEEKEND_EVENT;
import static christmas.util.message.ViewMessages.WELCOME;

import christmas.model.event.Badge;
import christmas.model.menu.MenuItem;
import christmas.model.user.UserOrder;
import christmas.model.user.UserDate;

public class OutputView {
    public static void printErrorMessage(String message) {
        System.out.println(PREFIX + message);
    }

    public void printWelcome() {
        println(WELCOME);
    }

    public void printDateInputGuide() {
        println(String.format(INPUT_DATE, CHRISTMAS_PROMOTION_MONTH));
    }

    public void printOrderInputGuide() {
        println(INPUT_ORDER);
    }

    public void printEventGuide(UserDate userDate) {
        println(String.format(OUTPUT_EVENT_GUIDE, userDate.getMonthValue(), userDate.getDayOfMonth()));
    }

    public void printOrderGuide() {
        printEmptyLine();
        println(OUTPUT_ORDER_GUIDE);
    }

    public void printOrder(UserOrder userOrder) {
        userOrder.getMenuItems().forEach(this::printMenu);
    }

    private void printMenu(MenuItem menuItem, Integer count) {
        println(String.format(OUTPUT_MENU, menuItem.getName(), count));
    }

    public void printTotalPriceGuide() {
        printEmptyLine();
        println(OUTPUT_TOTAL_PRICE_GUIDE);
    }

    public void printPrice(long price) {
        println(String.format(OUTPUT_PRICE, price));
    }

    public void printGiftMenuItemGuide() {
        printEmptyLine();
        println(OUTPUT_GIFT_MENU_ITEM_GUIDE);
    }

    public void printGiftMenuItem(long benefit, MenuItem menuItem, int count) {
        if (isNotZero(benefit)) {
            println(String.format(OUTPUT_GIFT_MENU_ITEM, menuItem.getName(), count));
        }
        printNone();
    }

    public void printEventAmountGuide() {
        printEmptyLine();
        println(OUTPUT_EVENT_AMOUNT_GUIDE);
    }

    public void printChristmasDdayEvent(long benefit) {
        if (isNotZero(benefit)) {
            println(String.format(OUTPUT_CHRISTMAS_D_DAY_EVENT, benefit));
        }
    }

    public void printWeekendEvent(long benefit) {
        if (isNotZero(benefit)) {
            println(String.format(OUTPUT_WEEKEND_EVENT, benefit));
        }
    }

    public void printWeekdayEvent(long benefit) {
        if (isNotZero(benefit)) {
            println(String.format(OUTPUT_WEEKDAY_EVENT, benefit));
        }
    }

    public void printSpecialEvent(long benefit) {
        if (isNotZero(benefit)) {
            println(String.format(OUTPUT_SPECIAL_EVENT, benefit));
        }
    }

    public void printGiftEvent(long benefit) {
        if (isNotZero(benefit)) {
            println(String.format(OUTPUT_GIFT_EVENT, benefit));
        }
    }

    public void printNone() {
        println(OUTPUT_NONE);
    }

    public void printTotalBenefitGuide() {
        printEmptyLine();
        println(OUTPUT_TOTAL_BENEFIT_GUIDE);
    }

    public void printBenefit(long totalBenefit) {
        println(String.format(OUTPUT_TOTAL_BENEFIT, totalBenefit));
    }

    public void printFinalPriceGuide() {
        printEmptyLine();
        println(OUTPUT_FINAL_PRICE_GUIDE);
    }

    public void printBadgeGuide() {
        printEmptyLine();
        println(OUTPUT_BADGE_GUIDE);
    }

    public void printBadge(Badge badge) {
        println(badge.getName());
    }

    private boolean isNotZero(long benefit) {
        return benefit != 0;
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
