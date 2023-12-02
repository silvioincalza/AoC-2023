package me.incalza.aoc2023.days._2;

import me.incalza.aoc2023.days.InputReader;
import me.incalza.aoc2023.days._2.GameRecord.SetOfCube;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class ElfiCubeConundrumDecoderTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ElfiCubeConundrumDecoderTest.class);
    private static final SetOfCube CUBE_CONFIG = new SetOfCube(12, 13, 14);
    ;

    @Test
    void testPart1Simple() throws Exception {
        InputReader inputReader = InputReader.of(Path.of(getClass().getResource("simple1.txt").toURI()));
        ElfiCubeConundrumDecoder decoder = new ElfiCubeConundrumDecoder(inputReader, CUBE_CONFIG);
        int decode = doDecode(decoder);
        assertThat(decode).isEqualTo(8);
    }

    @Test
    void testPart1() throws Exception {
        InputReader inputReader = InputReader.of(Path.of(getClass().getResource("input.txt").toURI()));

        ElfiCubeConundrumDecoder decoder = new ElfiCubeConundrumDecoder(inputReader, CUBE_CONFIG);
        int decode = doDecode(decoder);
        assertThat(decode).isEqualTo(2486);
    }

    @Test
    void testPart2Simple() throws Exception {
        InputReader inputReader = InputReader.of(Path.of(getClass().getResource("simple1.txt").toURI()));
        ElfiCubeConundrumDecoder decoder = new ElfiCubeConundrumDecoder(inputReader, new GameRecordLineParser(), new SetOfCube(12, 13, 14));
        int decode = doDecodePower(decoder);
        assertThat(decode).isEqualTo(2286);
    }

    @Test
    void testPart2() throws Exception {
        InputReader inputReader = InputReader.of(Path.of(getClass().getResource("input.txt").toURI()));
        ElfiCubeConundrumDecoder decoder = new ElfiCubeConundrumDecoder(inputReader, CUBE_CONFIG);
        int decode = doDecodePower(decoder);
        assertThat(decode).isEqualTo(87984);
    }


    private int doDecode(ElfiCubeConundrumDecoder decoder) throws Exception {
        int decode = decoder.decode();
        LOGGER.info("Decoded: {}", decode);
        return decode;
    }

    private int doDecodePower(ElfiCubeConundrumDecoder decoder) throws Exception {
        int decode = decoder.decodePower();
        LOGGER.info("Decoded Power: {}", decode);
        return decode;
    }


}