package christmas.view;

import static christmas.model.constant.ChristmasPromotionConstant.CHRISTMAS_PROMOTION_MONTH;
import static christmas.util.message.ErrorMessages.PREFIX;
import static christmas.util.message.ViewMessages.INPUT_DATE;
import static christmas.util.message.ViewMessages.INPUT_ORDER;
import static christmas.util.message.ViewMessages.OUTPUT_EVENT_GUIDE;
import static christmas.util.message.ViewMessages.WELCOME;

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
        println(formatEventGuide(userDate));
    }

    private String formatEventGuide(UserDate userDate) {
        return String.format(OUTPUT_EVENT_GUIDE, userDate.getMonthValue(), userDate.getDayOfMonth());
    }

    private void println(String message) {
        System.out.println(message);
    }
}
