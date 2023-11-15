package christmas.util.converter;

import static christmas.util.constant.ErrorMessages.DATE_INVALID_EXCEPTION;

public final class NumericConverter {
    private NumericConverter() {
    }

    public static int convert(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(DATE_INVALID_EXCEPTION);
        }
    }
}
