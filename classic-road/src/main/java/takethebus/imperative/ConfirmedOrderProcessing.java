package takethebus.imperative;

import takethebus.imperative.mails.MailService;
import takethebus.imperative.orders.*;
import takethebus.imperative.orders.processors.CsvFileProcessor;
import takethebus.imperative.orders.processors.OrderProcessor;
import takethebus.imperative.orders.processors.XlsFileProcessor;

public class ConfirmedOrderProcessing {
    public static void main(String[] args) {
        MailService mailService = new MailService();

        OrderService orderService = new OrderService(
                mailService,
                new OrderProcessor(
                        new CsvFileProcessor(),
                        new XlsFileProcessor(),
                        mailService)
        );

        Order order = new Order("ID", 200_000, "xls");
        orderService.processOrder(order);
        orderService.confirmOrder(order);
    }
}
