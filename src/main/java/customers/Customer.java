package customers;

import enums.NotificationChannel;

public class Customer {
    private long id;
    private static long idCounter = 0;
    private String name;
    private String email;
    private String phone;
    private NotificationChannel channel;
}
