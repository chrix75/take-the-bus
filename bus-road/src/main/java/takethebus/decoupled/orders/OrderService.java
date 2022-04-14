package takethebus.decoupled.orders;

import net.engio.mbassy.bus.MBassador;
import takethebus.decoupled.orders.events.*;

public class OrderService {

    private final MBassador<Event> bus;

    public OrderService(MBassador<Event> bus) {
        this.bus = bus;
    }


    public void processOrder(Order order) {
        bus.publish(new OrderReceivedEvent(order));

        OrderRules rules = new OrderRules();

        if (!rules.accept(order)) {
            bus.publish(new OrderBlockedEvent(order));
            return;
        }

        bus.publish(new ProcessOrderEvent(order));
    }

    public void confirmOrder(Order order) {
        bus.publish(new ProcessOrderEvent(order));
    }

    public void refuseOrder(Order order) {
        bus.publish(new OrderRefusedEvent(order));
    }
}
