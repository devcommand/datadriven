package be.dries.datadriven.junit.core;

import org.junit.runners.model.FrameworkMethod;

/**
 * {@code DataDrivenTemplateFrameworkMethod} is a custom {@link FrameworkMethod} which
 * invokes a template method instead of a real test method.
 *
 * @author Dries Elliott
 */
public class DataDrivenTemplateFrameworkMethod extends FrameworkMethod {
    private String name;

    /**
     * Creates a new {@code DataDrivenFrameworkMethod} for the given name.
     *
     * @param name The name of the test.
     */
    public DataDrivenTemplateFrameworkMethod(String name) {
        super(null);

        this.name = name;
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
}
