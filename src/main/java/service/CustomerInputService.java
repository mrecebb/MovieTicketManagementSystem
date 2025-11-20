package service;

import domain.Customer;
import enums.NotificationChannel;
import exceptions.InvalidNotificationChannelException;
import repository.CustomerRepository;

import java.util.List;
import java.util.Scanner;

public class CustomerInputService implements InputService {
    CustomerRepository customerRepository;
    Scanner scanner;
    List<NotificationChannel> notificationChannels;

    public CustomerInputService(CustomerRepository cr, List<NotificationChannel> nc, Scanner sc) {
        this.customerRepository = cr;
        this.notificationChannels = nc;
        this.scanner = sc;

        notificationChannels.add(NotificationChannel.EMAIL);
        notificationChannels.add(NotificationChannel.SMS);
    }

    @Override
    public Customer getInformation() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        System.out.println("Notification channels: ");
        notificationChannels.forEach(notificationChannel -> {
            System.out.print(notificationChannel + ", ");
        });

        NotificationChannel channel = null;

        System.out.println("Select:");
        try {
            channel = NotificationChannel.valueOf(scanner.nextLine().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidNotificationChannelException(e.getMessage());
        }

        return new Customer(name, email, phone, channel);
    }
}
