package takethebus.decoupled.orders.messages;

import takethebus.decoupled.orders.Order;

import java.util.StringJoiner;

public class ProcessOrderCommand extends Message {
    public ProcessOrderCommand(Order order) {
        super(order);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ProcessOrderCommand.class.getSimpleName() + "[", "]")
                .add("order=" + order)
                .toString();
    }
}
