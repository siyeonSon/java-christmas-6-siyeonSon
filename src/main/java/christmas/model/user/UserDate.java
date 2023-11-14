package christmas.model.user;

import static christmas.util.message.ErrorMessages.DATE_INVALID_EXCEPTION;
import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class UserDate {
    final LocalDate date;

    public UserDate(int year, int month, int date) {
        this.date = parseToDate(year, month, date);
    }

    public boolean isBetween(LocalDate startDate, LocalDate endDate) {
        return !date.isBefore(startDate) && !date.isAfter(endDate);
    }

    public boolean isBetween(List<LocalDate> promotionDates) {
        return promotionDates.contains(date);
    }

    public int getMonthValue() {
        return date.getMonthValue();
    }

    public int getDayOfMonth() {
        return date.getDayOfMonth();
    }

    public boolean isWeekend() {
        return date.getDayOfWeek() == FRIDAY || date.getDayOfWeek() == SATURDAY;
    }

    private LocalDate parseToDate(int year, int month, int date) {
        try {
            return LocalDate.of(year, month, date);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(DATE_INVALID_EXCEPTION);
        }
    }
}
