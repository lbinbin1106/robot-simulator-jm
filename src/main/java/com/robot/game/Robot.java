package com.robot.game;

import com.robot.exception.InvalidGameRobotException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Robot {
    private Position position;

    public void move() {
    // todo update position (x,y) based on command
    }
    public void turnLeft() {
    // todo update direction (turnleft)

    }
    public void turnRight() {
    // todo update direction (turnright)

    }
    public void placeRobot(Position initialPosition, MapTable mapTable) {
        if (mapTable == null) {
            throw new InvalidGameRobotException("Maptable not found");
        }
        if (initialPosition == null) {
            throw new InvalidGameRobotException("Robot position not found");
        }
        if (!mapTable.isValidatePosition(initialPosition)) {
            throw new InvalidGameRobotException("Position is invalid");
        }
        initialPosition.setMaxXPos(mapTable.getRowPosition());
        initialPosition.setMaxYPos(mapTable.getColumnPosition());
        setPosition(initialPosition);
    }
    public String reportPosition() {
        return position.toString();
    }
}
