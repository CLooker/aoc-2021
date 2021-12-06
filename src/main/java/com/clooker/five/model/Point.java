package com.clooker.five.model;

import lombok.Value;

@Value
public class Point {

  int x;
  int y;

  public Point(String coordinate) {
    if (!coordinate.contains(",")) {
      throw new IllegalArgumentException("invalid format: missing ,");
    }
    String[] xAndY = coordinate.split(",");
    this.x = Integer.parseInt(xAndY[0].trim());
    this.y = Integer.parseInt(xAndY[1].trim());
  }

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
