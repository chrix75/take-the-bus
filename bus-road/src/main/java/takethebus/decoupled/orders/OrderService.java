package takethebus.decoupled.orders;

import net.engio.mbassy.bus.MBassador;
import takethebus.decoupled.orders.messages.*;

public class OrderService {

    private final MBassador<Message> bus;

    public OrderService(MBassador<Message> bus) {
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
