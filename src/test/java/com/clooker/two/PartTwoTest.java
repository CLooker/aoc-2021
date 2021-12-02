package com.clooker.two;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class PartTwoTest {

  @Test
  void easy() {
    assertEquals(900, new PartTwo("inputs/two_easy.txt").get());
  }

  @Test
  void hard() {
    assertEquals(1982495697, new PartTwo("inputs/two_hard.txt").get());
  }
}
