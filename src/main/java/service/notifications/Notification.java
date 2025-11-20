package service.notifications;

import domain.Customer;

public interface Notification {
    void purchasedTicket(Customer customer);
    void cancelTicket(Customer customer);
}
