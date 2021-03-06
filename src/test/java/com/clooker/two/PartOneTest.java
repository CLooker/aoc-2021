package com.clooker.two;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartOneTest {

  @Test
  void easy() {
    assertEquals(150, new PartOne("inputs/two_easy.txt").get());
  }

  @Test
  void hard() {
    assertEquals(1924923, new PartOne("inputs/two_hard.txt").get());
  }
}
