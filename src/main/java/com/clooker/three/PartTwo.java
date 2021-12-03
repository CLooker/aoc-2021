package com.clooker.three;

import com.clooker.Solution;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

class PartTwo extends Solution {

  protected PartTwo(String inputFile) {
    super(inputFile);
  }

  @Override
  public Number get() {
    return getOxygenGeneratorRating() * getCO2ScrubberRating();
  }

  private int getOxygenGeneratorRating() {
    return processInputFile(
        freqByDigit ->
            Objects.equals(freqByDigit.get(0), freqByDigit.get(1))
                ? 1
                : freqByDigit.entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .orElseThrow()
                    .getKey());
  }

  private int getCO2ScrubberRating() {
    return processInputFile(
        freqByDigit ->
            Objects.equals(freqByDigit.get(0), freqByDigit.get(1))
                ? 0
                : freqByDigit.entrySet().stream()
                    .min(Map.Entry.comparingByValue())
                    .orElseThrow()
                    .getKey());
  }

  private int processInputFile(Function<Map<Integer, Integer>, Integer> freqByDigitReducer) {
    List<String> bStrings = readInputFile().collect(Collectors.toList());

    AtomicInteger idx = new AtomicInteger(0);
    while (bStrings.size() > 1) {
      Map<Integer, Integer> freqByDigit = new HashMap<>();
      for (String bString : bStrings) {
        char ch = bString.charAt(idx.get());
        int digit = Character.getNumericValue(ch);
        freqByDigit.merge(digit, 1, Integer::sum);
      }

      int digit = freqByDigitReducer.apply(freqByDigit);

      bStrings =
          bStrings.stream()
              .filter(
                  bString -> {
                    char ch = bString.charAt(idx.get());
                    int d = Character.getNumericValue(ch);
                    return digit == d;
                  })
              .collect(Collectors.toList());

      idx.getAndIncrement();
    }

    return Integer.parseInt(bStrings.get(0), 2);
  }
}
