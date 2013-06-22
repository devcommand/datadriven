package be.dries.datadriven.junit.core;

import org.junit.runners.model.FrameworkMethod;

/**
 * Description goes here.
 *
 * @author Dries Elliott
 */
public class DataDrivenFrameworkMethod extends FrameworkMethod {
    private String name;

    public DataDrivenFrameworkMethod(String name) {
        super(null);

        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
