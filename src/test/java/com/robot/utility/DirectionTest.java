package com.robot.utility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DirectionTest {
    private Direction direction;
    @BeforeEach
    void setup() {
        direction = Direction.EAST;
    }
    @Test
    public void testGetDirectionWithValidCommandReturnFacing() {
        assertEquals(Direction.EAST, Direction.getDirection("EAST"));
        assertEquals(Direction.WEST, Direction.getDirection("WEST"));
        assertEquals(Direction.NORTH, Direction.getDirection("NORTH"));
        assertEquals(Direction.SOUTH, Direction.getDirection("SOUTH"));
    }
    @Test
    public void testGetDirectionWithInvalidCommandReturnNull() {
        assertNull(Direction.getDirection("NORTHEAST"));
    }
    @Test
    public void testTurnLeftWithValidRotatePoint() {
        assertEquals(Direction.NORTH, direction.changeDirection(-1));
    }
    @Test
    public void testTurnRightWithValidRotatePoint() {
        assertEquals(Direction.SOUTH, direction.changeDirection(1));
    }
    @Test
    public void testNoTurnWithInvalidRotatePoint() {
        assertEquals(Direction.EAST, direction.changeDirection(0));
    }
}
