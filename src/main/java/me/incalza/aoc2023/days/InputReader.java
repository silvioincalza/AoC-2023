package me.incalza.aoc2023.days;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public interface InputReader {

    List<String> read();

     static InputReader of(Path path) {
        return new DefaultInputReader(path);
    }

    final class DefaultInputReader implements InputReader {

        private final Path path;

        private DefaultInputReader(Path path) {
            this.path = path;
        }

        @Override
        public List<String> read() {
            try {
                return Files.readAllLines(path, StandardCharsets.UTF_8);
            } catch (IOException e) {
                throw new IllegalStateException("Cannot read all line in file %s".formatted(path.toString()));
            }
        }

    }

}
