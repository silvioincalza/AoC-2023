package me.incalza.aoc2023.solutions.day1;

import me.incalza.aoc2023.solutions.LineParser;

public class FirstAndLastDigitLineParser implements LineParser<String> {

    @Override
    public String parse(String line) {
        String firstDigit = line.chars().filter(Character::isDigit).mapToObj(Character::toString).findFirst().orElse("");
        String lastDigit = new StringBuilder(line).reverse().chars().filter(Character::isDigit).mapToObj(Character::toString).findFirst().orElse("");
        return firstDigit + lastDigit;
    }
}
