package com.clooker.four.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Board {

  private final List<List<Cell>> board;

  public Board(List<String> input) {
    this.board = parseInput(input);
  }

  private static List<List<Cell>> parseInput(List<String> input) {
    if (input.size() != 5) {
      throw new IllegalStateException("input must be 5 lines");
    }

    List<List<Cell>> data = new ArrayList<>();
    for (String line : input) {
      List<Cell> cells = new ArrayList<>();
      for (String item : line.split(" ")) {
        if (item.isEmpty()) {
          continue;
        }
        Integer value = Integer.parseInt(item);
        Cell cell = new Cell(value, false);
        cells.add(cell);
      }
      data.add(cells);
    }

    return data;
  }

  public Optional<Integer> getWinningScore(int drawn) {
    board.forEach(
        cells ->
            cells.stream()
                .filter(cell -> cell.getValue() == drawn)
                .forEach(cell -> cell.setMarked(true)));

    if (!isWinner()) {
      return Optional.empty();
    }

    int unmarkedSum =
        board.stream()
            .map(
                cells ->
                    cells.stream()
                        .filter(cell -> !cell.getMarked())
                        .map(Cell::getValue)
                        .reduce(0, Integer::sum))
            .reduce(0, Integer::sum);

    return Optional.of(unmarkedSum * drawn);
  }

  private boolean isWinner() {
    for (List<Cell> cells : board) {
      boolean isHorizontalWinner = cells.stream().allMatch(Cell::getMarked);
      if (isHorizontalWinner) {
        return true;
      }
    }

    for (int i = 0; i < board.get(0).size(); i++) {
      List<Cell> vertical = new ArrayList<>();
      for (List<Cell> cells : board) {
        vertical.add(cells.get(i));
      }
      boolean isVerticalWinner = vertical.stream().allMatch(Cell::getMarked);
      if (isVerticalWinner) {
        return true;
      }
    }

    return false;
  }
}
