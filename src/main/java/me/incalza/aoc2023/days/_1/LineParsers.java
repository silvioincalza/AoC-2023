package me.incalza.aoc2023.days._1;

import me.incalza.aoc2023.days.LineParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class LineParsers implements LineParser<String> {
    private static final Logger LOGGER = LoggerFactory.getLogger(LineParsers.class);
    private final List<LineParser<String>> parsers;

    private LineParsers(List<LineParser<String>> parsers) {
        this.parsers = parsers;
    }

    @SafeVarargs
    public static LineParser<String> of(LineParser<String>... lineParsers) {
        return new LineParsers(Arrays.asList(lineParsers));
    }

    @Override
    public String parse(String line) {
        String result = line;
        for (LineParser<String> lp : parsers) {
            LOGGER.debug("Pre Parse {}", result);
            result = lp.parse(result);
            LOGGER.debug("Post Parse {}", result);
        }
        return result;
    }
}
