package com.clooker.four.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cell {

  Integer value;
  Boolean marked;
}
