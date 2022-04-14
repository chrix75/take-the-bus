package takethebus.decoupled.mails;

import net.engio.mbassy.listener.Handler;
import takethebus.decoupled.orders.messages.OrderBlockedEvent;
import takethebus.decoupled.orders.messages.OrderDeliveredEvent;
import takethebus.decoupled.orders.messages.OrderReceivedEvent;
import takethebus.decoupled.orders.messages.OrderRefusedEvent;

public class MailService {
    @Handler
    public void sendAwarenessEmail(OrderReceivedEvent message) {
        System.out.println("Email informant le client de la réception de la commande " + message.order());
    }

    @Handler
    public void sendValidationEmail(OrderBlockedEvent message) {
        System.out.println("Email envoyé en interne pour valider la commande " + message.order());
    }

    @Handler
    public void sendRefusalEmail(OrderRefusedEvent message) {
        System.out.println("Email envoyé au client pour l'informer du refus du traitement de la commande " + message.order());
    }

    @Handler
    public void sendLinkToOrderFile(OrderDeliveredEvent message) {
        System.out.println("Envoi du mail avec le lien du fichier pour la commande " + message.order());
    }
}
