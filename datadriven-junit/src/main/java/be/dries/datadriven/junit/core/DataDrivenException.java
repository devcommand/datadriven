package be.dries.datadriven.junit.core;

/**
 * {@code DataDrivenException} is the default exception type of the data-driven
 * extension.
 *
 * @author Dries Elliott
 */
public class DataDrivenException extends RuntimeException {
    /**
     * Creates a {@code DataDrivenException} for the given cause.
     *
     * @param cause The {@code Throwable} that caused this exception to be thrown.
     */
    public DataDrivenException(Throwable cause) {
        super(cause);
    }

    /**
     * Creates a {@code DataDrivenException} with the given message.
     *
     * @param message The message of the exception.
     */
    public DataDrivenException(String message) {
        super(message);
    }
}
