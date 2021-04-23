import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FileUtils {
    static void copyFolder(Path source, Path destination) {
        try {
            List<Path> src = Files.walk(source).collect(toList());
            List<Path> dst = src.stream().map(source::relativize).map(destination::resolve).collect(toList());

            for (int i = 0; i < src.size(); i++) {
                Files.copy(src.get(i), dst.get(i), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}