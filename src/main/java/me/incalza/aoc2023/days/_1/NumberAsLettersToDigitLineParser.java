package me.incalza.aoc2023.days._1;

import me.incalza.aoc2023.days.LineParser;

import java.util.Map;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

public class NumberAsLettersToDigitLineParser implements LineParser<String> {
    private static final Map<String, String> numberAsWordToDigit = Map.of("one", "one1one", "two", "two2two", "three", "three3three", "four", "four4four", "five", "five5five", "six", "six6six", "seven", "seven7seven", "eight", "eight8eight", "nine", "nine9nine");

    @Override
    public String parse(String line) {
        Map<Integer, String> orderTpReplaceNumberAsWord = numberAsWordToDigit.keySet().stream()
                .filter(line::contains)
                .collect(Collectors.toMap(line::indexOf, identity()));
        String result = line;
        for (String key : orderTpReplaceNumberAsWord.values()) {
            result = result.replaceAll(key, numberAsWordToDigit.get(key));
        }
        return result;
    }
}
