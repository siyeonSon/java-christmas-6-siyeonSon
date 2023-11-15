package christmas.util.validator;

import static christmas.util.constant.ErrorMessages.DATE_INVALID_EXCEPTION;

import java.util.regex.Pattern;

public final class DigitsOnlyValidator {
    private static final Pattern DIGITS_PATTERN = Pattern.compile("[0-9]+");

    private DigitsOnlyValidator() {
    }

    public static void validate(String value) {
        if (!matchesPattern(value)) {
            throw new IllegalArgumentException(DATE_INVALID_EXCEPTION);
        }
    }

    private static boolean matchesPattern(String value) {
        return DIGITS_PATTERN.matcher(value).matches();
    }
}
