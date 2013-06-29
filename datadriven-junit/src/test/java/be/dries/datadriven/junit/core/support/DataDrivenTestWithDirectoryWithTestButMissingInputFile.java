package be.dries.datadriven.junit.core.support;

import be.dries.datadriven.junit.core.DataDrivenTest;
import be.dries.datadriven.junit.core.DataDrivenTestCase;

/**
 * {@code DataDrivenTestWithDirectoryWithTestButNoTestMethod} is a mock test case
 * with one test, but missing an input file.
 *
 * @author Dries Elliott
 */
@DataDrivenTestCase(directory = "dataDrivenDirectoryWithTestWithoutInputFile", inputFileName = "input.txt")
public class DataDrivenTestWithDirectoryWithTestButMissingInputFile {
    @DataDrivenTest
    public void test() {
    }
}
