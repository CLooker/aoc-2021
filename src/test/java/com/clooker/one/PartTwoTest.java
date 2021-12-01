package com.clooker.one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartTwoTest {

  @Test
  void easy() {
    assertEquals(
            5,
            new PartTwo("inputs/one_easy.txt").get()
    );
  }

  @Test
  void hard() {
    assertEquals(
            1150,
            new PartTwo("inputs/one_hard.txt").get()
    );
  }
}
