package me.incalza.aoc2023.days._2;

import me.incalza.aoc2023.days.InputReader;
import me.incalza.aoc2023.days.LineParser;

import java.util.List;
import java.util.stream.Collectors;

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

    public int decode() {
//        Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
//        Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
//        Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
//        Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
//        Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
//        bag contained only 12 red cubes, 13 green cubes, and 14 blue cubes

        return inputReader.read().stream().map(lineParser::parse)
                .filter(not(v -> v.hasRedCubesGreatThant(cubeConfig.maxRed())))
                .filter(not(v -> v.hasGreenCubesGreatThant(cubeConfig.maxGreen())))
                .filter(not(v -> v.hasBlueCubesGreatThant(cubeConfig.maxBlue())))
                .mapToInt(GameRecord::getId).sum();
    }

}
