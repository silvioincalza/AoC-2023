package me.incalza.aoc2023.days._1;

import me.incalza.aoc2023.days.InputReader;
import me.incalza.aoc2023.days.LineParser;

public class CalibrationDecoder {

    private final InputReader reader;
    private final LineParser<String> lineParser;

    public CalibrationDecoder(InputReader inputReader, LineParser<String> lineParser) {
        this.reader = inputReader;
        this.lineParser = lineParser;
    }

    public int decode() {
        return reader.read().stream().map(lineParser::parse).mapToInt(Integer::valueOf).sum();
    }

}
