package christmas.model.user;

public class User {
    protected UserDate userDate;
    protected Order order;

    public User(UserDate userDate, Order order) {
        this.userDate = userDate;
        this.order = order;
    }

    public long event() {
        return order.getTotalPrice();
    }

    public UserDate getUserDate() {
        return userDate;
    }

    public Order getOrder() {
        return order;
    }
}
