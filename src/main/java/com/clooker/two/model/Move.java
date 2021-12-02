package com.clooker.two.model;

import lombok.Value;

@Value
public class Move {

    public enum Direction {
        FORWARD,
        DOWN,
        UP
    }

    Direction direction;
    int magnitude;

}
