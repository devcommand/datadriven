package be.dries.datadriven.junit.core.support;

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
}
