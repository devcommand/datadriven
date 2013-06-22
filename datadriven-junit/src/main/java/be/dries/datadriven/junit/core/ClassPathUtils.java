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
        try {
            URL url = ClassPathUtils.class.getResource("/" + directory);

            if (url != null) {
                File file = new File(url.toURI());
                return file.exists() && file.isDirectory();
            } else {
                return false;
            }
        } catch (URISyntaxException e) {
            throw new DataDrivenException(e);
        }
    }
}
