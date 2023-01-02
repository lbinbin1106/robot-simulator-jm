package com.robot.game;

import com.robot.utility.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {
    private Position position;
    @BeforeEach
    void setup() {
        position = new Position(1,1, Direction.NORTH);
    }
    @Test
    public void testUpdatePositionXOutofRange() {
        overwritePosAttributes(5,5,5,5);
        position.updatePosition(1,0);
        assertEquals(5,position.getXPos());
        assertEquals(5,position.getYPos());

        overwritePosAttributes(0,0,5,5);
        position.updatePosition(-1,0);
        assertEquals(0,position.getXPos());
        assertEquals(0,position.getYPos());
    }
    @Test
    public void testUpdatePositionYOutofRange() {
        overwritePosAttributes(5,5,5,5);
        position.updatePosition(0,1);
        assertEquals(5,position.getXPos());
        assertEquals(5,position.getYPos());

        overwritePosAttributes(0,0,5,5);
        position.updatePosition(0,-1);
        assertEquals(0,position.getXPos());
        assertEquals(0,position.getYPos());
    }
    @Test
    public void testUpdatePositionXYWithinRange() {
        overwritePosAttributes(2,2,5,5);
        position.updatePosition(1,0);
        assertEquals(3,position.getXPos());
        assertEquals(2,position.getYPos());

        position.updatePosition(0,1);
        assertEquals(3,position.getXPos());
        assertEquals(3,position.getYPos());

    }
    @Test
     public void testToString() {
        assertEquals(position.toString(),"1,1,NORTH");
    }

    private void overwritePosAttributes(int xPos, int yPos, int maxXPos, int maxYPos) {
        position.setXPos(xPos);
        position.setYPos(yPos);
        position.setMaxXPos(maxXPos);
        position.setMaxYPos(maxYPos);
    }
}
