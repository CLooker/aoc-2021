package com.clooker.four;

import com.clooker.four.model.Board;

import java.util.List;

import static java.util.Objects.nonNull;

class PartOne extends SolutionFour {

  public PartOne(String inputFile) {
    super(inputFile);
  }

  @Override
  public Number get() {
    List<Board> boards = getBoards();
    for (int n : getDrawn()) {
      for (Board board : boards) {
        Integer winningScore = board.getWinningScore(n).orElse(null);
        if (nonNull(winningScore)) {
          return winningScore;
        }
      }
    }
    return -1;
  }
}
