package me.incalza.aoc2023.solutions.day2;

import me.incalza.aoc2023.solutions.InputReader;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;


@State(Scope.Benchmark)
public class Day2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(Day2.class);


    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(Day2.class.getSimpleName())
                .forks(1)
                .build();


        new Runner(opt).run();
        Day2 day2 = new Day2();
        LOGGER.info("Part 1 {}", day2.getSumOfGameId());
        LOGGER.info("Part 2 {}", day2.getMaxPower());
    }

    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @OperationsPerInvocation
    public int getSumOfGameId() {
        return cubeConundrumGame().sumOfGameId();
    }


    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @OperationsPerInvocation
    public int getMaxPower() {
        return cubeConundrumGame().maxPower();
    }

    private CubeConundrumGame cubeConundrumGame() {
        InputReader inputReader = null;
        try {
            inputReader = InputReader.of(Path.of(Day2.class.getResource("input.txt").toURI()));
            GameRecord.SetOfCube config = new GameRecord.SetOfCube(12, 13, 14);
            return new CubeConundrumGame(inputReader, config);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
