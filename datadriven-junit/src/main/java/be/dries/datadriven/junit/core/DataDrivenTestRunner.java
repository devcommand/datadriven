package be.dries.datadriven.junit.core;

import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.NameFileFilter;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
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

    @Override
    protected List<FrameworkMethod> getChildren() {
        return super.getChildren();
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
            List<FrameworkMethod> templateMethods = getTestClass().getAnnotatedMethods(DataDrivenTestTemplate.class);

            if (templateMethods.isEmpty()) {
                throw new NoTemplateMethodFoundException();
            }

            String directoryName = templateTestCaseAnnotation.directory();

            if (ClassPathUtils.directoryExists(directoryName)) {
                File directory = ClassPathUtils.getDirectory(directoryName);
                File[] tests = directory.listFiles((FileFilter) DirectoryFileFilter.INSTANCE);

                if (tests.length != 0) {
                    for (File test : tests) {
                        File[] inputFiles = test.listFiles((FilenameFilter) new NameFileFilter(templateTestCaseAnnotation.inputFileName()));

                        if (inputFiles.length == 0) {
                            throw new NoInputFileFoundForTestException(directoryName, test.getName());
                        }

                        File[] outputFiles = test.listFiles((FilenameFilter) new NameFileFilter(templateTestCaseAnnotation.outputFileName()));

                        if (outputFiles.length == 0) {
                            throw new NoOutputFileFoundForTestException(directoryName, test.getName());
                        }

                        testMethods.add(new DataDrivenTemplateFrameworkMethod(test.getName()));
                    }
                } else {
                    throw new NoTestsFoundForTestCaseException(directoryName);
                }
            } else {
                throw new NoTestCaseDirectoryFoundException(directoryName);
            }
        }

        return testMethods;
    }
}
