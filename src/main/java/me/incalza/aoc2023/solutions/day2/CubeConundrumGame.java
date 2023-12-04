package me.incalza.aoc2023.solutions.day2;

import me.incalza.aoc2023.solutions.InputReader;
import me.incalza.aoc2023.solutions.LineParser;

import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public class CubeConundrumGame {
    private final InputReader inputReader;
    private final LineParser<GameRecord> lineParser;
    private final GameRecord.SetOfCube cubeConfig;

    public CubeConundrumGame(InputReader inputReader, LineParser<GameRecord> lineParser, GameRecord.SetOfCube cubeConfig) {
        this.inputReader = inputReader;
        this.lineParser = lineParser;
        this.cubeConfig = cubeConfig;
    }

    public CubeConundrumGame(InputReader inputReader, GameRecord.SetOfCube cubeConfig) {
        this(inputReader, new GameRecordLineParser(), cubeConfig);
    }

    public int sumOfGameId() {
        return getGameRecordStream()
                .filter(not(v -> v.hasRedCubesGreatThant(cubeConfig.redCube())))
                .filter(not(v -> v.hasGreenCubesGreatThant(cubeConfig.greenCube())))
                .filter(not(v -> v.hasBlueCubesGreatThant(cubeConfig.blueCube())))
                .mapToInt(GameRecord::getId).sum();
    }

    public int maxPower() {
        return getGameRecordStream()
                .mapToInt(GameRecord::getPower).sum();
    }

    private Stream<GameRecord> getGameRecordStream() {
        return inputReader.read().stream()
                .map(lineParser::parse);
    }


}
