package takethebus.decoupled.orders.messages;

import takethebus.decoupled.orders.Order;

import java.util.StringJoiner;

public class DeliverExcelFileCommand extends Message {
    public DeliverExcelFileCommand(Order order) {
        super(order);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DeliverExcelFileCommand.class.getSimpleName() + "[", "]")
                .add("order=" + order)
                .toString();
    }
}
