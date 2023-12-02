package me.incalza.aoc2023.days._2;

import me.incalza.aoc2023.days._2.GameRecord.SetOfCube;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameRecordLineParserTest {

    @Test
    public void test() {
        GameRecord gameRecord = new GameRecordLineParser().parse("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");
        assertThat(gameRecord.getId()).isEqualTo(1);
        assertThat(gameRecord.getSetOfCubes()).contains(new SetOfCube(4, 0, 3),
                new SetOfCube(1, 2, 6),
                new SetOfCube(0, 2, 0));
    }

}