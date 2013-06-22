package be.dries.datadriven.junit.core;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

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
        List<FrameworkMethod> testMethods = super.computeTestMethods();
        DataDrivenTemplateTestCase templateTestCaseAnnotation = TestClassUtils.findAnnotation(getTestClass(), DataDrivenTemplateTestCase.class);

        if (templateTestCaseAnnotation != null) {
            String directoryName = templateTestCaseAnnotation.directory();

            if (!ClassPathUtils.directoryExists(directoryName)) {
                throw new NoTestCaseDirectoryFoundException(directoryName);
            }

            List<FrameworkMethod> templateMethods = getTestClass().getAnnotatedMethods(DataDrivenTestTemplate.class);

            if (templateMethods.isEmpty()) {
                throw new NoTemplateMethodFoundException();
            }
        }

        return testMethods;
    }
}
