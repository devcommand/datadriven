package be.dries.datadriven.junit.core;

import org.junit.internal.runners.model.ReflectiveCallable;
import org.junit.runners.model.FrameworkMethod;

import java.lang.reflect.Method;

/**
 * {@code DataDrivenTemplateFrameworkMethod} is a custom {@link FrameworkMethod} which
 * invokes a template method instead of a real test method.
 *
 * @author Dries Elliott
 */
public class DataDrivenTemplateFrameworkMethod extends FrameworkMethod {
    private String name;
    private Method method;
    private String input;
    private String expectedOutput;

    /**
     * Creates a new {@code DataDrivenFrameworkMethod} for the given name.
     *
     * @param name The name of the test.
     */
    public DataDrivenTemplateFrameworkMethod(String name, Method method, String input, String expectedOutput) {
        super(null);

        this.name = name;
        this.method = method;
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    /**
     * Gets the name of the test.
     *
     * @return The name of the test.
     */
    @Override
    public String getName() {
        return name;
    }

    @Override
    public Object invokeExplosively(final Object target, Object... params) throws Throwable {
        return new ReflectiveCallable() {
            @Override
            protected Object runReflectiveCall() throws Throwable {
                return method.invoke(target, input, expectedOutput);
            }
        };
    }
}
