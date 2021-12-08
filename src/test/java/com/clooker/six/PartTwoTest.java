package com.clooker.six;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PartTwoTest {

  @Test
  void easy() {
    assertEquals(26984457539L, new PartTwo("inputs/six_easy.txt").get());
  }

  @Test
  void hard() {
    assertEquals(1650309278600L, new PartTwo("inputs/six_hard.txt").get());
  }
}