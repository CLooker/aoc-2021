package com.clooker.six;

import com.clooker.Solution;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class PartOne extends Solution {

  public PartOne(String inputFile) {
    super(inputFile);
  }

  @Override
  public Number get() {
    String timersStr = readInputFile().collect(Collectors.toList()).get(0);
    List<Integer> timers =
        Arrays.stream(timersStr.split(",")).map(Integer::parseInt).collect(Collectors.toList());

    for (int day = 0; day < 80; day++) {
      List<Integer> newTimers = new ArrayList<>();
      for (int timerIdx = 0; timerIdx < timers.size(); timerIdx++) {
        int timer = timers.get(timerIdx);
        if (timer == 0) {
          timers.set(timerIdx, 6);
          newTimers.add(8);
        } else {
          timers.set(timerIdx, timer - 1);
        }
      }
      timers.addAll(newTimers);
    }

    return timers.size();
  }
}
