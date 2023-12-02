package me.incalza.aoc2023.days._2;

import me.incalza.aoc2023.days.InputReader;
import me.incalza.aoc2023.days._2.ElfiCubeConundrumDecoder.CubeConfig;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class ElfiCubeConundrumDecoderTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ElfiCubeConundrumDecoderTest.class);

    @Test
    void testPart1Simple() throws Exception {
        InputReader inputReader = InputReader.of(Path.of(getClass().getResource("simple1.txt").toURI()));
        ElfiCubeConundrumDecoder decoder = new ElfiCubeConundrumDecoder(inputReader, new GameRecordLineParser(),new CubeConfig(12, 13, 14));
        int decode = doDecode(decoder);
        assertThat(decode).isEqualTo(8);
    }

    @Test
    void testPart1() throws Exception {
        InputReader inputReader = InputReader.of(Path.of(getClass().getResource("input.txt").toURI()));
        ElfiCubeConundrumDecoder decoder = new ElfiCubeConundrumDecoder(inputReader, new GameRecordLineParser(),new CubeConfig(12, 13, 14));
        int decode = doDecode(decoder);
        assertThat(decode).isEqualTo(2486);
    }


    private int doDecode(ElfiCubeConundrumDecoder decoder) throws Exception {
        int decode = decoder.decode();
        LOGGER.info("Decoded: {}", decode);
        return decode;
    }


}