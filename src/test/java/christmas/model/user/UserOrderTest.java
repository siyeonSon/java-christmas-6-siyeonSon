package christmas.model.user;

import static christmas.model.menu.MenuCategory.MAIN;
import static christmas.model.menu.MenuItem.BARBECUE_LIBS;
import static christmas.model.menu.MenuItem.CHOCOLATE_CAKE;
import static christmas.model.menu.MenuItem.RED_WINE;
import static christmas.model.menu.MenuItem.SEAFOOD_PASTA;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.menu.MenuItem;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class UserOrderTest {
    @Test
    void 할인_전_총주문_금액을_계산한다() {
        Map<MenuItem, Integer> menuItems = new HashMap<>();
        menuItems.put(SEAFOOD_PASTA, 2);
        menuItems.put(RED_WINE, 1);
        menuItems.put(CHOCOLATE_CAKE, 1);

        UserOrder userOrder = new UserOrder(menuItems);

        assertThat(userOrder.getTotalPrice()).isEqualTo(145000L);
    }

    @Test
    void 메뉴_항목의_개수를_구한다() {
        Map<MenuItem, Integer> menuItems = new HashMap<>();
        menuItems.put(SEAFOOD_PASTA, 2);
        menuItems.put(BARBECUE_LIBS, 1);
        menuItems.put(CHOCOLATE_CAKE, 1);

        UserOrder userOrder = new UserOrder(menuItems);

        assertThat(userOrder.countMenuItemsByCategory(MAIN)).isEqualTo(3);
    }
}