package takethebus.decoupled.orders.events;

import takethebus.decoupled.orders.Order;

import java.util.StringJoiner;

public class OrderDeliveredEvent extends Event {
    public OrderDeliveredEvent(Order order) {
        super(order);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OrderDeliveredEvent.class.getSimpleName() + "[", "]")
                .add("order=" + order)
                .toString();
    }
}
