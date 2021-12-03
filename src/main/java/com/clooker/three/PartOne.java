package com.clooker.three;

import com.clooker.Solution;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class PartOne extends Solution {

  protected PartOne(String inputFile) {
    super(inputFile);
  }

  @Override
  public Number get() {
    return getGammaRate() * getEpsilonRate();
  }

  private int getGammaRate() {
    return processInput(
        freqByDigit ->
            freqByDigit.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow()
                .getKey());
  }

  private int getEpsilonRate() {
    return processInput(
        freqByDigit ->
            freqByDigit.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .orElseThrow()
                .getKey());
  }

  private int processInput(Function<Map<Integer, Integer>, Integer> freqByDigitReducer) {
    List<String> binaryStrings = readInputFile().collect(Collectors.toList());

    int bStringLength = binaryStrings.get(0).length();

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < bStringLength; i++) {
      Map<Integer, Integer> freqByDigit = new HashMap<>();
      for (String bString : binaryStrings) {
        char ch = bString.charAt(i);
        int digit = Character.getNumericValue(ch);
        freqByDigit.merge(digit, 1, Integer::sum);
      }
      result.append(freqByDigitReducer.apply(freqByDigit));
    }

    return Integer.parseInt(result.toString(), 2);
  }
}
