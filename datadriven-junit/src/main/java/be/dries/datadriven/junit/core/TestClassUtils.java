package be.dries.datadriven.junit.core;

import org.junit.runners.model.TestClass;

import java.lang.annotation.Annotation;

/**
 * {@code TestClassUtils} is an utility class providing methods that operate on
 * JUnit {@link org.junit.runners.model.TestClass} objects.
 *
 * @author Dries Elliott
 */
public class TestClassUtils {
    /**
     * Searches for a specific annotation on a {@code TestClass}.
     *
     * @param testClass       The {@code TestClass} to search.
     * @param annotationClass The annotation that is searched for.
     * @param <T>             Any type that is an {@link Annotation}.
     * @return Either an instance of T or {@code null} if no annotation was found.
     */
    public static <T extends Annotation> T findAnnotation(TestClass testClass, Class<T> annotationClass) {
        for (Annotation annotation : testClass.getAnnotations()) {
            if (annotationClass.isInstance(annotation)) {
                return annotationClass.cast(annotation);
            }
        }

        return null;
    }
}
