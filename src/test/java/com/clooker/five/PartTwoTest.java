package com.clooker.five;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartTwoTest {

  @Test
  void easy() {
    assertEquals(12L, new PartTwo("inputs/five_easy.txt").get());
  }

  @Test
  void hard() {
    assertEquals(16716L, new PartTwo("inputs/five_hard.txt").get());
  }
}
