package takethebus.imperative.orders.processors;

import takethebus.imperative.mails.MailService;
import takethebus.imperative.orders.Order;

public class OrderProcessor {
    private final FileOrderProducer csvFileOrderProducer;
    private final FileOrderProducer xlsFileOrderProducer;
    private final MailService mailService;

    public OrderProcessor(FileOrderProducer csvFileOrderProducer, FileOrderProducer xlsFileOrderProducer, MailService mailService) {
        this.csvFileOrderProducer = csvFileOrderProducer;
        this.xlsFileOrderProducer = xlsFileOrderProducer;
        this.mailService = mailService;
    }

    public void deliver(Order order) {
        if (order.isCsv()) {
            csvFileOrderProducer.produceFile(order);
        } else if (order.isExcel()) {
            xlsFileOrderProducer.produceFile(order);
        } else {
            throw new UnsupportedOperationException("Type de fichier inconnu.");
        }

        mailService.sendLinkToOrderFile(order);
    }
}
