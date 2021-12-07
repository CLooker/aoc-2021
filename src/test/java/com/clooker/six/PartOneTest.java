package com.clooker.six;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PartOneTest {

  @Test
  void easy() {
    assertEquals(5934, new PartOne("inputs/six_easy.txt").get());
  }

  @Test
  void hard() {
    assertEquals(365131, new PartOne("inputs/six_hard.txt").get());
  }
}