package be.dries.datadriven.junit.core;

import be.dries.datadriven.junit.core.support.DataDrivenTestTemplateWithoutTemplateMethodTestCaseMock;
import be.dries.datadriven.junit.core.support.TraditionalTestCaseMock;
import org.junit.Test;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import java.util.List;

import static be.dries.datadriven.junit.core.support.JUnitAssertions.assertThat;

/**
 * @author Dries Elliott
 */
public class DataDrivenTestRunnerTest {
    @Test
    public void testTraditionalJunitTestIsStillFound() throws InitializationError {
        DataDrivenTestRunner runner = new DataDrivenTestRunner(TraditionalTestCaseMock.class);

        List<FrameworkMethod> testMethods = runner.computeTestMethods();

        assertThat(testMethods)
                .describedAs("Expected at least one test method!")
                .hasSize(1);
        assertThat(testMethods.get(0))
                .describedAs("The test method does not have the expected name!")
                .hasName("traditionalJUnitTest");
    }

    @Test(expected = NoTemplateMethodFoundException.class)
    public void testDataDrivenTemplateTestCaseWithoutTemplateMethodFails() throws InitializationError {
        new DataDrivenTestRunner(DataDrivenTestTemplateWithoutTemplateMethodTestCaseMock.class);
    }
}
