package takethebus.decoupled.orders.events;

import takethebus.decoupled.orders.Order;

import java.util.StringJoiner;

public class ProcessOrderEvent extends Event {
    public ProcessOrderEvent(Order order) {
        super(order);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ProcessOrderEvent.class.getSimpleName() + "[", "]")
                .add("order=" + order)
                .toString();
    }
}
