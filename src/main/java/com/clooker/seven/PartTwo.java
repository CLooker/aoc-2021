package com.clooker.seven;

import com.clooker.Solution;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class PartTwo extends Solution {

  public PartTwo(String inputFile) {
    super(inputFile);
  }

  @Override
  public Number get() {
    String positionsStr = readInputFile().collect(Collectors.toList()).get(0);
    List<Integer> initialPositions =
        Arrays.stream(positionsStr.split(",")).map(Integer::parseInt).collect(Collectors.toList());

    int minPos = initialPositions.stream().min(Integer::compareTo).orElseThrow();
    int maxPos = initialPositions.stream().max(Integer::compareTo).orElseThrow();
    List<Integer> positions =
        IntStream.range(minPos, maxPos + 1).boxed().collect(Collectors.toList());

    int fuelUsageMin = Integer.MAX_VALUE;
    for (int position : positions) {
      int fuelUsage = 0;
      for (int p : initialPositions) {
        for (int f = 1; f <= Math.abs(position - p); f++) {
          fuelUsage += f;
        }
      }
      fuelUsageMin = Math.min(fuelUsageMin, fuelUsage);
    }

    return fuelUsageMin;
  }
}
