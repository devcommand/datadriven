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
    public static boolean directoryExists(String directory) {
        return getDirectory(directory) != null;
    }

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
