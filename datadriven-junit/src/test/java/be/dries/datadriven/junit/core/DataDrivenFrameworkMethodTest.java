package be.dries.datadriven.junit.core;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.Fail.fail;

/**
 * @author Dries Elliott
 */
public class DataDrivenFrameworkMethodTest {
    boolean invoked = false;

    @Test
    public void testInvokeExplosively() throws Throwable {
        Method stubMethod = DataDrivenFrameworkMethodTest.class.getMethod("stubMethod", String.class);
        DataDrivenFrameworkMethod method = new DataDrivenFrameworkMethod("test", stubMethod, "test-input");

        method.invokeExplosively(this);

        assertThat(invoked)
                .describedAs("Expected the stub method to be invoked.")
                .isTrue();
    }

    @SuppressWarnings("unused")
    public void stubMethod(String input) {
        invoked = true;

        assertThat(input).isEqualTo("test-input");
    }

    @Test
    public void testInvokeExplosivelyDoesNotThrowInvocationTargetExceptionOnTestFailure() throws Throwable {
        try {
            Method stubMethod = DataDrivenFrameworkMethodTest.class.getMethod("failingTestMethod", String.class);
            DataDrivenFrameworkMethod method = new DataDrivenFrameworkMethod("test", stubMethod, "test-input");

            method.invokeExplosively(this);
        } catch (InvocationTargetException ex) {
            fail("An InvocationTargetException was not expected here!");
        } catch (AssertionError assertionError) {
            //We expect an assertion error here.
        }
    }

    @SuppressWarnings("unused")
    public void failingTestMethod(String input) {
        fail();
    }
}
