package takethebus.decoupled.orders.processors;

import net.engio.mbassy.bus.MBassador;
import net.engio.mbassy.listener.Handler;
import takethebus.decoupled.orders.Order;
import takethebus.decoupled.orders.messages.DeliverCsvFileEvent;
import takethebus.decoupled.orders.messages.DeliverExcelFileEvent;
import takethebus.decoupled.orders.messages.Message;
import takethebus.decoupled.orders.messages.ProcessOrderEvent;

public class OrderProcessor {
    private final MBassador<Message> bus;

    public OrderProcessor(MBassador<Message> bus) {
        this.bus = bus;
    }

    @Handler
    public void deliver(ProcessOrderEvent message) {
        Order order = message.order();
        if (order.isCsv()) {
            bus.publish(new DeliverCsvFileEvent(order));
        } else if (order.isExcel()) {
            bus.publish(new DeliverExcelFileEvent(order));
        } else {
            throw new UnsupportedOperationException("Type de fichier inconnu.");
        }
    }
}
