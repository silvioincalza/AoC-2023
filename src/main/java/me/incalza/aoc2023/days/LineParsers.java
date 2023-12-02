package me.incalza.aoc2023.days;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class LineParsers implements LineParser {
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
            LOGGER.debug("Pre Parse {}", result);
            result = lp.parse(result);
            LOGGER.debug("Post Parse {}", result);
        }
        return result;
    }
}
