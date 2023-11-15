package christmas.model.event;

public class Benefits {
    private final long ddayBenefit;
    private final long weekdayBenefit;
    private final long weekendBenefit;
    private final long specialBenefit;
    private final long giftBenefit;
    private final long totalBenefit;

    public Benefits(long ddayBenefit, long weekdayBenefit, long weekendBenefit, long specialBenefit, long giftBenefit) {
        this.ddayBenefit = ddayBenefit;
        this.weekdayBenefit = weekdayBenefit;
        this.weekendBenefit = weekendBenefit;
        this.specialBenefit = specialBenefit;
        this.giftBenefit = giftBenefit;
        this.totalBenefit = calculateTotalBenefit();
    }

    public long getFinalPrice(long totalPrice) {
        return totalPrice - totalBenefit + giftBenefit;
    }

    private long calculateTotalBenefit() {
        return ddayBenefit + weekdayBenefit + weekendBenefit + specialBenefit + giftBenefit;
    }

    public long getDdayBenefit() {
        return ddayBenefit;
    }

    public long getWeekdayBenefit() {
        return weekdayBenefit;
    }

    public long getWeekendBenefit() {
        return weekendBenefit;
    }

    public long getSpecialBenefit() {
        return specialBenefit;
    }

    public long getGiftBenefit() {
        return giftBenefit;
    }

    public long getTotalBenefit() {
        return totalBenefit;
    }
}
