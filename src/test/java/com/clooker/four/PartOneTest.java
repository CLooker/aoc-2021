package com.clooker.four;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartOneTest {

  @Test
  void easy() {
    assertEquals(4512, new PartOne("inputs/four_easy.txt").get());
  }

  @Test
  void hard() {
    assertEquals(67716, new PartOne("inputs/four_hard.txt").get());
  }
}
