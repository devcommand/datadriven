package be.dries.datadriven.junit.core;

/**
 * {@code NoTestFileFoundException} is thrown when a test file is not found in
 * the test directory.
 *
 * @author Dries Elliott
 */
public class NoTestFileFoundException extends DataDrivenException {
    /**
     * Creates a new {@code NoTestFileFoundException} for the given test case and file.
     *
     * @param testCase The test case the file should be in.
     * @param test     The test the file should be in.
     * @param filename The name of the file that was not found.
     */
    public NoTestFileFoundException(String testCase, String test, String filename) {
        super("No file named '" + filename + "' was found for test '" + test + "' in test case '" + testCase + "'!");
    }
}
