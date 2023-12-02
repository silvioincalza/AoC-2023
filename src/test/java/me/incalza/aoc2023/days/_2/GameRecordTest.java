package me.incalza.aoc2023.days._2;

import me.incalza.aoc2023.days._2.GameRecord.SetOfCube;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameRecordTest {
    private final GameRecord gameRecord = new GameRecord(1, List.of(new SetOfCube(5, 10, 15),
            new SetOfCube(10, 5, 5)));

    @Test
    void whenHasRedCubesGreaterThantMaxValueThenReturnTrue() {
        assertThat(gameRecord.hasRedCubesGreatThant(5)).isTrue();
    }

    @Test
    void whenDoesNotHasRedCubesGreaterThantMaxValueThenReturnFalse() {
        assertThat(gameRecord.hasRedCubesGreatThant(10)).isFalse();
    }

    @Test
    void whenHasGreenCubesGreaterThantMaxValueThenReturnTrue() {
        assertThat(gameRecord.hasGreenCubesGreatThant(5)).isTrue();
    }

    @Test
    void whenDoesNotHasGreenCubesGreaterThantMaxValueThenReturnFalse() {
        assertThat(gameRecord.hasGreenCubesGreatThant(10)).isFalse();
    }

    @Test
    void whenHasBlueCubesGreaterThantMaxValueThenReturnTrue() {
        assertThat(gameRecord.hasBlueCubesGreatThant(5)).isTrue();
    }

    @Test
    void whenDoesNotHasBlueCubesGreaterThantMaxValueThenReturnFalse() {
        assertThat(gameRecord.hasBlueCubesGreatThant(30)).isFalse();
    }

    @Test
    void testGetPossibleConfiguration() {
        assertThat(gameRecord.getPossibleConfiguration()).isEqualTo(new SetOfCube(10, 10, 15));
    }

    @Test
    void testGetPower() {
        assertThat(gameRecord.getPower()).isEqualTo(1500);
    }

}