package com.clooker.two;

import com.clooker.Solution;
import com.clooker.two.model.Move;
import com.clooker.two.model.Move.Direction;

import java.util.List;
import java.util.stream.Collectors;

class PartTwo extends Solution {

  protected PartTwo(String inputFile) {
    super(inputFile);
  }

  @Override
  public Number get() {
    List<Move> moves =
        readInputFile()
            .map(
                moveLine -> {
                  String[] split = moveLine.split(" ");
                  return new Move(
                      Direction.valueOf(split[0].toUpperCase()), Integer.parseInt(split[1]));
                })
            .collect(Collectors.toList());

    int xPos = 0;
    int yPos = 0;
    int aim = 0;
    for (Move move : moves) {
      int magnitude = move.getMagnitude();
      switch (move.getDirection()) {
        case UP:
          {
            aim -= magnitude;
            break;
          }
        case DOWN:
          {
            aim += magnitude;
            break;
          }
        case FORWARD:
          {
            xPos += magnitude;
            yPos -= (aim * magnitude);
            break;
          }
        default:
          {
            throw new IllegalStateException();
          }
      }
    }

    return xPos * (-yPos);
  }
}
