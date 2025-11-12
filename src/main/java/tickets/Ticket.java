package tickets;

public class Ticket {
    private long id;
    public static long idCounter = 0;
    private long customerId;
    private long movieId;
    private int seatNumber;
    private double price;
    private String purchaseTime;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }
}
