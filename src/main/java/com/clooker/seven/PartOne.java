package com.clooker.seven;

import com.clooker.Solution;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class PartOne extends Solution {

  public PartOne(String inputFile) {
    super(inputFile);
  }

  @Override
  public Number get() {
    String positionsStr = readInputFile().collect(Collectors.toList()).get(0);
    List<Integer> positions =
        Arrays.stream(positionsStr.split(",")).map(Integer::parseInt).collect(Collectors.toList());

    int fuelUsageMin = Integer.MAX_VALUE;
    for (int position : positions) {
      int fuelUsage = 0;
      for (int p : positions) {
        fuelUsage += Math.abs(position - p);
      }
      fuelUsageMin = Math.min(fuelUsageMin, fuelUsage);
    }

    return fuelUsageMin;
  }
}
