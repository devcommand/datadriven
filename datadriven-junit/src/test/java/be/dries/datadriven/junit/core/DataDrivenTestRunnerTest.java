package be.dries.datadriven.junit.core;

import be.dries.datadriven.junit.core.support.TraditionalTestCaseMock;
import org.junit.Test;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import java.util.List;

import static be.dries.datadriven.junit.core.support.JUnitAssertions.assertThat;

/**
 * Description goes here.
 *
 * @author Dries Elliott
 */
public class DataDrivenTestRunnerTest {
    @Test
    public void testTraditionalJunitTestIsStillFound() throws InitializationError {
        DataDrivenTestRunner runner = new DataDrivenTestRunner(TraditionalTestCaseMock.class);

        List<FrameworkMethod> testMethods = runner.computeTestMethods();

        assertThat(testMethods).hasSize(1);
        assertThat(testMethods.get(0)).hasName("traditionalJUnitTest");
    }
}
