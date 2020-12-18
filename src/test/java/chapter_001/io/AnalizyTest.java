package chapter_001.io;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenNotAvailableInMiddle() throws IOException {
        File source = folder.newFile("server.log");
        File target = folder.newFile("target.csv");
        Analizy analyze = new Analizy();
        writeToFile(source, List.of(

                "200 10:56:01",

        "200 10:57:01",

        "400 10:58:01",

       " 200 10:59:01",

        "500 11:01:02",

        "200 11:02:02"
        ));
        analyze.unavailable(source.getAbsolutePath(),
                target.getAbsolutePath());
        assertThat(
                getFileInfo(target),
                is("[10:58:01;11:02:02]"));
    }




    private String getFileInfo(File path) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new FileReader(path)
        )) {
            list = reader.lines().collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list.toString();
    }

    private void writeToFile(File file, List<String> list) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(file))) {
            list.forEach(e -> out.write(e + System.lineSeparator()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}