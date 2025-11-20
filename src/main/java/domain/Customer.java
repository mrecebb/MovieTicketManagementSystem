package domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import enums.NotificationChannel;

public class Customer {
    private long id;
    public static long idCounter = 0;
    private String name;
    private String email;
    private String phone;
    private NotificationChannel channel;

    @JsonCreator
    public Customer() {}

    public Customer(String name, String email, String phone, NotificationChannel channel) {
        this.id = ++idCounter;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.channel = channel;
    }

    @SuppressWarnings("unused")
    public long getId() {
        return id;
    }
    @SuppressWarnings("unused")
    public void setId(long id) {
        this.id = id;
    }

    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
    }

    @SuppressWarnings("unused")
    public String getEmail() {
        return email;
    }

    @SuppressWarnings("unused")
    public void setEmail(String email) {
        this.email = email;
    }

    @SuppressWarnings("unused")
    public String getPhone() {
        return phone;
    }

    @SuppressWarnings("unused")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @SuppressWarnings("unused")
    public NotificationChannel getChannel() {
        return channel;
    }

    @SuppressWarnings("unused")
    public void setChannel(NotificationChannel channel) {
        this.channel = channel;
    }
}
