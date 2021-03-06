package be.dries.datadriven.junit.core;

import be.dries.datadriven.junit.core.support.*;
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
        new DataDrivenTestRunner(DataDrivenTestTemplateWithoutTemplateMethod.class);
    }

    @Test(expected = NoTestCaseDirectoryFoundException.class)
    public void testDataDrivenTemplateTestCaseDirectoryNotFound() throws InitializationError {
        new DataDrivenTestRunner(DataDrivenTestTemplateForNonExistentTestCaseDirectory.class);
    }

    @Test(expected = NoTestsFoundForTestCaseException.class)
    public void testDataDrivenTemplateTestCaseWithDirectoryWithNoTests() throws InitializationError {
        new DataDrivenTestRunner(DataDrivenTestTemplateWithDirectoryWithNoTests.class);
    }

    @Test
    public void testDataDrivenTemplateTestCaseVerifyTestsGeneratedForTestDirectories() throws InitializationError {
        DataDrivenTestRunner runner = new DataDrivenTestRunner(DataDrivenTestTemplateWithDirectoryWithTests.class);

        List<FrameworkMethod> testMethods = runner.computeTestMethods();

        assertThat(testMethods)
                .describedAs("Expected at least one test method!")
                .hasSize(1);

        FrameworkMethod method = testMethods.get(0);
        assertThat(method)
                .describedAs("The test method does not have the expected name!")
                .hasName("test")
                .describedAs("The test method is not of the correct type!")
                .isDataDrivenTemplateMethod();
    }

    @Test(expected = NoTestFileFoundException.class)
    public void testDataDrivenTemplateTestCaseWithTestWithNoInputFile() throws InitializationError {
        new DataDrivenTestRunner(DataDrivenTestTemplateWithDirectoryWithTestButMissingInputFile.class);
    }

    @Test(expected = NoTestFileFoundException.class)
    public void testDataDrivenTemplateTestCaseWithTestWithNoOutputFile() throws InitializationError {
        new DataDrivenTestRunner(DataDrivenTestTemplateWithDirectoryWithTestButMissingOutputFile.class);
    }

    @Test(expected = NoTestCaseDirectoryFoundException.class)
    public void testDataDrivenTestCaseDirectoryNotFound() throws InitializationError {
        new DataDrivenTestRunner(DataDrivenTestWithNonExistentTestCaseDirectory.class);
    }

    @Test(expected = NoTestsFoundForTestCaseException.class)
    public void testDataDrivenTestCaseWithDirectoryWithNoTests() throws InitializationError {
        new DataDrivenTestRunner(DataDrivenTestWithDirectoryWithNoTests.class);
    }

    @Test(expected = NoMatchingTestMethodForTestDirectoryException.class)
    public void testDataDrivenTestCaseWithDirectoryWithTestButNoMatchingTestMethodIsDefined() throws InitializationError {
        new DataDrivenTestRunner(DataDrivenTestWithDirectoryWithTestButNoTestMethod.class);
    }

    @Test
    public void testDataDrivenTestCaseVerifyTestsGeneratedForTestDirectories() throws InitializationError {
        DataDrivenTestRunner runner = new DataDrivenTestRunner(DataDrivenTestWithDirectoryWithTests.class);

        List<FrameworkMethod> testMethods = runner.computeTestMethods();

        assertThat(testMethods)
                .describedAs("Expected at least one test method!")
                .hasSize(1);
        FrameworkMethod method = testMethods.get(0);
        assertThat(method)
                .describedAs("The test method does not have the expected name!")
                .hasName("test")
                .describedAs("The test method is not of the correct type!")
                .isDataDrivenMethod();
    }

    @Test(expected = NoTestFileFoundException.class)
    public void testDataDrivenTestCaseWithTestWithNoInputFile() throws InitializationError {
        new DataDrivenTestRunner(DataDrivenTestWithDirectoryWithTestButMissingInputFile.class);
    }
}
