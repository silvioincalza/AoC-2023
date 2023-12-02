package me.incalza.aoc2023.days._1;

import me.incalza.aoc2023.days.LineParsers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.nio.file.Path;

class ElfiCalibrationDecoderTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ElfiCalibrationDecoderTest.class);


    @Test
    void testPart1Simple() throws Exception {
        ElfiCalibrationDecoder decoder = new ElfiCalibrationDecoder(new FirstAndLastDigitLineParser());
        int decode = doDecode(decoder, getClass().getResource("simple1.txt"));
        Assertions.assertThat(decode).isEqualTo(142);
    }

    @Test
    void testPart1() throws Exception {
        ElfiCalibrationDecoder decoder = new ElfiCalibrationDecoder(new FirstAndLastDigitLineParser());
        int decode = doDecode(decoder, getClass().getResource("input.txt"));
        Assertions.assertThat(decode).isEqualTo(54450);
    }

    @Test
    void testPart2Simple() throws Exception {
        ElfiCalibrationDecoder decoder = new ElfiCalibrationDecoder(LineParsers.of(new NumberAsLettersToDigitLineParser(), new FirstAndLastDigitLineParser()));
        int decode = doDecode(decoder, getClass().getResource("simple2.txt"));
        Assertions.assertThat(decode).isEqualTo(281);
    }

    @Test
    void testPart2() throws Exception {
        ElfiCalibrationDecoder decoder = new ElfiCalibrationDecoder(LineParsers.of(new NumberAsLettersToDigitLineParser(), new FirstAndLastDigitLineParser()));
        int decode = doDecode(decoder, getClass().getResource("input.txt"));
        Assertions.assertThat(decode).isEqualTo(54265);
    }

    private int doDecode(ElfiCalibrationDecoder decoder, URL resource) throws Exception {
        int decode = decoder.decode(Path.of(resource.toURI()));
        LOGGER.info("Decoded: {}", decode);
        return decode;
    }


}