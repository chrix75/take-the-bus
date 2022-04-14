package takethebus.decoupled.stats;

import net.engio.mbassy.listener.Handler;
import takethebus.decoupled.orders.messages.OrderBlockedEvent;
import takethebus.decoupled.orders.messages.OrderReceivedEvent;
import takethebus.decoupled.orders.messages.OrderRefusedEvent;

public class StatsUpdate {
    @Handler
    public void updateReceivedOrderStat(OrderReceivedEvent message) {
        System.out.println("Maj de la stats du nombre total de commandes avec la commande " + message.order());
    }

    @Handler
    public void updateRefusedOrderStat(OrderRefusedEvent message) {
        System.out.println("Maj de la stats du nombre de commandes refusées avec la commande " + message.order());
    }

    @Handler
    public void updateBlockedOrderStat(OrderBlockedEvent message) {
        System.out.println("Maj de la stats du nombre total de commandes demandant une confirmation avec la commande " + message.order());
    }
}
