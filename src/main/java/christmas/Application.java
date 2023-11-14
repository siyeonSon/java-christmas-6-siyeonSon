package christmas;

import camp.nextstep.edu.missionutils.Console;
import christmas.controller.PromotionController;
import christmas.model.event.EventManager;
import christmas.view.InputView;
import christmas.view.OutputView;
import christmas.view.UserIoManager;

public class Application {
    public static void main(String[] args) {
        UserIoManager userIoManager = new UserIoManager(new InputView(), new OutputView());
        PromotionController promotionController = new PromotionController(userIoManager, new EventManager());
        promotionController.run();

        Console.close();
    }
}
