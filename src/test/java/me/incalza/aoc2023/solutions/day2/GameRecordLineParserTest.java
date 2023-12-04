package me.incalza.aoc2023.solutions.day2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameRecordLineParserTest {


    @Test
    void test() {
        GameRecord gameRecord = new GameRecordLineParser().parse("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");
        assertThat(gameRecord.getId()).isEqualTo(1);
        assertThat(gameRecord.getSetOfCubes()).contains(new GameRecord.SetOfCube(4, 0, 3),
                new GameRecord.SetOfCube(1, 2, 6),
                new GameRecord.SetOfCube(0, 2, 0));
    }

    @Test
    void testParseError() {
        GameRecordLineParser parser = new GameRecordLineParser();
        assertThatThrownBy(() -> {
            parser.parse("Game 1: 3 white, 4 red; 1 red, 2 black, 6 blue; 2 green");
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void testParseGameIdError() {
        Assertions.setMaxStackTraceElementsDisplayed(100);
        GameRecordLineParser parser = new GameRecordLineParser();
        assertThatThrownBy(() -> {
            parser.parse("Gassme 1: 3 white, 4 red; 1 red, 2 black, 6 blue; 2 green");
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void testParseSetOfCubesIdError() {
        Assertions.setMaxStackTraceElementsDisplayed(100);
        GameRecordLineParser parser = new GameRecordLineParser();
        assertThatThrownBy(() -> {
            parser.parse("Game 1: 3 white. 4 red: 1 red, 2 black, 6 blue; 2 green");
        }).isInstanceOf(IllegalStateException.class);
    }

}