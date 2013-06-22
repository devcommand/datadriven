package be.dries.datadriven.junit.core.support;

import be.dries.datadriven.junit.core.DataDrivenTemplateTestCase;
import be.dries.datadriven.junit.core.DataDrivenTestTemplate;

/**
 * {@code DataDrivenTestTemplateWithDirectoryWithTestButMissingOutputFile} is a mock data-driven
 * template test case. This test case points to a directory containing a test, but the test
 * is missing an output file.
 *
 * @author Dries Elliott
 */
@DataDrivenTemplateTestCase(directory = "directoryContainingTestWithoutOutputFile", inputFileName = "input.txt", outputFileName = "output.txt")
public class DataDrivenTestTemplateWithDirectoryWithTestButMissingOutputFile {
    @DataDrivenTestTemplate
    @SuppressWarnings("unused")
    public void template() {
    }
}
