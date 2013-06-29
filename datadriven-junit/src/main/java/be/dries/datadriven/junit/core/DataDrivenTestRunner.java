package be.dries.datadriven.junit.core;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import java.util.ArrayList;
import java.util.List;

/**
 * {@code DataDrivenTestRunner} is a JUnit extension used to test classes using
 * input and output data that cannot be easily described using Java.
 *
 * @author Dries Elliott
 */
public class DataDrivenTestRunner extends BlockJUnit4ClassRunner {
    /**
     * Creates a new {@code DataDrivenTestRunner}
     *
     * @param klass The test case this test runner will execute.
     * @throws InitializationError When something goes wrong during initialization
     *                             of the test case.
     */
    public DataDrivenTestRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    /**
     * Computes all test methods this runner will execute.
     *
     * @return A list of {@code FrameworkMethod}s describing the test methods.
     */
    @Override
    protected List<FrameworkMethod> computeTestMethods() {
        List<FrameworkMethod> testMethods = new ArrayList<FrameworkMethod>();
        testMethods.addAll(super.computeTestMethods());

        DataDrivenTemplateTestCase templateTestCaseAnnotation = TestClassUtils.findAnnotation(getTestClass(), DataDrivenTemplateTestCase.class);

        if (templateTestCaseAnnotation != null) {
            testMethods.addAll(computeTemplateTestMethods(templateTestCaseAnnotation));
        }

        DataDrivenTestCase dataDrivenTestCaseAnnotation = TestClassUtils.findAnnotation(getTestClass(), DataDrivenTestCase.class);

        if (dataDrivenTestCaseAnnotation != null) {
            String testCaseName = dataDrivenTestCaseAnnotation.directory();

            TestCaseDirectory directory = new TestCaseDirectory(testCaseName);

            for (TestDirectory testDirectory : directory.getTestDirectories()) {
                List<FrameworkMethod> dataDrivenTests = getTestClass().getAnnotatedMethods(DataDrivenTest.class);
                FrameworkMethod matchingTestMethod = null;

                for (FrameworkMethod dataDrivenTest : dataDrivenTests) {
                    if (dataDrivenTest.getName().equals(testDirectory.getName())) {
                        matchingTestMethod = dataDrivenTest;
                        break;
                    }
                }

                if (matchingTestMethod == null) {
                    throw new NoMatchingTestMethodForTestDirectoryException(testCaseName, testDirectory.getName());
                }

                testMethods.add(matchingTestMethod);
            }
        }

        return testMethods;
    }

    private List<FrameworkMethod> computeTemplateTestMethods(DataDrivenTemplateTestCase templateAnnotation) {
        List<FrameworkMethod> testMethods = new ArrayList<FrameworkMethod>();

        List<FrameworkMethod> templateMethods = getTestClass().getAnnotatedMethods(DataDrivenTestTemplate.class);

        if (templateMethods.isEmpty()) {
            throw new NoTemplateMethodFoundException();
        }

        String testCaseName = templateAnnotation.directory();

        TestCaseDirectory directory = new TestCaseDirectory(testCaseName);

        for (TestDirectory testDirectory : directory.getTestDirectories()) {
            String input = testDirectory.read(templateAnnotation.inputFileName());
            String expectedOutput = testDirectory.read(templateAnnotation.outputFileName());

            testMethods.add(new DataDrivenTemplateFrameworkMethod(testDirectory.getName(), templateMethods.get(0).getMethod(), input, expectedOutput));
        }

        return testMethods;
    }
}
