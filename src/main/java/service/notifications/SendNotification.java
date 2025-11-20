package service.notifications;

import domain.Customer;
import enums.NotificationChannel;

public class SendNotification {
    public Notification execute(Customer customer) {
        return switch (customer.getChannel()) {
            case NotificationChannel.EMAIL -> new Email();
            case NotificationChannel.SMS -> new Sms();
        };
    }
}
