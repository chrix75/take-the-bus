package takethebus.decoupled.orders.processors;

import net.engio.mbassy.listener.Handler;
import takethebus.decoupled.orders.events.DeliverExcelFileEvent;

public class XlsFileProcessor {
    @Handler
    public void produceFile(DeliverExcelFileEvent event) {
        System.out.println("Extraction des données et production du fichier Excel de la commande " + event.order());
    }
}
