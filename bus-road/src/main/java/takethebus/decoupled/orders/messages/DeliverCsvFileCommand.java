package takethebus.decoupled.orders.messages;

import takethebus.decoupled.orders.Order;

import java.util.StringJoiner;

public class DeliverCsvFileCommand extends Message {
    public DeliverCsvFileCommand(Order order) {
        super(order);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DeliverCsvFileCommand.class.getSimpleName() + "[", "]")
                .add("order=" + order)
                .toString();
    }
}
