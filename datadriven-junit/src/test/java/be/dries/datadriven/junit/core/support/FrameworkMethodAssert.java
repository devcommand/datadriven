package be.dries.datadriven.junit.core.support;

import be.dries.datadriven.junit.core.DataDrivenFrameworkMethod;
import be.dries.datadriven.junit.core.DataDrivenTemplateFrameworkMethod;
import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;
import org.junit.runners.model.FrameworkMethod;

/**
 * {@code FrameworkMethodAssert} is a support class providing assertions
 * for JUnit {@link FrameworkMethod}s.
 *
 * @author Dries Elliott
 */
public class FrameworkMethodAssert extends GenericAssert<FrameworkMethodAssert, FrameworkMethod> {
    /**
     * Creates a new {@code FrameworkMethodAssert} instance for the
     * given {@code FrameworkMethod}.
     *
     * @param actual The {@code FrameworkMethod} that is to be verified.
     */
    protected FrameworkMethodAssert(FrameworkMethod actual) {
        super(FrameworkMethodAssert.class, actual);
    }

    /**
     * Asserts that the actual {@code FrameworkMethod} has the given
     * name.
     *
     * @param expectedName The name the method is expected to have.
     * @return This {@code FrameworkMethodAssert} instance.
     */
    public FrameworkMethodAssert hasName(String expectedName) {
        Assertions.assertThat(actual).isNotNull();
        Assertions.assertThat(actual.getName()).isEqualTo(expectedName);

        return this;
    }

    /**
     * Asserts that the actual {@code FrameworkMethod} is an instance of
     * {@link DataDrivenTemplateFrameworkMethod}.
     *
     * @return {@code this}.
     */
    public FrameworkMethodAssert isDataDrivenTemplateMethod() {
        Assertions.assertThat(actual).isInstanceOf(DataDrivenTemplateFrameworkMethod.class);

        return this;
    }

    /**
     * Asserts that the actual {@code FrameworkMethod} is an instance of
     * {@link DataDrivenFrameworkMethod}.
     *
     * @return {@code this}.
     */
    public FrameworkMethodAssert isDataDrivenMethod() {
        Assertions.assertThat(actual).isInstanceOf(DataDrivenFrameworkMethod.class);

        return this;
    }
}
