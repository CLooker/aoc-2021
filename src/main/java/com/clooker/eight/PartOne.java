package com.clooker.eight;

import com.clooker.Solution;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class PartOne extends Solution {

  public PartOne(String inputFile) {
    super(inputFile);
  }

  @Override
  public Number get() {
    return readInputFile()
        .map(
            line ->
                Arrays.stream(line.substring(line.indexOf("|") + 2).split(" "))
                    .map(String::length)
                    .filter(l -> List.of(2, 3, 4, 7).contains(l))
                    .count())
        .reduce(0L, Long::sum);
  }
}
