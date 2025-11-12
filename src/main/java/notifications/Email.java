package notifications;

import customers.Customer;
import interfaces.Notification;

public class Email implements Notification {
    @Override
    public void purchasedTicket(Customer customer) {
        System.out.println("Email send to " +
                customer.getEmail() +
                ": The ticket has been purchased.");
    }

    @Override
    public void cancelTicket(Customer customer) {
        System.out.println("Email send to " +
                customer.getEmail() +
                ": The ticket has been cancelled.");
    }
}
