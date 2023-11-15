package christmas.util.validator;

import static christmas.util.message.ErrorMessages.DATE_INVALID_EXCEPTION;

public final class BlankValidator {
    private BlankValidator() {
    }

    public static void validate(String value) {
        validateBlank(value);
    }

    private static void validateBlank(String value) {
        if (isBlank(value)) {
            throw new IllegalArgumentException(DATE_INVALID_EXCEPTION);
        }
    }

    private static boolean isBlank(String value) {
        return value.isBlank();
    }
}
