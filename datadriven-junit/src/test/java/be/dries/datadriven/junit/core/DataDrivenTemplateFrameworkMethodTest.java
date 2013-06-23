package be.dries.datadriven.junit.core;

import org.junit.Test;
import org.junit.internal.runners.model.ReflectiveCallable;

import java.lang.reflect.Method;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author Dries Elliott
 */
public class DataDrivenTemplateFrameworkMethodTest {
    boolean invoked = false;

    @Test
    public void testInvokeExplosively() throws Throwable {
        Method stubMethod = DataDrivenTemplateFrameworkMethodTest.class.getMethod("stubMethod", String.class, String.class);
        DataDrivenTemplateFrameworkMethod method = new DataDrivenTemplateFrameworkMethod("test", stubMethod, "test-input", "expected-output");

        ReflectiveCallable callable = (ReflectiveCallable) method.invokeExplosively(this);
        callable.run();

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
}
