package be.dries.datadriven.junit.core;

/**
 * {@code NoTestsFoundForTestCaseException} is thrown when a test case
 * directory does not contain any tests.
 *
 * @author Dries Elliott
 */
public class NoTestsFoundForTestCaseException extends DataDrivenException {
    public NoTestsFoundForTestCaseException(String directoryName) {
        super("No tests were found in directory '" + directoryName + "'.");
    }
}
