package be.dries.datadriven.junit.core.support;

import be.dries.datadriven.junit.core.DataDrivenTemplateTestCase;
import be.dries.datadriven.junit.core.DataDrivenTestTemplate;

import static org.fest.assertions.Assertions.assertThat;

/**
 * {@code DataDrivenTestTemplateWithDirectoryWithTests} is a mock data-driven template
 * test case. This test case points to a directory containing tests.
 *
 * @author Dries Elliott
 */
@DataDrivenTemplateTestCase(directory = "directoryContainingTests", inputFileName = "input.txt", outputFileName = "output.txt")
public class DataDrivenTestTemplateWithDirectoryWithTests {
    @DataDrivenTestTemplate
    @SuppressWarnings("unused")
    public void template(String input, String expectedOutput) {
        assertThat(input).isEqualTo("test-input");
        assertThat(expectedOutput).isEqualTo("test-output");
    }
}
