package takethebus.decoupled.orders.processors;

import net.engio.mbassy.bus.MBassador;
import net.engio.mbassy.listener.Handler;
import takethebus.decoupled.orders.Order;
import takethebus.decoupled.orders.messages.DeliverCsvFileCommand;
import takethebus.decoupled.orders.messages.DeliverExcelFileCommand;
import takethebus.decoupled.orders.messages.Message;
import takethebus.decoupled.orders.messages.ProcessOrderCommand;

public class OrderProcessor {
    private final MBassador<Message> bus;

    public OrderProcessor(MBassador<Message> bus) {
        this.bus = bus;
    }

    @Handler
    public void deliver(ProcessOrderCommand message) {
        Order order = message.order();
        if (order.isCsv()) {
            bus.publish(new DeliverCsvFileCommand(order));
        } else if (order.isExcel()) {
            bus.publish(new DeliverExcelFileCommand(order));
        } else {
            throw new UnsupportedOperationException("Type de fichier inconnu.");
        }
    }
}