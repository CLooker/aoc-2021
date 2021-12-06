package com.clooker.five;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartOneTest {

  @Test
  void easy() {
    assertEquals(5L, new PartOne("inputs/five_easy.txt").get());
  }

  @Test
  void hard() {
    assertEquals(5280L, new PartOne("inputs/five_hard.txt").get());
  }
}
