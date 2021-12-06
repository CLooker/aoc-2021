package com.clooker.four;

import com.clooker.four.model.Board;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Objects.nonNull;

class PartTwo extends SolutionFour {

  public PartTwo(String inputFile) {
    super(inputFile);
  }

  @Override
  public Number get() {
    List<Board> boards = getBoards();
    Set<Board> winningBoards = new HashSet<>();
    int lastWinningScore = -1;

    for (int n : getDrawn()) {
      for (Board board : boards) {
        if (winningBoards.contains(board)) {
          continue;
        }

        Integer winningScore = board.getWinningScore(n).orElse(null);
        if (nonNull(winningScore)) {
          winningBoards.add(board);
          lastWinningScore = winningScore;
        }
      }
    }

    return lastWinningScore;
  }
}
