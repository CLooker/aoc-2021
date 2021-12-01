package com.clooker.one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartTwoTest {

  @Test
  void easy() {
    assertEquals(
            5L,
            new PartTwo("inputs/one_easy.txt").get()
    );
  }

  @Test
  void hard() {
    assertEquals(
            1150L,
            new PartTwo("inputs/one_hard.txt").get()
    );
  }
}
