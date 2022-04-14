package takethebus.decoupled;

import net.engio.mbassy.bus.MBassador;
import takethebus.decoupled.log.DomainLogging;
import takethebus.decoupled.mails.MailService;
import takethebus.decoupled.orders.Order;
import takethebus.decoupled.orders.OrderService;
import takethebus.decoupled.orders.messages.Message;
import takethebus.decoupled.orders.processors.CsvFileProcessor;
import takethebus.decoupled.orders.processors.OrderProcessor;
import takethebus.decoupled.orders.processors.XlsFileProcessor;
import takethebus.decoupled.stats.StatsUpdate;

public class SimpleOrderProcessing {
    public static void main(String[] args) {
        MBassador<Message> bus = new MBassador<>();
        OrderProcessor orderProcessor = new OrderProcessor(bus);
        OrderService orderService = new OrderService(bus);

        MailService mailService = new MailService();
        CsvFileProcessor csvFileProcessor = new CsvFileProcessor();
        XlsFileProcessor xlsFileProcessor = new XlsFileProcessor();
        StatsUpdate statsUpdate = new StatsUpdate();

        bus.subscribe(mailService);
        bus.subscribe(orderProcessor);
        bus.subscribe(csvFileProcessor);
        bus.subscribe(xlsFileProcessor);
        bus.subscribe(statsUpdate);
        bus.subscribe(new DomainLogging());

        orderService.processOrder(
                new Order("ID", 100, "csv")
        );
    }
}
