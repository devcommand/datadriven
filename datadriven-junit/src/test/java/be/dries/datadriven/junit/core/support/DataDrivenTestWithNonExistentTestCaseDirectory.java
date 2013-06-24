package be.dries.datadriven.junit.core.support;

import be.dries.datadriven.junit.core.DataDrivenTestCase;

/**
 * {@code DataDrivenTestWithNonExistentTestCaseDirectory} is a mock test case
 * with no associated test case directory.
 *
 * @author Dries Elliott
 */
@DataDrivenTestCase(directory = "nonExistentTestDirectory")
public class DataDrivenTestWithNonExistentTestCaseDirectory {
}
