package exceptions;

public class InvalidNotificationChannelException extends RuntimeException {
    public InvalidNotificationChannelException(String message) {
        super(message);
    }
}
