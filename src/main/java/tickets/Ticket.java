package tickets;

import java.util.Date;

public class Ticket {
    private long id;
    private static long idCounter = 0;
    private long customerId;
    private long movieId;
    private int seatNumber;
    private int price;
    private Date purchaseTime;
}
