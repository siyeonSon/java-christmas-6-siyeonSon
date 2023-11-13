package christmas.view;

import static christmas.model.constant.ChristmasPromotionConstant.CHRISTMAS_PROMOTION_MONTH;
import static christmas.util.message.ErrorMessages.PREFIX;
import static christmas.util.message.ViewMessages.INPUT_DATE;
import static christmas.util.message.ViewMessages.INPUT_ORDER;
import static christmas.util.message.ViewMessages.OUTPUT_EVENT_GUIDE;
import static christmas.util.message.ViewMessages.OUTPUT_MENU;
import static christmas.util.message.ViewMessages.OUTPUT_ORDER_GUIDE;
import static christmas.util.message.ViewMessages.WELCOME;

import christmas.model.menu.MenuItem;
import christmas.model.user.Order;
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

    public void printOrder(Order order) {
        order.getMenuItems().forEach(this::printMenu);
    }

    private void printMenu(MenuItem menuItem, Integer count) {
        println(String.format(OUTPUT_MENU, menuItem.getName(), count));
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
