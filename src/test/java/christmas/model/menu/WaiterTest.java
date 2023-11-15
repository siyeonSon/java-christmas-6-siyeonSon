package christmas.model.menu;

import static christmas.util.constant.ErrorMessages.ORDER_INVALID_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WaiterTest {
    @ParameterizedTest
    @ValueSource(strings = {"타파스-1,제로콜라-1", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1"})
    void 주문을_생성한다(String order) {
        assertDoesNotThrow(() -> Waiter.generateOrder(order));
    }

    @ParameterizedTest
    @ValueSource(strings = "김치찌개-2,레드와인-1,초코케이크-1")
    void 메뉴판에_없는_메뉴를_포함하는_경우_예외를_발생시킨다(String order) {
        assertThatThrownBy(() -> Waiter.generateOrder(order))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ORDER_INVALID_EXCEPTION);
    }

    @ParameterizedTest
    @ValueSource(strings = {"해산물파스타-0", "초코케이크-23"})
    void 메뉴의_개수가_1_이상_20_이하_숫자가_아닌_경우_예외를_발생시킨다(String order) {
        assertThatThrownBy(() -> Waiter.generateOrder(order))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ORDER_INVALID_EXCEPTION);
    }

    @ParameterizedTest
    @ValueSource(strings = "해산물파스타-2,레드와인-1,초코케이크-1,해산물파스타-3")
    void 중복_메뉴를_입력한_경우_예외를_발생시킨다(String order) {
        assertThatThrownBy(() -> Waiter.generateOrder(order))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ORDER_INVALID_EXCEPTION);
    }

    @ParameterizedTest
    @ValueSource(strings = "해산물파스타-2,레드와인-1,초코케이크-19")
    void 메뉴의_총_개수가_20개를_초과하는_경우_예외를_발생시킨다(String order) {
        assertThatThrownBy(() -> Waiter.generateOrder(order))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ORDER_INVALID_EXCEPTION);
    }

    @ParameterizedTest
    @ValueSource(strings = {"해산물파스타- 2", "해산물 파스타 - 2", "해산물파스타 - 2"})
    void 메뉴_형식이_예시와_다른_경우_예외를_발생시킨다(String order) {
        assertThatThrownBy(() -> Waiter.generateOrder(order))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ORDER_INVALID_EXCEPTION);
    }

    @ParameterizedTest
    @ValueSource(strings = {"제로콜라-2", "제로콜라-2,레드와인-1"})
    void 음료만_주문할_경우_예외를_발생시킨다(String order) {
        assertThatThrownBy(() -> Waiter.generateOrder(order))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ORDER_INVALID_EXCEPTION);
    }
}