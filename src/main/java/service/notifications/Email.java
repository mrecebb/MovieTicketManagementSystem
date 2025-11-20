package service.notifications;

import domain.Customer;

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
