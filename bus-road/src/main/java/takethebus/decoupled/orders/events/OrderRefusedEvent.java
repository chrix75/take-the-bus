package takethebus.decoupled.orders.events;

import takethebus.decoupled.orders.Order;

import java.util.StringJoiner;

public class OrderRefusedEvent extends Event {
    public OrderRefusedEvent(Order order) {
        super(order);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OrderRefusedEvent.class.getSimpleName() + "[", "]")
                .add("order=" + order)
                .toString();
    }
}
