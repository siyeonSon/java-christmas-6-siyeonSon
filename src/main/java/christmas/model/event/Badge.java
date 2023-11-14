package christmas.model.event;

import java.util.Arrays;

public enum Badge {
    SANTA("산타", 20000),
    TREE("나무", 10000),
    STAR("별", 5000),
    NONE("없음", 0);

    private final String name;
    private final long standard;

    Badge(String name, long standard) {
        this.name = name;
        this.standard = standard;
    }

    public static Badge getEventBadge(long price) {
        return Arrays.stream(values())
                .filter(badge -> price >= badge.standard)
                .findFirst()
                .orElse(NONE);
    }

    public String getName() {
        return name;
    }
}
