package be.dries.datadriven.junit.core;

/**
 * {@code NoMatchingTestMethodForTestDirectoryException} is thrown when a test directory is
 * defined, but no matching data-driven test is found for the directory.
 *
 * @author Dries Elliott
 */
public class NoMatchingTestMethodForTestDirectoryException extends DataDrivenException {
    public NoMatchingTestMethodForTestDirectoryException(String testCaseName, String testDirectoryName) {
        super("No matching method annotated with '@DataDrivenTest' found for test directory '" + testDirectoryName + "' in test case '" + testCaseName + "'!");
    }
}
