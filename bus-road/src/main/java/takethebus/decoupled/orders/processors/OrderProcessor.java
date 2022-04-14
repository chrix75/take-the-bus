package takethebus.decoupled.orders.processors;

import net.engio.mbassy.bus.MBassador;
import net.engio.mbassy.listener.Handler;
import takethebus.decoupled.orders.Order;
import takethebus.decoupled.orders.events.DeliverCsvFileEvent;
import takethebus.decoupled.orders.events.DeliverExcelFileEvent;
import takethebus.decoupled.orders.events.Event;
import takethebus.decoupled.orders.events.ProcessOrderEvent;

public class OrderProcessor {
    private final MBassador<Event> bus;

    public OrderProcessor(MBassador<Event> bus) {
        this.bus = bus;
    }

    @Handler
    public void deliver(ProcessOrderEvent event) {
        Order order = event.order();
        if (order.isCsv()) {
            bus.publish(new DeliverCsvFileEvent(order));
        } else if (order.isExcel()) {
            bus.publish(new DeliverExcelFileEvent(order));
        } else {
            throw new UnsupportedOperationException("Type de fichier inconnu.");
        }
    }
}
