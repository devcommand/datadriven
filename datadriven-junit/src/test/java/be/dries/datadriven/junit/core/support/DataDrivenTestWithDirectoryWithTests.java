package be.dries.datadriven.junit.core.support;

import be.dries.datadriven.junit.core.DataDrivenTest;
import be.dries.datadriven.junit.core.DataDrivenTestCase;

/**
 * {@code DataDrivenTestWithDirectoryWithTests} is a mock test case
 * with one test and a corresponding test method.
 *
 * @author Dries Elliott
 */
@DataDrivenTestCase(directory = "dataDrivenDirectoryWithOneTest", inputFileName = "input.txt")
public class DataDrivenTestWithDirectoryWithTests {
    @DataDrivenTest
    public void test() {
    }
}
