package com.clooker.four;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartTwoTest {

  @Test
  void easy() {
    assertEquals(1924, new PartTwo("inputs/four_easy.txt").get());
  }

  @Test
  void hard() {
    assertEquals(1830, new PartTwo("inputs/four_hard.txt").get());
  }
}
