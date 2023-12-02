package me.incalza.aoc2023.days._2;

import me.incalza.aoc2023.days.LineParsers;
import me.incalza.aoc2023.days._1.Day1;
import me.incalza.aoc2023.days._1.ElfiCalibrationDecoder;
import me.incalza.aoc2023.days._1.FirstAndLastDigitLineParser;
import me.incalza.aoc2023.days._1.NumberAsLettersToDigitLineParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

public class Day2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(Day2.class);

    public static void main(String[] args) throws Exception {
        ElfiCalibrationDecoder decoder = new ElfiCalibrationDecoder(LineParsers.of(new FirstAndLastDigitLineParser()));
        LOGGER.info("Calibration Part 1 {}", decoder.decode(Path.of(Day1.class.getResource("input.txt").toURI())));
        decoder = new ElfiCalibrationDecoder(LineParsers.of(new NumberAsLettersToDigitLineParser(), new FirstAndLastDigitLineParser()));
        LOGGER.info("Calibration Part 2 {}", decoder.decode(Path.of(Day1.class.getResource("input.txt").toURI())));
    }
}
