package be.dries.datadriven.junit.core.support;

import be.dries.datadriven.junit.core.DataDrivenTemplateTestCase;
import be.dries.datadriven.junit.core.DataDrivenTestTemplate;

/**
 * {@code DataDrivenTestTemplateWithDirectoryWithTestButMissingInputFile} is a mock data-driven
 * template test case. This test case points to a directory containing a test, but the test
 * is missing an input file.
 *
 * @author Dries Elliott
 */
@DataDrivenTemplateTestCase(directory = "directoryContainingTestWithoutInputFile", inputFileName = "input.txt")
public class DataDrivenTestTemplateWithDirectoryWithTestButMissingInputFile {
    @DataDrivenTestTemplate
    @SuppressWarnings("unused")
    public void template() {
    }
}
