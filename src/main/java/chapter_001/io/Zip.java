package chapter_001.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Zip {
    private final Path root;

    public Zip(Path root) {
        this.root = root;
    }

    public void packSingleFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(target)))) {
            for (Path src : sources) {
                zip.putNextEntry(new ZipEntry(root.relativize(src).toString()));
                try (BufferedInputStream out = new BufferedInputStream(
                        new FileInputStream(src.toString()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Path> fileFilter(String ext) throws IOException {
        SearchFiles filter = new SearchFiles(p -> !p.toFile().getName().endsWith(ext));
        Files.walkFileTree(root, filter);
        return filter.filesAll();
    }

    public static void main(String[] args) throws IOException {
        ArgZip argZip = new ArgZip(args);
        Zip zip = new Zip(Paths.get(argZip.directory()));
        zip.packSingleFiles(
                zip.fileFilter(argZip.exclude()),
                new File(argZip.output())
        );
    }

}

