package com.clooker.seven;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PartOneTest {

  @Test
  void easy() {
    assertEquals(37, new PartOne("inputs/seven_easy.txt").get());
  }

  @Test
  void hard() {
    assertEquals(336701, new PartOne("inputs/seven_hard.txt").get());
  }
}
