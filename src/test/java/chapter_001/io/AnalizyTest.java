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

        try (PrintWriter out = new PrintWriter(source)) {
            List<String> list = List.of(
                    "200 10:56:01",
                    "200 10:57:01",
                    "400 10:58:01",
                    "500 11:01:02",
                    "200 11:02:02"
            );
            list.forEach(e -> out.write(e + "\n"));
        }
        analyze.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder res = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(res::append);
        }
        assertThat(res.toString(), is("10:58:01;11:02:02"));
    }
}