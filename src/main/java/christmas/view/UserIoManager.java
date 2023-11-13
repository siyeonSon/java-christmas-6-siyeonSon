package christmas.view;

import christmas.model.user.UserDate;
import christmas.model.user.Order;
import christmas.util.Repeater;

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

    public Order readOrderUntilSuccess() {
        return Repeater.reTryUntilSuccess(this::readOrder);
    }

    public void printEventGuide(UserDate userDate) {
        outputView.printEventGuide(userDate);
    }

    private UserDate readDate(int year, int month) {
        outputView.printDateInputGuide();
        int date = inputView.readDate();
        return new UserDate(year, month, date);
    }

    private Order readOrder() {
        outputView.printOrderInputGuide();
        String order = inputView.readOrder();
        return new Order(order);
    }
}
