package takethebus.decoupled.stats;

import net.engio.mbassy.listener.Handler;
import takethebus.decoupled.orders.events.OrderBlockedEvent;
import takethebus.decoupled.orders.events.OrderReceivedEvent;
import takethebus.decoupled.orders.events.OrderRefusedEvent;

public class StatsUpdate {
    @Handler
    public void updateReceivedOrderStat(OrderReceivedEvent event) {
        System.out.println("Maj de la stats du nombre total de commandes avec la commande " + event.order());
    }

    @Handler
    public void updateRefusedOrderStat(OrderRefusedEvent event) {
        System.out.println("Maj de la stats du nombre de commandes refusées avec la commande " + event.order());
    }

    @Handler
    public void updateBlockedOrderStat(OrderBlockedEvent event) {
        System.out.println("Maj de la stats du nombre total de commandes demandant une confirmation avec la commande " + event.order());
    }
}
