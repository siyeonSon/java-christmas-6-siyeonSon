package christmas.model.event;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BadgeTest {
    @Test
    void 산타_이벤트_배지를_부여한다() {
        Assertions.assertThat(Badge.getEventBadge(21000)).isEqualTo(Badge.SANTA);
    }

    @Test
    void 트리_이벤트_배지를_부여한다() {
        Assertions.assertThat(Badge.getEventBadge(12000)).isEqualTo(Badge.TREE);
    }

    @Test
    void 별_이벤트_배지를_부여한다() {
        Assertions.assertThat(Badge.getEventBadge(5200)).isEqualTo(Badge.STAR);
    }

    @Test
    void 이벤트_배지를_부여하지_않는다() {
        Assertions.assertThat(Badge.getEventBadge(1000)).isEqualTo(Badge.NONE);
    }
}