package pl.lelenet;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileManager {

    public static Path stringToPath(String s) {
        return FileSystems.getDefault().getPath(s);
    }

    public static List<Path> getDirContents(Path directory) throws IOException {
        return Files.list(directory).collect(Collectors.toList());
    }

    public static void deleteContents(String directory) throws IOException {
        List<Path> files = getDirContents(stringToPath(directory));
        for (Path file : files) {
            Files.delete(file);
        }
    }

    public static void copyContents(String fromDir, String toDir) throws IOException {
        List<Path> files = getDirContents(stringToPath(fromDir));
        for (Path file : files) {
            Files.copy(file, stringToPath(toDir + file.getFileName()));
        }
    }
}
