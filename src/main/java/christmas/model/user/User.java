package christmas.model.user;

public class User {
    protected UserDate userDate;
    protected UserOrder userOrder;

    public User(UserDate userDate, UserOrder userOrder) {
        this.userDate = userDate;
        this.userOrder = userOrder;
    }

    public long event() {
        return userOrder.getTotalPrice();
    }

    public UserDate getUserDate() {
        return userDate;
    }

    public UserOrder getOrder() {
        return userOrder;
    }
}
