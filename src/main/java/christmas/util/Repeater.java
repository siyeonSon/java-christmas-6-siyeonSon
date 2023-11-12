package christmas.util;

import christmas.view.OutputView;
import java.util.function.Supplier;

public final class Repeater {
    private Repeater() {
    }

    public static <T> T reTryUntilSuccess(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return reTryUntilSuccess(supplier);
        }
    }
}
