package me.incalza.aoc2023.days._1;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DefaultInputReader implements InputReader{

    private final Path path;

    public DefaultInputReader(Path path) {
        this.path = path;
    }

    @Override
    public List<String> read()  {
        try {
            return Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read all line in file %s".formatted(path.toString()));
        }
    }
}
