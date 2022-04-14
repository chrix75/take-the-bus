package takethebus.decoupled.orders.processors;

import net.engio.mbassy.listener.Handler;
import takethebus.decoupled.orders.messages.DeliverExcelFileEvent;

public class XlsFileProcessor {
    @Handler
    public void produceFile(DeliverExcelFileEvent message) {
        System.out.println("Extraction des données et production du fichier Excel de la commande " + message.order());
    }
}
