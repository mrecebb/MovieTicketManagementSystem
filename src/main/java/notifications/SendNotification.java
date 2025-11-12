package notifications;

import customers.Customer;
import enums.NotificationChannel;
import interfaces.Notification;

public class SendNotification {
    public Notification execute(Customer customer) {
        return switch (customer.getChannel()) {
            case NotificationChannel.EMAIL -> new Email();
            case NotificationChannel.SMS -> new Sms();
        };
    }
}
