package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.util.converter.NumericConverter;
import christmas.util.validator.BlankValidator;
import christmas.util.validator.DigitsOnlyValidator;

public class InputView {
    public int readDate() {
        String input = Console.readLine();
        validateNumeric(input);
        return NumericConverter.convert(input);
    }

    public String readOrder() {
        String input = Console.readLine();
        BlankValidator.validate(input);
        return input;
    }

    private void validateNumeric(String value) {
        BlankValidator.validate(value);
        DigitsOnlyValidator.validate(value);
    }
}
