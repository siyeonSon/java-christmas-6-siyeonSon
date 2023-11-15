package christmas.view;

import christmas.model.event.Badge;
import christmas.model.event.Benefits;
import christmas.model.menu.MenuItem;
import christmas.model.menu.Waiter;
import christmas.model.user.UserDate;
import christmas.model.user.UserOrder;
import christmas.util.repeater.Repeater;

public class UserIoManager {
    private final InputView inputView;
    private final OutputView outputView;

    public UserIoManager(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void printWelcome() {
        outputView.printWelcome();
    }

    public UserDate readDateUntilSuccess(int year, int month) {
        return Repeater.reTryUntilSuccess(() -> readDate(year, month));
    }

    public UserOrder readOrderUntilSuccess() {
        return Repeater.reTryUntilSuccess(this::readOrder);
    }

    public void printEventGuide(UserDate userDate) {
        outputView.printEventGuide(userDate);
    }

    public void printGiftMenuItem(Benefits benefits, MenuItem menuItem, int count) {
        outputView.printGiftMenuItemGuide();
        outputView.printGiftMenuItem(benefits.getGiftBenefit(), menuItem, count);
    }

    public void printOrder(UserOrder userOrder) {
        outputView.printOrderGuide();
        outputView.printOrder(userOrder);
    }

    public void printTotalPrice(long totalPrice) {
        outputView.printTotalPriceGuide();
        outputView.printPrice(totalPrice);
    }

    public void printEventAmount(Benefits benefits) {
        outputView.printEventAmountGuide();
        outputView.printEventAmount(benefits);
    }

    public void printTotalBenefit(Benefits benefits) {
        outputView.printTotalBenefitGuide();
        outputView.printBenefit(benefits.getTotalBenefit());
    }

    public void printFinalPrice(long finalPrice) {
        outputView.printFinalPriceGuide();
        outputView.printPrice(finalPrice);
    }

    public void printBadge(Badge badge) {
        outputView.printBadgeGuide();
        outputView.printBadge(badge);
    }

    private UserDate readDate(int year, int month) {
        outputView.printDateInputGuide();
        int date = inputView.readDate();
        return new UserDate(year, month, date);
    }

    private UserOrder readOrder() {
        outputView.printOrderInputGuide();
        String order = inputView.readOrder();
        return Waiter.generateOrder(order);
    }
}
