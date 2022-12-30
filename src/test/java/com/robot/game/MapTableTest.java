package com.robot.game;

import com.robot.utility.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapTableTest {

    private MapTable mapTable;

    @BeforeEach
    void setup() {
        mapTable = new MapTable(5,5);
    }

    @Test
    public void testValidPositionRangeReturnTrue() {
        Position validPos = new Position(1, 1, Direction.EAST);
        boolean result = mapTable.isValidatePosition(validPos);
        assertTrue(result);
    }

    @ParameterizedTest
    @MethodSource("invalidPositionRange")
    public void testInvalidPositionRangeReturnFalse(int xTestPos, int yTestPos) {
        Position validPos = new Position(xTestPos, yTestPos, Direction.EAST);
        boolean result = mapTable.isValidatePosition(validPos);
        assertFalse(result);
    }

    private static Stream<Arguments> invalidPositionRange() {
        return Stream.of(
                Arguments.of(-1, 1),
                Arguments.of(1, -1),
                Arguments.of(7, 1),
                Arguments.of(1, 7)
        );
    }
}
