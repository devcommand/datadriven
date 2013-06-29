package be.dries.datadriven.junit.core;

import org.apache.commons.io.filefilter.DirectoryFileFilter;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * A {@code TestCaseDirectory} is a directory containing a suite of data-driven
 * tests.
 *
 * @author Dries Elliott
 */
public class TestCaseDirectory {
    private String testCaseName;
    private File testCaseDirectory;
    private List<TestDirectory> testDirectories;

    /**
     * Creates a new {@code TestCaseDirectory} if the given test case exists on
     * the classpath and the test case directory contains tests.
     *
     * @param testCaseName The name of the test case.
     */
    public TestCaseDirectory(String testCaseName) {
        if (ClassPathUtils.directoryExists(testCaseName)) {
            this.testCaseName = testCaseName;

            this.testCaseDirectory = ClassPathUtils.getDirectory(testCaseName);
            File[] testDirectories = this.testCaseDirectory.listFiles((FileFilter) DirectoryFileFilter.INSTANCE);

            if (testDirectories.length == 0) {
                throw new NoTestsFoundForTestCaseException(testCaseName);
            }

            this.testDirectories = new ArrayList<TestDirectory>();
            for (File testDirectory : testDirectories) {
                this.testDirectories.add(new TestDirectory(this, testDirectory));
            }
        } else {
            throw new NoTestCaseDirectoryFoundException(testCaseName);
        }
    }

    public String getTestCaseName() {
        return testCaseName;
    }

    public List<TestDirectory> getTestDirectories() {
        return testDirectories;
    }
}
