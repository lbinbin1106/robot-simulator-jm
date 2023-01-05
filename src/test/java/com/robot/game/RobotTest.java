package com.robot.game;

import com.robot.exception.InvalidGameRobotException;
import com.robot.utility.Direction;
import com.robot.utility.GameCommandReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class RobotTest {
    private Robot robot;

    private MapTable mapTable;
    @BeforeEach
    void setup() {
        robot = new Robot();
        mapTable = new MapTable(5,5);
    }

    @Test
    public void testPlaceRobotWithNullMaptableNull() {
        Exception exception = assertThrows(InvalidGameRobotException.class, ()->robot.placeRobot(new Position(1,1, Direction.EAST), null));
        assertEquals("Maptable not found", exception.getMessage());
    }
    @Test
    public void testPlaceRobotWithInitialPositionNull() {
        Exception exception = assertThrows(InvalidGameRobotException.class, ()->robot.placeRobot(null,mapTable));
        assertEquals("Robot position not found", exception.getMessage());
    }
    @Test
    public void testPlaceRobotWithInvalidInitialPosition() {
        Exception exception = assertThrows(InvalidGameRobotException.class, ()->robot.placeRobot(new Position(6,6,Direction.EAST),mapTable));
        assertEquals("Position is invalid", exception.getMessage());
    }
    @Test
    public void testPlaceRobotWithValidInitialPositionAndMaptable() {
        assertDoesNotThrow(()->robot.placeRobot(new Position(1,1,Direction.EAST),mapTable));
        assertEquals(robot.getPosition().getXPos(),1);
        assertEquals(robot.getPosition().getYPos(),1);
        assertEquals(robot.getPosition().getDirection(), Direction.EAST);
        assertEquals(robot.getPosition().getMaxXPos(),5);
        assertEquals(robot.getPosition().getMaxYPos(),5);
    }

    @ParameterizedTest
    @MethodSource("testValidPosition")
    public void testMoveReturnValidPosition(int xReturnPos,int yReturnPos,Direction returnDirection, Direction initDirection) {
        robot.placeRobot(new Position(1,1, initDirection), mapTable);
        robot.move();
        assertEquals(robot.getPosition().getXPos(),xReturnPos);
        assertEquals(robot.getPosition().getYPos(),yReturnPos);
        assertEquals(robot.getPosition().getDirection(),returnDirection);
    }
    private static Stream<Arguments> testValidPosition() {
        return Stream.of(
                Arguments.of(1, 2, Direction.NORTH, Direction.NORTH),
                Arguments.of(2, 1, Direction.EAST, Direction.EAST),
                Arguments.of(0, 1, Direction.WEST, Direction.WEST),
                Arguments.of(1, 0, Direction.SOUTH, Direction.SOUTH)
        );
    }
}
