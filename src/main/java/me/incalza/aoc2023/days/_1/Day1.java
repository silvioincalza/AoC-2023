package me.incalza.aoc2023.days._1;


import java.nio.file.Path;
import java.util.List;

import static me.incalza.aoc2023.days._1.ElfiCalibrationDecoder.*;

public class Day1 {
    public static void main(String[] args) throws Exception{

        ElfiCalibrationDecoder decoder = new ElfiCalibrationDecoder(LineParsers.of(new NumberAsWordToDigitLineParser(), new SimpleLineParser()));
        System.out.println("Calibration  %s".formatted(decoder.decode(Path.of(Day1.class.getResource("input.txt").toURI()))));
    }
}
