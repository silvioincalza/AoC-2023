package me.incalza.aoc2023.solutions.day2;

import me.incalza.aoc2023.solutions.LineParser;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameRecordLineParser implements LineParser<GameRecord> {
    private static final Pattern regex = Pattern.compile("(?<total>\\d+)\\s(?<color>blue|red|green)");

    @Override
    public GameRecord parse(String line) {
        int id = getGameId(line);
        String setOfCubesAsString = line.substring(line.indexOf(":") + 1);
        List<GameRecord.SetOfCube> setOfCubes = Stream.of(setOfCubesAsString.split(";"))
                .map(v -> {
                    Map<String, Integer> colorAndTotalCubes = Stream.of(v.split(","))
                            .map(a -> {
                                Matcher matcher = regex.matcher(a.trim());
                                if (matcher.find()) {
                                    return new String[]{matcher.group("color"), matcher.group("total")};
                                }
                                throw new IllegalStateException("cannot parse set of cubes");
                            })
                            .collect(Collectors.toMap(a -> a[0], a -> Integer.valueOf(a[1])));
                    return new GameRecord.SetOfCube(colorAndTotalCubes.getOrDefault("red", 0), colorAndTotalCubes.getOrDefault("green", 0), colorAndTotalCubes.getOrDefault("blue", 0));
                }).toList();
        return new GameRecord(id, setOfCubes);
    }

    private int getGameId(String line) {
        try {
            String gameId = line.substring(0, line.indexOf(":"));
            return Integer.parseInt(gameId.substring("Game ".length()));
        } catch (Exception e) {
            throw new IllegalStateException("cannot parse game id");
        }
    }
}
