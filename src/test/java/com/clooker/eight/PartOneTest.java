package com.clooker.eight;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PartOneTest {

  @Test
  void easy() {
    assertEquals(26L, new PartOne("inputs/eight_easy.txt").get());
  }

  @Test
  void hard() {
    assertEquals(278L, new PartOne("inputs/eight_hard.txt").get());
  }
}
