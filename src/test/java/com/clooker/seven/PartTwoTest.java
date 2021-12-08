package com.clooker.seven;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PartTwoTest {

  @Test
  void easy() {
    assertEquals(168, new PartTwo("inputs/seven_easy.txt").get());
  }

  @Test
  void hard() {
    assertEquals(95167302, new PartTwo("inputs/seven_hard.txt").get());
  }
}
