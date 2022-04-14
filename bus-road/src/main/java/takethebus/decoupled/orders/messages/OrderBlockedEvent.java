package takethebus.decoupled.orders.messages;

import takethebus.decoupled.orders.Order;

import java.util.StringJoiner;

public class OrderBlockedEvent extends Message {
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
