package com.clooker.one;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class PartTwo extends SolutionOne {

  PartTwo(String inputFile) {
    super(inputFile);
  }

  @Override
  List<Integer> getDepths() {
    List<Integer> depths = new PartOne(inputFile).getDepths();

    List<List<Integer>> windows = new ArrayList<>();
    for (int i = 0; i < depths.size() - 2; i++) {
      List<Integer> window = new ArrayList<>();
      for (int j = i; j < i + 3; j++) {
        window.add(depths.get(j));
      }
      windows.add(window);
    }

    return windows.stream()
        .map(window -> window.stream().reduce(0, Integer::sum))
        .collect(Collectors.toList());
  }
}
