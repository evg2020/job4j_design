package chapter_001.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static java.nio.file.FileVisitResult.*;

public class SearchFiles implements FileVisitor<Path> {

    private Predicate<Path> predicate;
    private List<Path> filesAll = new ArrayList<>();

   SearchFiles(Predicate<Path> predicate) {
        this.predicate = predicate;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (predicate.test(file)) {
            filesAll.add(file);
        }
        return FileVisitResult.CONTINUE;
    }

    public List<Path> getfilesAll() {
        return filesAll;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return SKIP_SUBTREE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return CONTINUE;
    }




    /*public static void main(String[] args) {
        System.out.println(Arrays.toString(FileVisitResult.values()));
    }*/
}