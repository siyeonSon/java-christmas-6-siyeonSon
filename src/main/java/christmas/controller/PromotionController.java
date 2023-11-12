package christmas.controller;

import christmas.model.user.UserDate;
import christmas.view.UserIoManager;

public class PromotionController {
    private final UserIoManager userIoManager;

    public PromotionController(UserIoManager userIoManager) {
        this.userIoManager = userIoManager;
    }

    public void run() {
        userIoManager.printWelcome();
        UserDate userDate = userIoManager.readDateUntilSuccess();
    }
}
