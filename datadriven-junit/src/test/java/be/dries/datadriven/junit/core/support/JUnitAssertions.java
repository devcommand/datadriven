package be.dries.datadriven.junit.core.support;

import org.fest.assertions.Assertions;
import org.junit.runners.model.FrameworkMethod;

/**
 * {@code JUnitAssertions} is a support class, used to test JUnit extensions.
 *
 * @author Dries Elliott
 */
public class JUnitAssertions extends Assertions {
    /**
     * Creates an assertion builder for the given {@code FrameworkMethod}.
     *
     * @param actual The {@code FrameworkMethod} that needs to be verified.
     * @return An assertion builder instance.
     */
    public static FrameworkMethodAssert assertThat(FrameworkMethod actual) {
        return new FrameworkMethodAssert(actual);
    }
}
