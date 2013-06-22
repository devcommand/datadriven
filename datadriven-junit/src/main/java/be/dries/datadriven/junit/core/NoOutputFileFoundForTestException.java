package be.dries.datadriven.junit.core;

/**
 * {@code NoOutputFileFoundForTestException} is thrown if no input file was found for
 * a given test in a data-driven test case.
 *
 * @author Dries Elliott
 */
public class NoOutputFileFoundForTestException extends DataDrivenException {
    /**
     * Creates a new {@code NoOutputFileFoundForTestException} for the given directory and test.
     *
     * @param directoryName     The test case directory.
     * @param testDirectoryName The directory within the test case.
     */
    public NoOutputFileFoundForTestException(String directoryName, String testDirectoryName) {
        super("No output file was found for test '" + testDirectoryName + "' in directory + '" + directoryName + "'!");
    }
}
