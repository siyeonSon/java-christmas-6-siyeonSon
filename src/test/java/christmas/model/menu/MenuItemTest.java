package christmas.model.menu;

import static christmas.util.message.ErrorMessages.ORDER_INVALID_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MenuItemTest {
    @ParameterizedTest
    @ValueSource(strings = {"김치찌개", "오리고기", "치킨"})
    void 메뉴판에_없는_메뉴인_경우_예외를_발생시킨다(String menu) {
        assertThatThrownBy(() -> MenuItem.from(menu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ORDER_INVALID_EXCEPTION);
    }
}