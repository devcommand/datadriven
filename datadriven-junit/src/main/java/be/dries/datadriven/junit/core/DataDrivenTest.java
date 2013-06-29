package be.dries.datadriven.junit.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * {@code DataDrivenTest} is an annotation defining a method in a data-driven
 * test case as a data-driven test.
 *
 * @author Dries Elliott
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DataDrivenTest {
}
