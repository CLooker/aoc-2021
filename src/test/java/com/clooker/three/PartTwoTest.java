package com.clooker.three;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartTwoTest {

  @Test
  void easy() {
    assertEquals(230, new PartTwo("inputs/three_easy.txt").get());
  }

  @Test
  void hard() {
    assertEquals(5852595, new PartTwo("inputs/three_hard.txt").get());
  }
}
