package com.robot.game;

import com.robot.exception.InvalidGameRobotException;
import com.robot.utility.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimulatorTest {
    private Simulator simulator;

    @BeforeEach
    void setup() {
        simulator = new Simulator(new MapTable(5,5), new Robot());
    }

    @Test
    public void testPlaceCommandWithValidKeyWords() {
       simulator.executeCommand("PLACE 1,1,NORTH");
       Position currentPosition = simulator.getRobot().getPosition();
       assertEquals(1, currentPosition.getXPos());
       assertEquals(1, currentPosition.getYPos());
       assertEquals(Direction.NORTH, currentPosition.getDirection());
    }

    @Test
    public void testInvalidPlaceCommand() {
        assertThrows(InvalidGameRobotException.class, ()->simulator.executeCommand("PLC 1,1,NORTH"));
    }

    @Test
    public void testInvalidPlaceCommandWhenPositionNotNumbers() {
        assertThrows(InvalidGameRobotException.class, ()->simulator.executeCommand("PLACE 1,a,NORTH"));
    }

    @Test
    public void testInvalidPlaceCommandWhenPositionOutOfRange() {
        assertThrows(InvalidGameRobotException.class, ()->simulator.executeCommand("PLACE 10,1,NORTH"));
    }

    @Test
    public void testOtherCommandWithValidKeyWords() {
        assertThrows(InvalidGameRobotException.class, ()->simulator.executeCommand("PLACE 10,1,NORTH"));
    }
    @Test
    public void testNullCommand() {
        assertThrows(InvalidGameRobotException.class, ()->simulator.executeCommand(null));
    }
    @Test
    public void testOtherCommandPositionIsNull() {
        simulator.executeCommand("PLACE 1,1,NORTH");
        simulator.getRobot().setPosition(null);
        assertThrows(InvalidGameRobotException.class, ()->simulator.executeCommand("MOVE"));
    }
}
