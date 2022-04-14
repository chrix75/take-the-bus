package takethebus.decoupled.orders.messages;

import takethebus.decoupled.orders.Order;

import java.util.StringJoiner;

public class DeliverCsvFileEvent extends Message {
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
