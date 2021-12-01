package com.clooker.one;

import com.clooker.Solution;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
class PartTwo extends Solution {

  public PartTwo(String inputFile) {
    super(inputFile);
  }

  @Override
  public Number get() {
    List<Integer> depths = readInputFile().map(Integer::parseInt).collect(Collectors.toList());

    List<List<Integer>> windows = new ArrayList<>();
    for (int i = 0; i < depths.size() - 2; i++) {
      List<Integer> window = new ArrayList<>();
      for (int j = i; j < i + 3; j++) {
        window.add(depths.get(j));
      }
      windows.add(window);
    }

    int increaseCount = 0;
    for (int i = 1; i < windows.size(); i++) {
      List<Integer> prevWindow = windows.get(i - 1);
      int prevWindowDepth = prevWindow.stream().reduce(0, Integer::sum);

      List<Integer> window = windows.get(i);
      int windowDepth = window.stream().reduce(0, Integer::sum);

      if (windowDepth > prevWindowDepth) {
        increaseCount++;
      }
    }

    return increaseCount;
  }
}
