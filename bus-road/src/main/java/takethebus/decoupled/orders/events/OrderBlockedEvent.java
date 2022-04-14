package takethebus.decoupled.orders.events;

import takethebus.decoupled.orders.Order;

import java.util.StringJoiner;

public class OrderBlockedEvent extends Event {
    public OrderBlockedEvent(Order order) {
        super(order);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OrderBlockedEvent.class.getSimpleName() + "[", "]")
                .add("order=" + order)
                .toString();
    }
}
