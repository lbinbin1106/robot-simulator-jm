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
    public static Direction getDirection(String commandFacing) {
        for (Direction facing : values()) {
            if (commandFacing.equalsIgnoreCase(facing.getDescription())) {
                return facing;
            }
        }
        return null;
    }
    public Direction changeDirection(int rotatePoint) {
        int resultIndex = ((ordinal() + rotatePoint) + 4) % 4;
        return values()[resultIndex];
    }
}
