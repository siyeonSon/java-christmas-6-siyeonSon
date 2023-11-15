package christmas.model.date;

import static christmas.util.constant.ChristmasEventConstant.CHRISTMAS_PROMOTION_MONTH;
import static christmas.util.constant.ChristmasEventConstant.CHRISTMAS_PROMOTION_YEAR;
import static christmas.util.constant.ErrorMessages.DATE_INVALID_EXCEPTION;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import christmas.model.user.UserDate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserDateTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 11, 31})
    void 유효한_날짜이다(int date) {
        assertDoesNotThrow(() -> new UserDate(CHRISTMAS_PROMOTION_YEAR, CHRISTMAS_PROMOTION_MONTH, date));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 34})
    void 유효하지_않은_날짜의_경우_예외를_발생시킨다(int date) {
        Assertions.assertThatThrownBy(() -> new UserDate(CHRISTMAS_PROMOTION_YEAR, CHRISTMAS_PROMOTION_MONTH, date))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DATE_INVALID_EXCEPTION);
    }
}