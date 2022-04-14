package takethebus.decoupled.orders.events;

import takethebus.decoupled.orders.Order;

import java.util.StringJoiner;

public class OrderReceivedEvent extends Event {
    public OrderReceivedEvent(Order order) {
        super(order);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OrderReceivedEvent.class.getSimpleName() + "[", "]")
                .add("order=" + order)
                .toString();
    }
}
