package me.incalza.aoc2023.solutions.day2;

import me.incalza.aoc2023.solutions.InputReader;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class CubeConundrumGameTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CubeConundrumGameTest.class);
    private static final GameRecord.SetOfCube CUBE_CONFIG = new GameRecord.SetOfCube(12, 13, 14);
    ;

    @Test
    void testPart1Simple() throws Exception {
        InputReader inputReader = InputReader.of(Path.of(getClass().getResource("simple1.txt").toURI()));
        CubeConundrumGame decoder = new CubeConundrumGame(inputReader, CUBE_CONFIG);
        int decode = doDecode(decoder);
        assertThat(decode).isEqualTo(8);
    }

    @Test
    void testPart1() throws Exception {
        InputReader inputReader = InputReader.of(Path.of(getClass().getResource("input.txt").toURI()));

        CubeConundrumGame decoder = new CubeConundrumGame(inputReader, CUBE_CONFIG);
        int decode = doDecode(decoder);
        assertThat(decode).isEqualTo(2486);
    }

    @Test
    void testPart2Simple() throws Exception {
        InputReader inputReader = InputReader.of(Path.of(getClass().getResource("simple1.txt").toURI()));
        CubeConundrumGame decoder = new CubeConundrumGame(inputReader, new GameRecordLineParser(), new GameRecord.SetOfCube(12, 13, 14));
        int decode = doDecodePower(decoder);
        assertThat(decode).isEqualTo(2286);
    }

    @Test
    void testPart2() throws Exception {
        InputReader inputReader = InputReader.of(Path.of(getClass().getResource("input.txt").toURI()));
        CubeConundrumGame decoder = new CubeConundrumGame(inputReader, CUBE_CONFIG);
        int decode = doDecodePower(decoder);
        assertThat(decode).isEqualTo(87984);
    }


    private int doDecode(CubeConundrumGame decoder) throws Exception {
        int decode = decoder.sumOfGameId();
        LOGGER.info("Decoded: {}", decode);
        return decode;
    }

    private int doDecodePower(CubeConundrumGame decoder) throws Exception {
        int decode = decoder.maxPower();
        LOGGER.info("Decoded Power: {}", decode);
        return decode;
    }


}