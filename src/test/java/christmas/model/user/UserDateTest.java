package christmas.model.user;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;

class UserDateTest {
    @Test
    public void 기준_날짜가_시작일과_종료일_사이에_위치하지_않는다() {
        UserDate userDate = new UserDate(2023, 12, 15);
        LocalDate startDate = LocalDate.of(2023, 12, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);

        assertTrue(userDate.isBetween(startDate, endDate));
    }

    @Test
    public void 기준_날짜가_시작일과_종료일_사이에_위치한다() {
        UserDate userDate = new UserDate(2023, 10, 15);
        LocalDate startDate = LocalDate.of(2023, 12, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);

        assertFalse(userDate.isBetween(startDate, endDate));
    }

    @Test
    public void 기준_날짜가_LocalDate_리스트에_포함되지_않는다() {
        UserDate userDate = new UserDate(2023, 12, 15);
        List<LocalDate> promotionDates = List.of(
                LocalDate.of(2023, 12, 10),
                LocalDate.of(2023, 12, 15),
                LocalDate.of(2023, 12, 20)
        );
        assertTrue(userDate.isBetween(promotionDates));
    }

    @Test
    public void 기준_날짜가_LocalDate_리스트에_포함된다() {
        UserDate userDate = new UserDate(2023, 12, 1);
        List<LocalDate> promotionDates = List.of(
                LocalDate.of(2023, 12, 10),
                LocalDate.of(2023, 12, 15),
                LocalDate.of(2023, 12, 20)
        );

        assertFalse(userDate.isBetween(promotionDates));
    }


}