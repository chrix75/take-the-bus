package takethebus.imperative.orders.processors;

import takethebus.imperative.orders.Order;

public class CsvFileProcessor implements FileOrderProducer {
    @Override
    public void produceFile(Order order) {
        System.out.println("Extraction des données et production du fichier CSV de la commande " + order);
    }
}
