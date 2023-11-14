package christmas.model.event;

import java.util.Arrays;

public enum Badge {
    STAR("별", 5000),
    TREE("나무", 10000),
    SANTA("산타", 20000),
    NONE("없음", 0);

    private final String name;
    private final long price;

    Badge(String name, long price) {
        this.name = name;
        this.price = price;
    }

    public static String getEventBadge(long totalPrice) {
        return Arrays.stream(values())
                .filter(badge -> totalPrice >= badge.price)
                .findFirst()
                .orElse(NONE)
                .name;
    }
}
