package com.robot.utility;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Direction {
    NORTH("NORTH"),
    EAST("EAST"),
    SOUTH("SOUTH"),
    WEST("WEST");
    private String description;
}
