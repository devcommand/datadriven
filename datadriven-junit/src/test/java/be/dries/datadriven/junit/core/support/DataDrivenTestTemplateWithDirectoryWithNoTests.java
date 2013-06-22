package be.dries.datadriven.junit.core.support;

import be.dries.datadriven.junit.core.DataDrivenTemplateTestCase;
import be.dries.datadriven.junit.core.DataDrivenTestTemplate;

/**
 * {@code DataDrivenTestTemplateWithDirectoryWithNoTests} is a mock used for
 * testing purposes that represents a data-driven test case pointing to a
 * directory with no tests.
 *
 * @author Dries Elliott
 */
@DataDrivenTemplateTestCase(directory = "directoryWithNoTests")
public class DataDrivenTestTemplateWithDirectoryWithNoTests {
    @DataDrivenTestTemplate
    @SuppressWarnings("unused")
    public void template() {
    }
}
