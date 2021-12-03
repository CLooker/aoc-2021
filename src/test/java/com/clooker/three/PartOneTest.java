package com.clooker.three;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartOneTest {

  @Test
  void easy() {
    assertEquals(198, new PartOne("inputs/three_easy.txt").get());
  }

  @Test
  void hard() {
    assertEquals(3923414, new PartOne("inputs/three_hard.txt").get());
  }
}
