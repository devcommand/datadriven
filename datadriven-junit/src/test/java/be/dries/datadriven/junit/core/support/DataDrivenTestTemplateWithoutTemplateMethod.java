package be.dries.datadriven.junit.core.support;

import be.dries.datadriven.junit.core.DataDrivenTemplateTestCase;

/**
 * {@code DataDrivenTestTemplateWithoutTemplateMethod} is a mock test case
 * that is annotated with {@code DataDrivenTemplateTestCase}, but does not define
 * a method annotated with {@code DataDrivenTestTemplate}.
 *
 * @author Dries Elliott
 */
@DataDrivenTemplateTestCase(directory = "noTemplateMethodTestCase")
public class DataDrivenTestTemplateWithoutTemplateMethod {
}
