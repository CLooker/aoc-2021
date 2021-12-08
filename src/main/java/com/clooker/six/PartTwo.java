package com.clooker.six;

import com.clooker.Solution;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

class PartTwo extends Solution {

  public PartTwo(String inputFile) {
    super(inputFile);
  }

  @Override
  public Number get() {
    Map<Integer, Long> freqByTimer = initFreqByTimer();

    for (int day = 0; day < 256; day++) {
      Map<Integer, Long> nextFreqByTimer = new ConcurrentHashMap<>();

      for (int timer : freqByTimer.keySet()) {
        if (timer != 0) {
          nextFreqByTimer.put(timer - 1, freqByTimer.get(timer));
        }
      }

      Optional.ofNullable(freqByTimer.get(0))
          .ifPresent(
              freq -> {
                nextFreqByTimer.merge(6, freq, Long::sum);
                nextFreqByTimer.merge(8, freq, Long::sum);
              });

      freqByTimer = nextFreqByTimer;
    }

    return freqByTimer.values().stream().reduce(0L, Long::sum);
  }

  private Map<Integer, Long> initFreqByTimer() {
    Map<Integer, Long> freqByTimer = new ConcurrentHashMap<>();
    String timersStr = readInputFile().collect(Collectors.toList()).get(0);
    List<Integer> timers =
        Arrays.stream(timersStr.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    timers.forEach(timer -> freqByTimer.merge(timer, 1L, Long::sum));
    return freqByTimer;
  }
}
