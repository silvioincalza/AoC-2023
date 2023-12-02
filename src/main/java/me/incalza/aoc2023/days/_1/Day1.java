package me.incalza.aoc2023.days._1;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

public class Day1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(Day1.class);

    public static void main(String[] args) throws Exception {
        ElfiCalibrationDecoder decoder = new ElfiCalibrationDecoder(LineParsers.of(new FirstAndLastDigitLineParser()));
        LOGGER.info("Calibration Part 1 {}", decoder.decode(Path.of(Day1.class.getResource("input.txt").toURI())));
        decoder = new ElfiCalibrationDecoder(LineParsers.of(new NumberAsLettersToDigitLineParser(), new FirstAndLastDigitLineParser()));
        LOGGER.info("Calibration Part 2 {}", decoder.decode(Path.of(Day1.class.getResource("input.txt").toURI())));
    }
}
