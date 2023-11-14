package christmas.model.user;

import static christmas.util.message.ErrorMessages.DATE_INVALID_EXCEPTION;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class UserDate {
    final LocalDate date;

    public UserDate(int year, int month, int date) {
        this.date = parseToDate(year, month, date);
    }

    public boolean isBetween(LocalDate startDate, LocalDate endDate) {
        return !date.isBefore(startDate) && !date.isAfter(endDate);
    }

    public int getMonthValue() {
        return date.getMonthValue();
    }

    public int getDayOfMonth() {
        return date.getDayOfMonth();
    }

    public DayOfWeek getDayOfWeek() {
        return date.getDayOfWeek();
    }

    private LocalDate parseToDate(int year, int month, int date) {
        try {
            return LocalDate.of(year, month, date);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(DATE_INVALID_EXCEPTION);
        }
    }
}
