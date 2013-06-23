package be.dries.datadriven.junit.core;

import org.junit.runner.RunWith;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author Dries Elliott
 */
@RunWith(DataDrivenTestRunner.class)
@DataDrivenTemplateTestCase(directory = "example", inputFileName = "input.txt", outputFileName = "output.txt")
public class DataDrivenTemplateTest {
    @DataDrivenTestTemplate
    public void testExample(String input, String expectedOutput) {
        assertThat(input).isEqualTo(expectedOutput);
    }
}
