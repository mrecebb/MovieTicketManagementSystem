package customers;

import enums.NotificationChannel;
import exceptions.InvalidChoice;
import interfaces.CustomerRepository;
import interfaces.InputService;

import java.io.IOException;
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
    public Customer getInformation() throws IOException {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        System.out.println("Notification channels: ");
        for (int i = 0; i < notificationChannels.size(); i++) {
            System.out.println((i + 1) + ". " + notificationChannels.get(i));
        }
        System.out.print("Enter(1-" + notificationChannels.size() + "): ");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice < 1 || choice > notificationChannels.size()) {
            throw new InvalidChoice("Invalid choice");
        }
        NotificationChannel channel = notificationChannels.get(choice - 1);

        return new Customer(name, email, phone, channel);
    }
}
