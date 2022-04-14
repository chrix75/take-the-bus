package takethebus.imperative.mails;

import takethebus.imperative.orders.Order;

public class MailService {
    public void sendAwarenessEmail(Order order) {
        System.out.println("Email informant le client de la réception de la commande " + order);
    }

    public void sendValidationEmail(Order order) {
        System.out.println("Email envoyé en interne pour valider la commande " + order);
    }

    public void sendRefusalEmail(Order order) {
        System.out.println("Email envoyé au client pour l'informer du refus du traitement de la commande " + order);
    }

    public void sendLinkToOrderFile(Order order) {
        System.out.println("Envoi du mail avec le lien du fichier pour la commande " + order);
    }
}
