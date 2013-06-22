package be.dries.datadriven.junit.core;

/**
 * {@code NoTemplateMethodFoundException} is thrown when a class is annotated with the
 * {@code DataDrivenTemplateTestCase} annotation, but does not contain a method
 * annotated with {@code DataDrivenTestTemplate}.
 *
 * @author Dries Elliott
 */
public class NoTemplateMethodFoundException extends RuntimeException {
    /**
     * Creates a new {@code NoTemplateMethodFoundException}.
     */
    public NoTemplateMethodFoundException() {
        super("No method annotated with '@DataDrivenTestTemplate' was found in the current test case!");
    }
}
