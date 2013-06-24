package be.dries.datadriven.junit.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * {@code DataDrivenTestCase} is an annotation defining a JUnit test
 * case as being data-driven.
 *
 * @author Dries Elliott
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DataDrivenTestCase {
    String directory();
}
