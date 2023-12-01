package me.incalza.aoc2023.days._1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

public class ElfiCalibrationDecoder {



    public ElfiCalibrationDecoder(LineParser lineParsers) {
        this.lineParser = lineParsers;
    }

    public static class NumberAsWordToDigitLineParser implements LineParser {
        private static final Map<String, Integer> numberAsWordToDigit = Map.of("zero", 0, "one", 1, "two", 2, "three", 3, "four", 4, "five", 5, "six", 6, "seven", 7, "eight", 8, "nine", 9);

        @Override
        public String parse(String line) {
            Map<Integer, String> orderTpReplaceNumberAsWord = numberAsWordToDigit.keySet().stream()
                    .filter(line::contains)
                    .collect(Collectors.toMap(line::indexOf, identity()));
            String result = line;
            for (String key : orderTpReplaceNumberAsWord.values()) {
                result = result.replaceAll(key, "" + numberAsWordToDigit.get(key));
            }
            return result;
        }
    }

    public static class SimpleLineParser implements LineParser {

        @Override
        public String parse(String line) {
            String leftDigit = line.chars().filter(Character::isDigit).mapToObj(Character::toString).findFirst().orElse("0");
            String rightDigit = new StringBuilder(line).reverse().chars().filter(Character::isDigit).mapToObj(Character::toString).findFirst().orElse("0");
            return leftDigit + rightDigit;
        }
    }

    public static class LineParsers implements LineParser {
        private static final Logger LOGGER = LoggerFactory.getLogger(LineParsers.class);
        private final List<LineParser> lineParsers;

        private LineParsers(List<LineParser> lineParsers) {
            this.lineParsers = lineParsers;
        }

        public static LineParser of(LineParser... lineParsers) {
            return new LineParsers(Arrays.asList(lineParsers));
        }

        @Override
        public String parse(String line) {
            String result = line;
            for (LineParser lp : lineParsers) {
                LOGGER.info("Pre Parse {}", result);
                result = lp.parse(result);
                LOGGER.info("Post Parse {}", result);
            }
            return result;
        }
    }

    private final LineParser lineParser ;




    public int decode(Path path) {
        return new DefaultInputReader(path).read().stream().map(lineParser::parse).mapToInt(Integer::valueOf).sum();
    }

}
