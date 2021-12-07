package com.clooker.six;

import com.clooker.Solution;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

class PartTwo extends Solution {

  public PartTwo(String inputFile) {
    super(inputFile);
  }

  @Override
  public Number get() {
    Map<Integer, Long> freqByTimer = new HashMap<>();

    String timersStr = readInputFile().collect(Collectors.toList()).get(0);
    List<Integer> timers =
        Arrays.stream(timersStr.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    timers.forEach(timer -> freqByTimer.merge(timer, 1L, Long::sum));

    for (int day = 0; day < 256; day++) {
      for (int timer :
          freqByTimer.keySet().stream()
              .sorted(Comparator.naturalOrder())
              .collect(Collectors.toList())) {

      }
    }

    return freqByTimer.values().stream().reduce(0L, Long::sum);
  }
}
