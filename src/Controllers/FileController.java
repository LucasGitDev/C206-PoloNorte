package Controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileController {
    public static List<String> readAllLines(String path) {
        Path filePath = Paths.get(path);

        try {
            List<String> lines = Files.readAllLines(filePath);
            return lines;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeAllLines(String path, List<String> lines) {
        Path filePath = Paths.get(path);

        try {
            Files.write(filePath, lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
