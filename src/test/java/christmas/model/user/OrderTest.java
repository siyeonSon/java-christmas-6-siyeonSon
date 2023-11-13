package christmas.model.user;

import static christmas.model.menu.MenuItem.CHOCOLATE_CAKE;
import static christmas.model.menu.MenuItem.RED_WINE;
import static christmas.model.menu.MenuItem.SEAFOOD_PASTA;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.menu.MenuItem;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class OrderTest {
    @Test
    void 할인_전_총주문_금액을_계산한다() {
        Map<MenuItem, Integer> menuItems = new HashMap<>();
        menuItems.put(SEAFOOD_PASTA, 2);
        menuItems.put(RED_WINE, 1);
        menuItems.put(CHOCOLATE_CAKE, 1);

        Order order = new Order(menuItems);

        assertThat(order.calculateTotalPrice()).isEqualTo(145000L);
    }
}