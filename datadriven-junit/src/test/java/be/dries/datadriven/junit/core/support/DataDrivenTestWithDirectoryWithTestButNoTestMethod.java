package be.dries.datadriven.junit.core.support;

import be.dries.datadriven.junit.core.DataDrivenTestCase;

/**
 * {@code DataDrivenTestWithDirectoryWithTestButNoTestMethod} is a mock test case
 * with one test, but no test method.
 *
 * @author Dries Elliott
 */
@DataDrivenTestCase(directory = "dataDrivenDirectoryWithOneTest", inputFileName = "input.txt")
public class DataDrivenTestWithDirectoryWithTestButNoTestMethod {
}
