package me.incalza.aoc2023.days._2;

import me.incalza.aoc2023.days.InputReader;
import me.incalza.aoc2023.days.LineParser;

import static java.util.function.Predicate.not;

public class ElfiCubeConundrumDecoder {
    public record CubeConfig(int maxRed, int maxGreen, int maxBlue) {
    }

    private final InputReader inputReader;
    private final LineParser<GameRecord> lineParser;
    private final CubeConfig cubeConfig;

    public ElfiCubeConundrumDecoder(InputReader inputReader, LineParser<GameRecord> lineParser, CubeConfig cubeConfig) {
        this.inputReader = inputReader;
        this.lineParser = lineParser;
        this.cubeConfig = cubeConfig;
    }

    public ElfiCubeConundrumDecoder(InputReader inputReader, CubeConfig cubeConfig) {
        this(inputReader, new GameRecordLineParser(), cubeConfig);
    }

    public int decode() {
        return inputReader.read().stream().map(lineParser::parse)
                .filter(not(v -> v.hasRedCubesGreatThant(cubeConfig.maxRed())))
                .filter(not(v -> v.hasGreenCubesGreatThant(cubeConfig.maxGreen())))
                .filter(not(v -> v.hasBlueCubesGreatThant(cubeConfig.maxBlue())))
                .mapToInt(GameRecord::getId).sum();
    }


}
