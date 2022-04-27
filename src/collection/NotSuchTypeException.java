package collection;

/**
 * Exception which will be thrown when user input a type that don't exist
 */
public class NotSuchTypeException extends RuntimeException {
    public NotSuchTypeException(String message) {
        super(message);
    }
}
