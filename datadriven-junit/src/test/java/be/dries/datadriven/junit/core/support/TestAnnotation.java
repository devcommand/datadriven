package be.dries.datadriven.junit.core.support;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * {@code TestAnnotation} is a fake annotation with no meaning used for
 * testing purposes.
 *
 * @author Dries Elliott
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TestAnnotation {
}
