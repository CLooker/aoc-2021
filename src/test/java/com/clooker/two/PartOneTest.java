package com.clooker.two;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class PartOneTest {

  @Test
  void easy() {
    assertEquals(150, new PartOne("inputs/two_easy.txt").get());
  }

  @Test
  void hard() {
    assertEquals(1924923, new PartOne("inputs/two_hard.txt").get());
  }
}
