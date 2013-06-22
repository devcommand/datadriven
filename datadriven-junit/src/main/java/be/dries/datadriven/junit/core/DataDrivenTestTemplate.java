package be.dries.datadriven.junit.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * {@code DataDrivenTestTemplate} is an annotation defining a method in a data-driven
 * template test case as the template method for this test case.
 *
 * @author Dries Elliott
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DataDrivenTestTemplate {
}
