package christmas.model.date;

import java.time.LocalDate;

public class EventPeriod {
    private final LocalDate startDate;
    private final LocalDate endDate;

    public EventPeriod(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
