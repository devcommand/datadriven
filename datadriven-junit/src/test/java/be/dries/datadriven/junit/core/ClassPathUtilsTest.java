package be.dries.datadriven.junit.core;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author Dries Elliott
 */
public class ClassPathUtilsTest {
    @Test
    public void testDirectoryExistsWithExistingDirectory() {
        boolean exists = ClassPathUtils.directoryExists("classPathUtilsTestDirectory");

        assertThat(exists)
                .describedAs("Expected the given directory to exist on the classpath!")
                .isTrue();
    }

    @Test
    public void testDirectoryExistsWithNonExistentDirectory() {
        boolean exists = ClassPathUtils.directoryExists("nonExistentDirectory");

        assertThat(exists)
                .describedAs("Expected that the given directory did not exist on the classpath!")
                .isFalse();
    }

    @Test
    public void testDirectoryExistsWithFile() {
        boolean exists = ClassPathUtils.directoryExists("classPathUtilsTestFile");

        assertThat(exists)
                .describedAs("Expected that the given directory did not exist on the classpath!")
                .isFalse();
    }
}
