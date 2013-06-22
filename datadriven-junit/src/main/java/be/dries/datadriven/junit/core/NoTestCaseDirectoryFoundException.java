package be.dries.datadriven.junit.core;

/**
 * {@code NoTestCaseDirectoryFoundException} is thrown when no directory is found on
 * the classpath for the current test case.
 *
 * @author Dries Elliott
 */
public class NoTestCaseDirectoryFoundException extends DataDrivenException {
    public NoTestCaseDirectoryFoundException(String directoryName) {
        super("No test case directory with name '" + directoryName + "' was found on the classpath!");
    }
}
