package com.clooker.one;

import com.clooker.Solution;

import java.util.List;
import java.util.stream.Collectors;

class PartOne extends Solution {

  public PartOne(String inputFile) {
    super(inputFile);
  }

  @Override
  public Number get() {
    List<Integer> depths = readInputFile()
            .map(Integer::parseInt)
            .collect(Collectors.toList());

    int increaseCount = 0;
    for (int i = 1; i < depths.size(); i++) {
      int prevDepth = depths.get(i - 1);
      int depth = depths.get(i);
      if (depth > prevDepth) {
        increaseCount++;
      }
    }

    return increaseCount;
  }
}
