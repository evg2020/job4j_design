package chapter_001.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Search {


    public static List<Path> search(Path root, String ext) throws IOException {
        SearchFiles seacher = new SearchFiles(p -> p.toFile().getName().endsWith(ext));
        Files.walkFileTree(root, seacher);
        return seacher.filesAll();
    }

    public static void main(String[] args) throws IOException {
        Path start = Paths.get("C:\\projects");
        search(start, "js")
                .forEach(System.out::println);
    }
}


