package takethebus.decoupled.orders.messages;

import takethebus.decoupled.orders.Order;

public abstract class Message {
    protected final Order order;

    public Message(Order order) {
        this.order = order;
    }

    public Order order() {
        return order;
    }
}
