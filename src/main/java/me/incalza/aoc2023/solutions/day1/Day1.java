package me.incalza.aoc2023.solutions.day1;


import me.incalza.aoc2023.solutions.InputReader;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

public class Day1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(Day1.class);

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(Day1.class.getSimpleName())
                .forks(1)
                .resultFormat(ResultFormatType.JSON)
                .build();


        new Runner(opt).run();

        Day1 day1 = new Day1();
        LOGGER.info("Calibration Part 1 {}", day1.decodePart1());
        LOGGER.info("Calibration Part 2 {}", day1.decodePart2());

    }

    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @OperationsPerInvocation
    public int decodePart2() throws Exception {
        return CalibrationDecoder.part2(createInputReader()).decode();
    }

    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @OperationsPerInvocation
    public int decodePart1() throws Exception {
        return CalibrationDecoder.part1(createInputReader()).decode();
    }

    private InputReader createInputReader() throws Exception {
        return InputReader.of(Path.of(Day1.class.getResource("input.txt").toURI()));
    }

}
