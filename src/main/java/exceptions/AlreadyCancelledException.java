package exceptions;

public class AlreadyCancelledException extends RuntimeException {
    public AlreadyCancelledException(String message) {
        super(message);
    }
}
