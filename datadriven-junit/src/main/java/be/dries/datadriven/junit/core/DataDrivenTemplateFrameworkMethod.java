package be.dries.datadriven.junit.core;

import org.junit.runners.model.FrameworkMethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * {@code DataDrivenTemplateFrameworkMethod} is a custom {@link FrameworkMethod} which
 * invokes a template method instead of a real test method.
 *
 * @author Dries Elliott
 */
public class DataDrivenTemplateFrameworkMethod extends FrameworkMethod {
    private String name;
    private String input;
    private String expectedOutput;

    /**
     * Creates a new {@code DataDrivenFrameworkMethod} for the given name.
     *
     * @param name The name of the test.
     */
    public DataDrivenTemplateFrameworkMethod(String name, Method method, String input, String expectedOutput) {
        super(method);

        this.name = name;
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

    /**
     * Invokes the template method contained in this
     * {@code DataDrivenTemplateFrameworkMethod}.
     *
     * @param target The target object of the invocation.
     * @param params The parameters of the invocation (unused).
     * @return The result of the invocation.
     * @throws Throwable If something goes wrong during invocation.
     */
    @Override
    public Object invokeExplosively(final Object target, Object... params) throws Throwable {
        try {
            return getMethod().invoke(target, input, expectedOutput);
        } catch (InvocationTargetException ex) {
            throw ex.getCause();
        }
    }
}
