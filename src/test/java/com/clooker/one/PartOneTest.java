package com.clooker.one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartOneTest {

  @Test
  void easy() {
    assertEquals(7L, new PartOne("inputs/one_easy.txt").get());
  }

  @Test
  void hard() {
    assertEquals(1215L, new PartOne("inputs/one_hard.txt").get());
  }
}
