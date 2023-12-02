package me.incalza.aoc2023.days._2;

import java.util.LinkedList;
import java.util.List;

public class GameRecord {
    private final int id;
    private final List<SetOfCube> setOfCubes = new LinkedList<>();

    public GameRecord(int id, List<SetOfCube> setOfCubes) {
        this.id = id;
        this.setOfCubes.addAll(setOfCubes);
    }

    public int getId() {
        return id;
    }

    public boolean hasRedCubesGreatThant(int max) {
        return setOfCubes.stream().anyMatch(v -> v.redCube() > max);
    }

    public boolean hasGreenCubesGreatThant(int max) {
        return setOfCubes.stream().anyMatch(v -> v.greenCube() > max);
    }

    public boolean hasBlueCubesGreatThant(int max) {
        return setOfCubes.stream().anyMatch(v -> v.blueCube() > max);
    }

    public SetOfCube getPossibleConfiguration() {
        int maxRed = setOfCubes.stream().mapToInt(SetOfCube::redCube).max().getAsInt();
        int maxGreen = setOfCubes.stream().mapToInt(SetOfCube::greenCube).max().getAsInt();
        int maxBlue = setOfCubes.stream().mapToInt(SetOfCube::blueCube).max().getAsInt();
        return new SetOfCube(maxRed, maxGreen, maxBlue);
    }

    public List<SetOfCube> getSetOfCubes() {
        return setOfCubes;
    }

    public int getPower() {
        SetOfCube config = getPossibleConfiguration();
        return config.redCube() * config.greenCube() * config.blueCube();
    }

    public record SetOfCube(int redCube, int greenCube, int blueCube) {
    }

}
