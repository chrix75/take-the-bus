package takethebus.imperative.orders.processors;

import takethebus.imperative.orders.Order;

public class XlsFileProcessor implements FileOrderProducer {
    @Override
    public void produceFile(Order order) {
        System.out.println("Extraction des données et production du fichier Excel de la commande " + order);
    }
}
