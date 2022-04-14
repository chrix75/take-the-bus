package takethebus.imperative.orders;

public class OrderRules {
    public boolean accept(Order order) {
        return order.quantity() < 100_000;
    }
}
