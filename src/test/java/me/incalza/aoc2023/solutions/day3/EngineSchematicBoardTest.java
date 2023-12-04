package me.incalza.aoc2023.solutions.day3;

import me.incalza.aoc2023.solutions.InputReader;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class EngineSchematicBoardTest {

    @Test
    void testCell() throws  Exception {
        InputReader inputReader = InputReader.of(Path.of(getClass().getResource("simple1.txt").toURI()));
        EngineSchematicBoard board = new EngineSchematicBoard(inputReader);
        assertThat(board.getCell(3,5).toString()).isEqualTo(".");
        assertThat(board.getCell(3,5).isPartNumber()).isFalse();
        assertThat(board.getCell(3,4).toString()).isEqualTo("5");
        assertThat(board.getCell(3,4).isPartNumber()).isTrue();
        assertThat(board.getCell(5,4).toString()).isEqualTo("*");
        assertThat(board.getCell(5,4).isPartNumber()).isTrue();
    }

    @Test
    void testSimple1() throws  Exception {
        InputReader inputReader = InputReader.of(Path.of(getClass().getResource("simple1.txt").toURI()));
        EngineSchematicBoard board = new EngineSchematicBoard(inputReader);
        assertThat(board.getTotalPartNumber()).isEqualTo(4361);
    }
}