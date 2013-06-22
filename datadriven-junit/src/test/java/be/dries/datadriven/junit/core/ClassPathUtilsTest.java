package be.dries.datadriven.junit.core;

import org.junit.Test;

import java.io.File;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author Dries Elliott
 */
public class ClassPathUtilsTest {
    private static final String EXISTING_DIRECTORY = "classPathUtilsTestDirectory";
    private static final String NON_EXISTENT_DIRECTORY = "nonExistentDirectory";
    private static final String EXISTING_FILE = "classPathUtilsTestFile";

    @Test
    public void testDirectoryExistsWithExistingDirectory() {
        boolean exists = ClassPathUtils.directoryExists(EXISTING_DIRECTORY);

        assertThat(exists)
                .describedAs("Expected the given directory to exist on the classpath!")
                .isTrue();
    }

    @Test
    public void testDirectoryExistsWithNonExistentDirectory() {
        boolean exists = ClassPathUtils.directoryExists(NON_EXISTENT_DIRECTORY);

        assertThat(exists)
                .describedAs("Expected that the given directory did not exist on the classpath!")
                .isFalse();
    }

    @Test
    public void testDirectoryExistsWithFile() {
        boolean exists = ClassPathUtils.directoryExists(EXISTING_FILE);

        assertThat(exists)
                .describedAs("Expected that the given directory did not exist on the classpath!")
                .isFalse();
    }

    @Test
    public void testGetDirectoryWithExistingDirectory() {
        File directory = ClassPathUtils.getDirectory(EXISTING_DIRECTORY);

        assertThat(directory)
                .describedAs("Expected that the given directory exists!")
                .isNotNull();
    }

    @Test
    public void testGetDirectoryWithNonExistentDirectory() {
        File directory = ClassPathUtils.getDirectory(NON_EXISTENT_DIRECTORY);

        assertThat(directory)
                .describedAs("Expected that the given directory did not exist!")
                .isNull();
    }

    @Test
    public void testGetDirectoryWithFile() {
        File directory = ClassPathUtils.getDirectory(EXISTING_FILE);

        assertThat(directory)
                .describedAs("Expected that the given directory did not exist on the classpath!")
                .isNull();
    }
}
