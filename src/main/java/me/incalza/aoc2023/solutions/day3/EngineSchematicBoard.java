package me.incalza.aoc2023.solutions.day3;

import me.incalza.aoc2023.solutions.InputReader;
import me.incalza.aoc2023.solutions.LineParser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

import static java.util.function.Predicate.not;
import static java.util.stream.IntStream.range;
import static java.util.stream.IntStream.rangeClosed;
import static java.util.stream.Stream.of;

public class EngineSchematicBoard {


    private static final int MAX_COLUMNS = 10;
    private final Cell[][] cells;

    public EngineSchematicBoard(InputReader inputReader) {
        List<String> list = inputReader.read();
        this.cells = new Cell[list.size()][MAX_COLUMNS];
        LineParser<char[]> rowLineParser = String::toCharArray;
        IntStream.range(0, list.size())
                .forEachOrdered(rowIdx -> {
                    char[] columns = rowLineParser.parse(list.get(rowIdx));
                    range(0, columns.length).forEachOrdered(colIdx -> addCell(new Cell(rowIdx, colIdx, columns[colIdx])));
                });
    }

    public Cell getCell(int row, int col) {
        try {
            assertOnRowAndColIdx(row, col);
            return this.cells[row - 1][col - 1];
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Cell not found row [%s] col [%s]".formatted(row, col));
        }
    }


//    The engine schematic (your puzzle input)
//    consists of a visual representation of the engine.
//    There are lots of numbers and symbols you don't really understand,
//    but apparently any number adjacent to a symbol, even diagonally,
//    is a "part number" and should be included in your sum.
//    (Periods (.) do not count as a symbol.)
//
//    Here is an example engine schematic:
//            467..114..
//            ...*......
//            ..35..633.
//            ......#...
//            617*......
//            .....+.58.
//            ..592.....
//            ......755.
//            ...$.*....
//            .664.598..
//    In this schematic,
//    two numbers are not part numbers because they are not adjacent to a symbol:
//    114 (top right) and 58 (middle right).
//    Every other number is adjacent to a symbol and so is a part number; their sum is 4361.

    public int getTotalPartNumber() {
        List<Integer> partNumbers = new ArrayList<>();

        rangeClosed(1, getTotalRows())
                .forEachOrdered(row ->
                {
                    var number = new StringBuilder();
                    rangeClosed(1, getTotalColumns())
                            .forEachOrdered(col -> {
                                Cell cell = getCell(row, col);
                                if ( cell.isDigit() ) {
                                    number.append(cell);
                                } else {
                                    number.append(",");
                                }
                            });
                    System.out.println(number);
                    of(number.toString().split(","))
                            .filter(not(String::isEmpty))
                            .mapToInt(Integer::valueOf)
                            .forEachOrdered(partNumbers::add);
                });
        return partNumbers.stream().mapToInt(v -> v).sum();
    }

    private boolean isNeighborAPartNumber(int rowIdx, int colIdx) {
        assertOnRowAndColIdx(rowIdx, colIdx);
        boolean left = isPartNumber(rowIdx, colIdx - 1);
        boolean right = isPartNumber(rowIdx, colIdx + 1);
        boolean center = isPartNumber(rowIdx, colIdx);
//        boolean top = false;
//        if (rowIdx > 1 || rowIdx <= getTotalRows()) {
//            boolean topLeft = isPartNumber(rowIdx - 1, colIdx - 1);
            boolean topRight = isPartNumber(rowIdx - 1, colIdx + 1);
            boolean top = isPartNumber(rowIdx - 1, colIdx) /* || topLeft */ || topRight;
//        }
//         bottom = false;
//        if (colIdx > 1 || colIdx < getTotalColumns()) {
            boolean bottomLeft = isPartNumber(rowIdx + 1, colIdx - 1);
//            boolean bottomRight = isPartNumber(rowIdx + 1, colIdx + 1);
            boolean bottom = isPartNumber(rowIdx + 1, colIdx)  || bottomLeft /*|| bottomRight */ ;
//        }
        return center && (colIdx == 1 || left) && ( left || right || top /*|| topLeft*/ || bottom);
    }

    private boolean isPartNumber(int rowIdx, int colIdx) {
        try {
            return getCell(rowIdx, colIdx).isPartNumber();
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private void addCell(Cell cell) {
        this.cells[cell.row()][cell.column()] = cell;
    }

    public int getTotalRows() {
        return this.cells.length;
    }

    public int getTotalColumns() {
        return MAX_COLUMNS;
    }

    private void assertOnRowAndColIdx(int row, int col) {
        if (row < 1 || col < 1) {
            throw new IllegalArgumentException("Row or Col cannot be less or equal then 0 or, use index > 0");
        }
    }

    public record Cell(int row, int column, char value) {
        public boolean isPartNumber() {
            return value != '.';
        }

        public boolean isDigit() {
            return Character.isDigit(value);
        }

        @Override
        public String toString() {
            return Character.toString(value);
        }
    }

}
