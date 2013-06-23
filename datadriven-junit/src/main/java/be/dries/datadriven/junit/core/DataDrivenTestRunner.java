package be.dries.datadriven.junit.core;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.NameFileFilter;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
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
            List<FrameworkMethod> templateMethods = getTestClass().getAnnotatedMethods(DataDrivenTestTemplate.class);

            if (templateMethods.isEmpty()) {
                throw new NoTemplateMethodFoundException();
            }

            String testCaseName = templateTestCaseAnnotation.directory();

            if (ClassPathUtils.directoryExists(testCaseName)) {
                File directory = ClassPathUtils.getDirectory(testCaseName);
                File[] tests = directory.listFiles((FileFilter) DirectoryFileFilter.INSTANCE);

                if (tests.length != 0) {
                    for (File testDirectory : tests) {
                        String input = readTestFile(testCaseName, testDirectory, templateTestCaseAnnotation.inputFileName());
                        String expectedOutput = readTestFile(testCaseName, testDirectory, templateTestCaseAnnotation.outputFileName());

                        testMethods.add(new DataDrivenTemplateFrameworkMethod(testDirectory.getName(), templateMethods.get(0).getMethod(), input, expectedOutput));
                    }
                } else {
                    throw new NoTestsFoundForTestCaseException(testCaseName);
                }
            } else {
                throw new NoTestCaseDirectoryFoundException(testCaseName);
            }
        }

        return testMethods;
    }

    private String readTestFile(String testCase, File testDirectory, String filename) {
        File[] outputFiles = testDirectory.listFiles((FilenameFilter) new NameFileFilter(filename));

        if (outputFiles.length == 0) {
            throw new NoTestFileFoundException(testCase, testDirectory.getName(), filename);
        }

        try {
            return FileUtils.readFileToString(outputFiles[0]);
        } catch (IOException ex) {
            throw new DataDrivenException(ex);
        }
    }
}
