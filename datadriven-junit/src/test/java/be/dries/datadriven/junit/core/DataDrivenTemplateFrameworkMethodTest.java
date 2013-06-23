package be.dries.datadriven.junit.core;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.Fail.fail;

/**
 * @author Dries Elliott
 */
public class DataDrivenTemplateFrameworkMethodTest {
    boolean invoked = false;

    @Test
    public void testInvokeExplosively() throws Throwable {
        Method stubMethod = DataDrivenTemplateFrameworkMethodTest.class.getMethod("stubMethod", String.class, String.class);
        DataDrivenTemplateFrameworkMethod method = new DataDrivenTemplateFrameworkMethod("test", stubMethod, "test-input", "expected-output");

        method.invokeExplosively(this);

        assertThat(invoked)
                .describedAs("Expected the stub method to be invoked.")
                .isTrue();
    }

    @SuppressWarnings("unused")
    public void stubMethod(String input, String expectedOutput) {
        invoked = true;

        assertThat(input).isEqualTo("test-input");
        assertThat(expectedOutput).isEqualTo("expected-output");
    }

    @Test
    public void testInvokeExplosivelyDoesNotThrowInvocationTargetExceptionOnTestFailure() throws Throwable {
        try {
            Method stubMethod = DataDrivenTemplateFrameworkMethodTest.class.getMethod("failingTestMethod", String.class, String.class);
            DataDrivenTemplateFrameworkMethod method = new DataDrivenTemplateFrameworkMethod("test", stubMethod, "test-input", "expected-output");

            method.invokeExplosively(this);
        } catch (InvocationTargetException ex) {
            fail("An InvocationTargetException was not expected here!");
        } catch (AssertionError assertionError) {
            //We expect an assertion error here.
        }
    }

    @SuppressWarnings("unused")
    public void failingTestMethod(String input, String expectedOutput) {
        fail();
    }
}
