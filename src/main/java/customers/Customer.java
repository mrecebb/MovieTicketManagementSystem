package customers;

import enums.NotificationChannel;

public class Customer {
    private long id;
    public static long idCounter = 0;
    private String name;
    private String email;
    private String phone;
    private NotificationChannel channel;

    public Customer() {}

    public Customer(String name, String email, String phone, NotificationChannel channel) {
        this.id = ++idCounter;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.channel = channel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public NotificationChannel getChannel() {
        return channel;
    }

    public void setChannel(NotificationChannel channel) {
        this.channel = channel;
    }
}
