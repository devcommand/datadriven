package be.dries.datadriven.junit.core;

import be.dries.datadriven.junit.core.support.MockClassWithAnnotation;
import be.dries.datadriven.junit.core.support.MockClassWithoutAnnotation;
import be.dries.datadriven.junit.core.support.TestAnnotation;
import org.junit.Test;
import org.junit.runners.model.TestClass;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author Dries Elliott
 */
public class TestClassUtilsTest {
    @Test
    public void testFindAnnotation() {
        TestClass testClass = new TestClass(MockClassWithAnnotation.class);
        TestAnnotation testAnnotation = TestClassUtils.findAnnotation(testClass, TestAnnotation.class);
        assertThat(testAnnotation)
                .describedAs("An annotation was supposed to be found!")
                .isNotNull();
    }

    @Test
    public void testFindAnnotationReturnsNullWhenNoAnnotationFound() {
        TestClass testClass = new TestClass(MockClassWithoutAnnotation.class);
        TestAnnotation testAnnotation = TestClassUtils.findAnnotation(testClass, TestAnnotation.class);
        assertThat(testAnnotation)
                .describedAs("No annotation was supposed to be found!")
                .isNull();
    }
}
