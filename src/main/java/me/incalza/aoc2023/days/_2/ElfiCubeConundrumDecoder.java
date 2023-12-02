package me.incalza.aoc2023.days._2;

import me.incalza.aoc2023.days.InputReader;
import me.incalza.aoc2023.days.LineParser;
import me.incalza.aoc2023.days._2.GameRecord.CubeConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public class ElfiCubeConundrumDecoder {
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
        return getPossibleGameRecordAsStream()
                .mapToInt(GameRecord::getId).sum();
    }

    private Stream<GameRecord> getPossibleGameRecordAsStream() {
        return getGameRecordStream()
                .filter(not(v -> v.hasRedCubesGreatThant(cubeConfig.maxRed())))
                .filter(not(v -> v.hasGreenCubesGreatThant(cubeConfig.maxGreen())))
                .filter(not(v -> v.hasBlueCubesGreatThant(cubeConfig.maxBlue())));
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
