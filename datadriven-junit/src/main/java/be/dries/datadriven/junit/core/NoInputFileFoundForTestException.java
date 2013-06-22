package be.dries.datadriven.junit.core;

/**
 * {@code NoInputFileFoundForTestException} is thrown if no input file was found for
 * a given test in a data-driven test case.
 *
 * @author Dries Elliott
 */
public class NoInputFileFoundForTestException extends DataDrivenException {
    /**
     * Creates a new {@code NoInputFileFoundForTestException} for the given directory and test.
     *
     * @param directoryName     The test case directory.
     * @param testDirectoryName The directory within the test case.
     */
    public NoInputFileFoundForTestException(String directoryName, String testDirectoryName) {
        super("No input file was found for test '" + testDirectoryName + "' in directory + '" + directoryName + "'!");
    }
}
