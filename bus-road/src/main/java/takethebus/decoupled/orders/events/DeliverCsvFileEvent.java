package takethebus.decoupled.orders.events;

import takethebus.decoupled.orders.Order;

import java.util.StringJoiner;

public class DeliverCsvFileEvent extends Event {
    public DeliverCsvFileEvent(Order order) {
        super(order);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DeliverCsvFileEvent.class.getSimpleName() + "[", "]")
                .add("order=" + order)
                .toString();
    }
}
