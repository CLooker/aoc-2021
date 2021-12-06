package com.clooker.four;

import com.clooker.Solution;
import com.clooker.four.model.Board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

abstract class SolutionFour extends Solution {
  public SolutionFour(String inputFile) {
    super(inputFile);
  }

  protected List<Board> getBoards() {
    List<String> boardInputs =
        readInputFile().skip(1).filter(line -> !line.isEmpty()).collect(Collectors.toList());

    List<Board> boards = new ArrayList<>();
    for (int i = 0; i < boardInputs.size(); i += 5) {
      List<String> boardInput = boardInputs.subList(i, i + 5);
      Board board = new Board(boardInput);
      boards.add(board);
    }
    return boards;
  }

  protected List<Integer> getDrawn() {
    String[] drawnStrs = readInputFile().collect(Collectors.toList()).get(0).split(",");
    return Arrays.stream(drawnStrs).map(Integer::parseInt).collect(Collectors.toList());
  }
}
