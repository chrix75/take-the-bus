package takethebus.decoupled.orders.processors;

import net.engio.mbassy.listener.Handler;
import takethebus.decoupled.orders.events.DeliverCsvFileEvent;

public class CsvFileProcessor {
    @Handler
    public void produceFile(DeliverCsvFileEvent event) {
        System.out.println("Extraction des données et production du fichier CSV de la commande " + event.order());
    }
}
