package com.clooker.five;

import com.clooker.Solution;
import com.clooker.five.model.Point;

import java.util.HashMap;
import java.util.Map;

class PartTwo extends Solution {

  public PartTwo(String inputFile) {
    super(inputFile);
  }

  @Override
  public Number get() {
    Map<Point, Integer> freqByPoint = new HashMap<>();

    readInputFile()
        .forEach(
            line -> {
              String delimiter = "->";
              String[] coordinatesPair = line.split(delimiter);
              Point startPoint = new Point(coordinatesPair[0]);
              Point endPoint = new Point(coordinatesPair[1]);

              boolean xsMatch = startPoint.getX() == endPoint.getX();
              boolean ysMatch = startPoint.getY() == endPoint.getY();

              if (!xsMatch && !ysMatch) {
                int x = startPoint.getX();
                int y = startPoint.getY();

                while (true) {
                  boolean shouldContinue =
                      (startPoint.getX() < endPoint.getX()
                              ? x <= endPoint.getX()
                              : x >= startPoint.getX())
                          || (startPoint.getY() < endPoint.getY()
                              ? y <= endPoint.getY()
                              : y >= startPoint.getY());

                  if (!shouldContinue) {
                    break;
                  }

                  Point point = new Point(x, y);

                  freqByPoint.merge(point, 1, Integer::sum);

                  if (startPoint.getX() < endPoint.getX()) {
                    x++;
                  } else {
                    x--;
                  }

                  if (startPoint.getY() < endPoint.getY()) {
                    y++;
                  } else {
                    y--;
                  }
                }
              } else {
                int start =
                    xsMatch
                        ? Math.min(startPoint.getY(), endPoint.getY())
                        : Math.min(startPoint.getX(), endPoint.getX());

                int end =
                    xsMatch
                        ? Math.max(startPoint.getY(), endPoint.getY())
                        : Math.max(startPoint.getX(), endPoint.getX());

                for (int i = start; i <= end; i++) {
                  Point point =
                      xsMatch ? new Point(startPoint.getX(), i) : new Point(i, startPoint.getY());

                  freqByPoint.merge(point, 1, Integer::sum);
                }
              }
            });

    return freqByPoint.values().stream().filter(freq -> freq >= 2).count();
  }
}
