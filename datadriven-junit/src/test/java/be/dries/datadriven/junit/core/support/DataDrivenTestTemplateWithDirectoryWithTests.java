package be.dries.datadriven.junit.core.support;

import be.dries.datadriven.junit.core.DataDrivenTemplateTestCase;
import be.dries.datadriven.junit.core.DataDrivenTestTemplate;

/**
 * {@code DataDrivenTestTemplateWithDirectoryWithTests} is a mock data-driven template
 * test case. This test case points to a directory containing tests.
 *
 * @author Dries Elliott
 */
@DataDrivenTemplateTestCase(directory = "directoryContainingTests")
public class DataDrivenTestTemplateWithDirectoryWithTests {
    @DataDrivenTestTemplate
    @SuppressWarnings("unused")
    public void template() {
    }
}
