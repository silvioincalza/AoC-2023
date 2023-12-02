package me.incalza.aoc2023.days._2;

import me.incalza.aoc2023.days._1.ElfiCalibrationDecoder;
import me.incalza.aoc2023.days._1.ElfiCalibrationDecoderTest;
import me.incalza.aoc2023.days._1.FirstAndLastDigitLineParser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class ElfiCubeConundrumDecoderTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ElfiCubeConundrumDecoderTest.class);


    @Test
    void testPart1Simple() throws Exception {
        ElfiCalibrationDecoder decoder = new ElfiCalibrationDecoder(new FirstAndLastDigitLineParser());
        int decode = getDecode(decoder, getClass().getResource("simple1.txt"));
        Assertions.assertThat(decode).isEqualTo(142);
    }

}