package me.incalza.aoc2023.days._2;

import me.incalza.aoc2023.days.InputReader;
import me.incalza.aoc2023.days.LineParser;
import me.incalza.aoc2023.days._2.GameRecord.SetOfCube;

import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public class ElfiCubeConundrumDecoder {
    private final InputReader inputReader;
    private final LineParser<GameRecord> lineParser;
    private final SetOfCube cubeConfig;

    public ElfiCubeConundrumDecoder(InputReader inputReader, LineParser<GameRecord> lineParser, SetOfCube cubeConfig) {
        this.inputReader = inputReader;
        this.lineParser = lineParser;
        this.cubeConfig = cubeConfig;
    }

    public ElfiCubeConundrumDecoder(InputReader inputReader, SetOfCube cubeConfig) {
        this(inputReader, new GameRecordLineParser(), cubeConfig);
    }

    public int decode() {
        return getGameRecordStream()
                .filter(not(v -> v.hasRedCubesGreatThant(cubeConfig.redCube())))
                .filter(not(v -> v.hasGreenCubesGreatThant(cubeConfig.greenCube())))
                .filter(not(v -> v.hasBlueCubesGreatThant(cubeConfig.blueCube())))
                .mapToInt(GameRecord::getId).sum();
    }

    public int decodePower() {
        return getGameRecordStream()
                .mapToInt(GameRecord::getPower).sum();
    }

    private Stream<GameRecord> getGameRecordStream() {
        return inputReader.read().stream()
                .map(lineParser::parse);
    }


}
