package me.incalza.aoc2023.days._1;

import me.incalza.aoc2023.days.InputReader;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

import static me.incalza.aoc2023.days._1.LineParsers.of;

class ElfiCalibrationDecoderTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ElfiCalibrationDecoderTest.class);


    @Test
    void testPart1Simple() throws Exception {
        InputReader inputReader = InputReader.of(Path.of(getClass().getResource("simple1.txt").toURI()));
        ElfiCalibrationDecoder decoder = new ElfiCalibrationDecoder(inputReader, new FirstAndLastDigitLineParser());
        int decode = doDecode(decoder);
        Assertions.assertThat(decode).isEqualTo(142);
    }

    @Test
    void testPart1() throws Exception {
        InputReader inputReader = InputReader.of(Path.of(getClass().getResource("input.txt").toURI()));
        ElfiCalibrationDecoder decoder = new ElfiCalibrationDecoder(inputReader, new FirstAndLastDigitLineParser());
        int decode = doDecode(decoder);
        Assertions.assertThat(decode).isEqualTo(54450);
    }

    @Test
    void testPart2Simple() throws Exception {
        InputReader inputReader = InputReader.of(Path.of(getClass().getResource("simple2.txt").toURI()));
        ElfiCalibrationDecoder decoder = new ElfiCalibrationDecoder(inputReader, of(new NumberAsLettersToDigitLineParser(), new FirstAndLastDigitLineParser()));
        int decode = doDecode(decoder);
        Assertions.assertThat(decode).isEqualTo(281);
    }

    @Test
    void testPart2() throws Exception {
        InputReader inputReader = InputReader.of(Path.of(getClass().getResource("input.txt").toURI()));
        ElfiCalibrationDecoder decoder = new ElfiCalibrationDecoder(inputReader, of(new NumberAsLettersToDigitLineParser(), new FirstAndLastDigitLineParser()));
        int decode = doDecode(decoder);
        Assertions.assertThat(decode).isEqualTo(54265);
    }

    private int doDecode(ElfiCalibrationDecoder decoder) throws Exception {
        int decode = decoder.decode();
        LOGGER.info("Decoded: {}", decode);
        return decode;
    }


}