package be.dries.datadriven.junit.core;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * {@code ClassPathUtils} is an utility class that contains methods used to
 * query the classpath.
 *
 * @author Dries Elliott
 */
public class ClassPathUtils {
    /**
     * Checks if the given directory exists on the classpath.
     *
     * @param directory The directory that is being verified.
     * @return True if the directory exists.
     */
    public static boolean directoryExists(String directory) {
        return getDirectory(directory) != null;
    }

    /**
     * Gets a {@link File} pointer to the given classpath directory.
     *
     * @param directory The directory to create a pointer for.
     * @return A {@code File} pointer or {@code null} if the directory
     *         does not exist or is no directory.
     */
    public static File getDirectory(String directory) {
        try {
            URL url = ClassPathUtils.class.getResource("/" + directory);

            if (url != null) {
                File file = new File(url.toURI());

                if (file.exists() && file.isDirectory()) {
                    return file;
                }
            }

            return null;
        } catch (URISyntaxException e) {
            throw new DataDrivenException(e);
        }
    }
}
