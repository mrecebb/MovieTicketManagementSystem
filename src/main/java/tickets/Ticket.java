package tickets;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Ticket {
    private long id;
    public static long idCounter = 0;
    private long customerId;
    private long movieId;
    private int seatNumber;
    private double price;
    private String purchaseTime;

    @JsonCreator
    public Ticket() {}

    public Ticket(long customerId, long movieId, int seatNumber, double price, String purchaseTime) {
        this.id = ++idCounter;
        this.customerId = customerId;
        this.movieId = movieId;
        this.seatNumber = seatNumber;
        this.price = price;
        this.purchaseTime = purchaseTime;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", seatNumber=" + seatNumber +
                ", price=" + price +
                ", purchaseTime='" + purchaseTime + '\'' +
                '}';
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
    public long getCustomerId() {
        return customerId;
    }

    @SuppressWarnings("unused")
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @SuppressWarnings("unused")
    public long getMovieId() {
        return movieId;
    }

    @SuppressWarnings("unused")
    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    @SuppressWarnings("unused")
    public int getSeatNumber() {
        return seatNumber;
    }

    @SuppressWarnings("unused")
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @SuppressWarnings("unused")
    public double getPrice() {
        return price;
    }

    @SuppressWarnings("unused")
    public void setPrice(double price) {
        this.price = price;
    }

    @SuppressWarnings("unused")
    public String getPurchaseTime() {
        return purchaseTime;
    }

    @SuppressWarnings("unused")
    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }
}
