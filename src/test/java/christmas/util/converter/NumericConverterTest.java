package christmas.util.converter;

import static christmas.util.message.ErrorMessages.NUMBER_FORMAT_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumericConverterTest {
    @ParameterizedTest
    @ValueSource(strings = {"0", "12", "012"})
    void 문자에서_숫자로_변환한다 (String value) {
        assertDoesNotThrow(() -> NumericConverter.convert(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "a12"})
    void 문자에서_숫자로_변환을_실패한다 (String value) {
        assertThatThrownBy(() -> NumericConverter.convert(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_FORMAT_EXCEPTION);
    }
}