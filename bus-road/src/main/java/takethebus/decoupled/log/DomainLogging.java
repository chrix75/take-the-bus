package takethebus.decoupled.log;

import net.engio.mbassy.listener.Handler;
import takethebus.decoupled.orders.messages.Message;

public class DomainLogging {
    @Handler
    public void logDomainMessage(Message message) {
        System.out.println("Log domain message: " + message);
    }
}
