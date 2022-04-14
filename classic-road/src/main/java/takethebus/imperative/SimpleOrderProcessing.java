package takethebus.imperative;

import takethebus.imperative.mails.MailService;
import takethebus.imperative.orders.*;
import takethebus.imperative.orders.processors.CsvFileProcessor;
import takethebus.imperative.orders.processors.OrderProcessor;
import takethebus.imperative.orders.processors.XlsFileProcessor;

public class SimpleOrderProcessing {
    public static void main(String[] args) {
        MailService mailService = new MailService();

        OrderService orderService = new OrderService(
                mailService,
                new OrderProcessor(
                        new CsvFileProcessor(),
                        new XlsFileProcessor(),
                        mailService)
        );

        orderService.processOrder(
                new Order("ID", 100, "csv")
        );
    }
}
