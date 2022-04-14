package takethebus.decoupled.orders.processors;

import net.engio.mbassy.listener.Handler;
import takethebus.decoupled.orders.messages.DeliverCsvFileCommand;

public class CsvFileProcessor {
    @Handler
    public void produceFile(DeliverCsvFileCommand message) {
        System.out.println("Extraction des données et production du fichier CSV de la commande " + message.order());
    }
}
