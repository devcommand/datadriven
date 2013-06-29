package be.dries.datadriven.junit.core;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.NameFileFilter;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * A {@code TestDirectory} represents a single data-driven test.
 *
 * @author Dries Elliott
 */
public class TestDirectory {
    private TestCaseDirectory testCaseDirectory;
    private File testDirectory;

    /**
     * Creates a new test directory for the given test case.
     *
     * @param testCaseDirectory The parent test case directory.
     * @param testDirectory     The test directory.
     */
    public TestDirectory(TestCaseDirectory testCaseDirectory, File testDirectory) {
        this.testCaseDirectory = testCaseDirectory;
        this.testDirectory = testDirectory;
    }

    public String read(String filename) {
        File[] outputFiles = testDirectory.listFiles((FilenameFilter) new NameFileFilter(filename));

        if (outputFiles.length == 0) {
            throw new NoTestFileFoundException(testCaseDirectory.getTestCaseName(), testDirectory.getName(), filename);
        }

        try {
            return FileUtils.readFileToString(outputFiles[0]);
        } catch (IOException ex) {
            throw new DataDrivenException(ex);
        }
    }

    public String getName() {
        return testDirectory.getName();
    }
}
