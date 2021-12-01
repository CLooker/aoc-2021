package com.clooker.one;

import java.util.List;
import java.util.stream.Collectors;

class PartOne extends SolutionOne {

  PartOne(String inputFile) {
    super(inputFile);
  }

  @Override
  List<Integer> getDepths() {
    return readInputFile()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
  }
}
