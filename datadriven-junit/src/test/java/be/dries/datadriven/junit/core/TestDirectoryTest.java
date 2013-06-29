package be.dries.datadriven.junit.core;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author Dries Elliott
 */
public class TestDirectoryTest {
    @Test
    public void testReadFile() {
        TestDirectory directory = new TestDirectory(null, ClassPathUtils.getDirectory("testdirectoryWithFile"));
        String data = directory.read("test.txt");

        assertThat(data).isEqualTo("test");
    }

    @Test
    public void testReadFileWithSpaces() {
        TestDirectory directory = new TestDirectory(null, ClassPathUtils.getDirectory("testdirectoryWithFile"));
        String data = directory.read("test-spaces.txt");

        assertThat(data).isEqualTo("test  ");
    }

    @Test
    public void testReadFileWithTabs() {
        TestDirectory directory = new TestDirectory(null, ClassPathUtils.getDirectory("testdirectoryWithFile"));
        String data = directory.read("test-tabs.txt");

        assertThat(data).isEqualTo("test\t\t");
    }

    @Test
    public void testReadFileWithEscapedText() {
        TestDirectory directory = new TestDirectory(null, ClassPathUtils.getDirectory("testdirectoryWithFile"));
        String data = directory.read("test-escaped.txt");

        assertThat(data).isEqualTo("test%s%t");
    }
}
