package be.dries.datadriven.junit.core;

import org.junit.runners.model.FrameworkMethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * {@code DataDrivenTemplateFrameworkMethod} is a custom {@link org.junit.runners.model.FrameworkMethod} which
 * invokes a test method with the correct input data.
 *
 * @author Dries Elliott
 */
public class DataDrivenFrameworkMethod extends FrameworkMethod {
    private String name;
    private String input;

    /**
     * Creates a new {@code DataDrivenFrameworkMethod} for the given test method.
     *
     * @param name       The name of the test.
     * @param testMethod The test method.
     * @param input      The input to provide to the test method.
     */
    public DataDrivenFrameworkMethod(String name, Method testMethod, String input) {
        super(testMethod);

        this.name = name;
        this.input = input;
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
     * Invokes the method contained in this
     * {@code DataDrivenFrameworkMethod}.
     *
     * @param target The target object of the invocation.
     * @param params The parameters of the invocation (unused).
     * @return The result of the invocation.
     * @throws Throwable If something goes wrong during invocation.
     */
    @Override
    public Object invokeExplosively(final Object target, Object... params) throws Throwable {
        try {
            return getMethod().invoke(target, input);
        } catch (InvocationTargetException ex) {
            throw ex.getCause();
        }
    }
}
