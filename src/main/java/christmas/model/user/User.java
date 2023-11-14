package christmas.model.user;

public class User {
    protected UserDate userDate;
    protected UserOrder userOrder;

    public User(UserDate userDate, UserOrder userOrder) {
        this.userDate = userDate;
        this.userOrder = userOrder;
    }

    public long benefit() {
        return 0L;
    }

    public UserDate getUserDate() {
        return userDate;
    }

    public UserOrder getOrder() {
        return userOrder;
    }
}
