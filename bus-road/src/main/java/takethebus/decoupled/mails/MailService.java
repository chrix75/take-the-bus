package takethebus.decoupled.mails;

import net.engio.mbassy.listener.Handler;
import takethebus.decoupled.orders.events.OrderBlockedEvent;
import takethebus.decoupled.orders.events.OrderDeliveredEvent;
import takethebus.decoupled.orders.events.OrderReceivedEvent;
import takethebus.decoupled.orders.events.OrderRefusedEvent;

public class MailService {
    @Handler
    public void sendAwarenessEmail(OrderReceivedEvent event) {
        System.out.println("Email informant le client de la réception de la commande " + event.order());
    }

    @Handler
    public void sendValidationEmail(OrderBlockedEvent event) {
        System.out.println("Email envoyé en interne pour valider la commande " + event.order());
    }

    @Handler
    public void sendRefusalEmail(OrderRefusedEvent event) {
        System.out.println("Email envoyé au client pour l'informer du refus du traitement de la commande " + event.order());
    }

    @Handler
    public void sendLinkToOrderFile(OrderDeliveredEvent event) {
        System.out.println("Envoi du mail avec le lien du fichier pour la commande " + event.order());
    }
}
