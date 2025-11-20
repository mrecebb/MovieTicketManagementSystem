package service.notifications;

import domain.Customer;

public class Sms implements Notification {
    @Override
    public void purchasedTicket(Customer customer) {
        System.out.println("Sms send to " +
                customer.getPhone() +
                ": The ticket has been purchased.");
    }

    @Override
    public void cancelTicket(Customer customer) {
        System.out.println("Sms send to " +
                customer.getPhone() +
                ": The ticket has been cancelled.");
    }
}
