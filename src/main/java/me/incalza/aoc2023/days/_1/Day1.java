package me.incalza.aoc2023.days._1;


import me.incalza.aoc2023.days.InputReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

import static me.incalza.aoc2023.days._1.LineParsers.of;

public class Day1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(Day1.class);

    public static void main(String[] args) throws Exception {
        InputReader inputReader = InputReader.of(Path.of(Day1.class.getResource("input.txt").toURI()));
        LOGGER.info("Calibration Part 1 {}", decodePart1(inputReader).decode());
        LOGGER.info("Calibration Part 2 {}", decodePart2(inputReader).decode());
    }

    private static ElfiCalibrationDecoder decodePart1(InputReader inputReader) {
        return new ElfiCalibrationDecoder(inputReader, of(new FirstAndLastDigitLineParser()));
    }

    private static ElfiCalibrationDecoder decodePart2(InputReader inputReader) {
        return new ElfiCalibrationDecoder(inputReader, of(new NumberAsLettersToDigitLineParser(), new FirstAndLastDigitLineParser()));
    }
}
