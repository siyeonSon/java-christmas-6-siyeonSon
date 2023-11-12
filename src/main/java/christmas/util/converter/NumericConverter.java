package christmas.util.converter;

import static christmas.util.message.ErrorMessages.NUMBER_FORMAT_EXCEPTION;

public final class NumericConverter {
    private NumericConverter() {
    }

    public static int convert(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION);
        }
    }
}
