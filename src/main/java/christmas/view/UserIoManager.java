package christmas.view;

import static christmas.model.constant.ChristmasPromotionConstant.CHRISTMAS_PROMOTION_MONTH;
import static christmas.model.constant.ChristmasPromotionConstant.CHRISTMAS_PROMOTION_YEAR;

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

    public UserDate readDateUntilSuccess() {
        return Repeater.reTryUntilSuccess(this::readDate);
    }

    public Order readOrderUntilSuccess() {
        return Repeater.reTryUntilSuccess(this::readOrder);
    }

    private UserDate readDate() {
        outputView.printDateInputGuide();
        int date = inputView.readDate();
        return new UserDate(CHRISTMAS_PROMOTION_YEAR, CHRISTMAS_PROMOTION_MONTH, date);
    }

    private Order readOrder() {
        outputView.printOrderInputGuide();
        String order = inputView.readOrder();
        return new Order(order);
    }
}
