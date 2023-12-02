package me.incalza.aoc2023.days;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputReaderTest {

    @Test
    void testFileNotExist() {
        InputReader inputReader = InputReader.of(Path.of("/test"));
        assertThatThrownBy(inputReader::read).isInstanceOf(IllegalStateException.class);
    }
}