package interfaces;

import customers.Customer;

public interface Notification {
    void purchasedTicket(Customer customer);
    void cancelTicket(Customer customer);
}
