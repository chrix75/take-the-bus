package takethebus.decoupled.orders.events;

import takethebus.decoupled.orders.Order;

import java.util.StringJoiner;

public class DeliverExcelFileEvent extends Event {
    public DeliverExcelFileEvent(Order order) {
        super(order);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DeliverExcelFileEvent.class.getSimpleName() + "[", "]")
                .add("order=" + order)
                .toString();
    }
}
