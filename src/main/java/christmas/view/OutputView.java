package christmas.view;

import static christmas.util.constant.ChristmasEventConstant.CHRISTMAS_EVENT_MONTH;
import static christmas.util.constant.ErrorMessages.PREFIX;
import static christmas.util.constant.ViewMessages.INPUT_DATE;
import static christmas.util.constant.ViewMessages.INPUT_ORDER;
import static christmas.util.constant.ViewMessages.OUTPUT_CHRISTMAS_D_DAY_EVENT;
import static christmas.util.constant.ViewMessages.OUTPUT_EVENT_AMOUNT_GUIDE;
import static christmas.util.constant.ViewMessages.OUTPUT_BADGE_GUIDE;
import static christmas.util.constant.ViewMessages.OUTPUT_EVENT_GUIDE;
import static christmas.util.constant.ViewMessages.OUTPUT_FINAL_PRICE_GUIDE;
import static christmas.util.constant.ViewMessages.OUTPUT_GIFT_EVENT;
import static christmas.util.constant.ViewMessages.OUTPUT_GIFT_MENU_ITEM;
import static christmas.util.constant.ViewMessages.OUTPUT_GIFT_MENU_ITEM_GUIDE;
import static christmas.util.constant.ViewMessages.OUTPUT_MENU;
import static christmas.util.constant.ViewMessages.OUTPUT_NONE;
import static christmas.util.constant.ViewMessages.OUTPUT_ORDER_GUIDE;
import static christmas.util.constant.ViewMessages.OUTPUT_PRICE;
import static christmas.util.constant.ViewMessages.OUTPUT_SPECIAL_EVENT;
import static christmas.util.constant.ViewMessages.OUTPUT_TOTAL_BENEFIT;
import static christmas.util.constant.ViewMessages.OUTPUT_TOTAL_BENEFIT_GUIDE;
import static christmas.util.constant.ViewMessages.OUTPUT_TOTAL_PRICE_GUIDE;
import static christmas.util.constant.ViewMessages.OUTPUT_WEEKDAY_EVENT;
import static christmas.util.constant.ViewMessages.OUTPUT_WEEKEND_EVENT;
import static christmas.util.constant.ViewMessages.WELCOME;

import christmas.model.event.Badge;
import christmas.model.event.Benefits;
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
        println(String.format(INPUT_DATE, CHRISTMAS_EVENT_MONTH));
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
        println(formatGiftMenuItem(benefit, menuItem, count));
    }

    private String formatGiftMenuItem(long benefit, MenuItem menuItem, int count) {
        if (isNotZero(benefit)) {
            return String.format(OUTPUT_GIFT_MENU_ITEM, menuItem.getName(), count);
        }
        return OUTPUT_NONE;
    }

    public void printEventAmountGuide() {
        printEmptyLine();
        println(OUTPUT_EVENT_AMOUNT_GUIDE);
    }

    public void printEventAmount(Benefits benefits) {
        println(formatEventAmount(benefits));
    }

    private String formatEventAmount(Benefits benefits) {
        if (isNotZero(benefits.getTotalBenefit())) {
            StringBuilder output = new StringBuilder();
            appendIfNotNull(output, formatChristmasDdayEvent(benefits.getDdayBenefit()));
            appendIfNotNull(output, formatWeekendEvent(benefits.getWeekendBenefit()));
            appendIfNotNull(output, formatWeekdayEvent(benefits.getWeekdayBenefit()));
            appendIfNotNull(output, formatSpecialEvent(benefits.getSpecialBenefit()));
            appendIfNotNull(output, formatGiftEvent(benefits.getGiftBenefit()));
            return output.toString();
        }
        return OUTPUT_NONE + "\n";
    }

    private void appendIfNotNull(StringBuilder builder, String formattedEvent) {
        if (formattedEvent != null) {
            builder.append(formattedEvent).append("\n");
        }
    }

    private String formatChristmasDdayEvent(long benefit) {
        if (isNotZero(benefit)) {
            return String.format(OUTPUT_CHRISTMAS_D_DAY_EVENT, -benefit);
        }
        return null;
    }

    private String formatWeekendEvent(long benefit) {
        if (isNotZero(benefit)) {
            return String.format(OUTPUT_WEEKEND_EVENT, -benefit);
        }
        return null;
    }

    private String formatWeekdayEvent(long benefit) {
        if (isNotZero(benefit)) {
            return String.format(OUTPUT_WEEKDAY_EVENT, -benefit);
        }
        return null;
    }

    private String formatSpecialEvent(long benefit) {
        if (isNotZero(benefit)) {
            return String.format(OUTPUT_SPECIAL_EVENT, -benefit);
        }
        return null;
    }

    private String formatGiftEvent(long benefit) {
        if (isNotZero(benefit)) {
            return String.format(OUTPUT_GIFT_EVENT, -benefit);
        }
        return null;
    }

    public void printTotalBenefitGuide() {
        println(OUTPUT_TOTAL_BENEFIT_GUIDE);
    }

    public void printBenefit(long totalBenefit) {
        println(String.format(OUTPUT_TOTAL_BENEFIT, -totalBenefit));
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
