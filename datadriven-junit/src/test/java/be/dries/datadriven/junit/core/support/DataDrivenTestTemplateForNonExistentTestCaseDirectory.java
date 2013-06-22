package be.dries.datadriven.junit.core.support;

import be.dries.datadriven.junit.core.DataDrivenTemplateTestCase;
import be.dries.datadriven.junit.core.DataDrivenTestTemplate;

/**
 * {@code DataDrivenTestTemplateForNonExistentTestCaseDirectory} is a mock class containing
 * a valid data-driven template test case, but the default directory does not exist.
 *
 * @author Dries Elliott
 */
@DataDrivenTemplateTestCase(directory = "nonExistentDirectory", inputFileName = "", outputFileName = "")
public class DataDrivenTestTemplateForNonExistentTestCaseDirectory {
    @DataDrivenTestTemplate
    @SuppressWarnings("unused")
    public void datadrivenTestTemplate() {
    }
}
