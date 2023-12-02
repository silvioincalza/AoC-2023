package me.incalza.aoc2023.days._1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

public class ElfiCalibrationDecoder {

    public static class NumberAsWordToDigitLineParser implements LineParser {
        private static final Map<String, String> numberAsWordToDigit = Map.of( "one", "one1one", "two", "two2two", "three", "three3three", "four", "four4four", "five", "five5five", "six", "six6six", "seven", "seven7seven", "eight", "eight8eight", "nine", "nine9nine");

        @Override
        public String parse(String line) {
            Map<Integer, String> orderTpReplaceNumberAsWord = numberAsWordToDigit.keySet().stream()
                    .filter(line::contains)
                    .collect(Collectors.toMap(line::indexOf, identity()));
            String result = line;
            for (String key : orderTpReplaceNumberAsWord.values()) {
                result = result.replaceAll(key,  numberAsWordToDigit.get(key));
            }
            return result;
        }
    }

    public static class SimpleLineParser implements LineParser {

        @Override
        public String parse(String line) {
            String firstDigit = line.chars().filter(Character::isDigit).mapToObj(Character::toString).findFirst().orElse("");
            String lastDigit = new StringBuilder(line).reverse().chars().filter(Character::isDigit).mapToObj(Character::toString).findFirst().orElse("");
            return firstDigit + lastDigit;
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
    public ElfiCalibrationDecoder(LineParser lineParsers) {
        this.lineParser = lineParsers;
    }

    public int decode(Path path) {
        return new DefaultInputReader(path).read().stream().map(lineParser::parse).mapToInt(Integer::valueOf).sum();
    }

}
