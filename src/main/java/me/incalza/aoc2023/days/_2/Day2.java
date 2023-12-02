package me.incalza.aoc2023.days._2;

import me.incalza.aoc2023.days.InputReader;
import me.incalza.aoc2023.days._1.Day1;
import me.incalza.aoc2023.days._2.ElfiCubeConundrumDecoder.CubeConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;


public class Day2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(Day2.class);

    public static void main(String[] args) throws Exception {
        InputReader inputReader = InputReader.of(Path.of(Day2.class.getResource("input.txt").toURI()));
        CubeConfig config = new CubeConfig(12, 13, 14);
        LOGGER.info("Part 1 {}", decodePart1(inputReader, config).decode());
//        LOGGER.info("Part 2 {}", decodePart2(inputReader).decode());
    }

    private static ElfiCubeConundrumDecoder decodePart1(InputReader inputReader, CubeConfig config) {
        return new ElfiCubeConundrumDecoder(inputReader, config);
    }


}
