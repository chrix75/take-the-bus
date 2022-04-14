package takethebus.imperative.orders.processors;

import takethebus.imperative.orders.Order;

public interface FileOrderProducer {
    void produceFile(Order order);
}
