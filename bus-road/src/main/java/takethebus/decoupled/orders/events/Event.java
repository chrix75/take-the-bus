package takethebus.decoupled.orders.events;

import takethebus.decoupled.orders.Order;

public abstract class Event {
    protected final Order order;

    public Event(Order order) {
        this.order = order;
    }

    public Order order() {
        return order;
    }
}
