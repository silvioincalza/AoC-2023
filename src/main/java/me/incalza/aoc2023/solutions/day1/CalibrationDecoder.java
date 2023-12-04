package me.incalza.aoc2023.solutions.day1;

import me.incalza.aoc2023.solutions.InputReader;
import me.incalza.aoc2023.solutions.LineParser;

public class CalibrationDecoder {

    private final InputReader reader;
    private final LineParser<String> lineParser;

    public CalibrationDecoder(InputReader inputReader, LineParser<String> lineParser) {
        this.reader = inputReader;
        this.lineParser = lineParser;
    }

    public static CalibrationDecoder part1(InputReader inputReader) {
        return new CalibrationDecoder(inputReader, new FirstAndLastDigitLineParser());
    }

    public static CalibrationDecoder part2(InputReader inputReader) {
        return new CalibrationDecoder(inputReader, LineParsers.of(new NumberAsLettersToDigitLineParser(), new FirstAndLastDigitLineParser()));
    }

    public int decode() {
        return reader.read().stream().map(lineParser::parse).mapToInt(Integer::valueOf).sum();
    }
}
