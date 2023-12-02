package me.incalza.aoc2023.days._1;

import me.incalza.aoc2023.days.InputReader;
import me.incalza.aoc2023.days.LineParser;

import java.nio.file.Path;

public class ElfiCalibrationDecoder {

    private final LineParser lineParser;

    public ElfiCalibrationDecoder(LineParser lineParser) {
        this.lineParser = lineParser;
    }

    public int decode(Path path) {
        return InputReader.of(path).read().stream().map(lineParser::parse).mapToInt(Integer::valueOf).sum();
    }

}
