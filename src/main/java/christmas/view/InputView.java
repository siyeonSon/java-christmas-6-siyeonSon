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

    private void validateNumeric(String value) {
        BlankValidator.validate(value);
        DigitsOnlyValidator.validate(value);
    }
}
