package takethebus.imperative.orders;

import takethebus.imperative.mails.MailService;
import takethebus.imperative.orders.processors.OrderProcessor;

public class OrderService {
    private final MailService mailService;
    private final OrderProcessor processor;

    public OrderService(MailService mailService, OrderProcessor processor) {
        this.mailService = mailService;
        this.processor = processor;
    }

    public void processOrder(Order order) {

        mailService.sendAwarenessEmail(order);

        OrderRules rules = new OrderRules();

        if (!rules.accept(order)) {
            mailService.sendValidationEmail(order);
            return;
        }

        processor.deliver(order);
    }

    public void confirmOrder(Order order) {
        processor.deliver(order);
    }

    public void refuseOrder(Order order) {
        mailService.sendRefusalEmail(order);
    }
}
