package takethebus.decoupled.log;

import net.engio.mbassy.listener.Handler;
import takethebus.decoupled.orders.events.Event;

public class DomainLogging {
    @Handler
    public void logDomainMessage(Event event) {
        System.out.println("Log domain event: " + event);
    }
}
