package com.robot.game;

import com.robot.exception.InvalidGameRobotException;
import com.robot.utility.Direction;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Robot {
    private Position position;

    public void move() {
        switch (position.getDirection()) {
            case NORTH:
                position.updatePosition(0,1);
                break;
            case SOUTH:
                position.updatePosition(0,-1);
                break;
            case EAST:
                position.updatePosition(1,0);
                break;
            case WEST:
                position.updatePosition(-1,0);
                break;
        }
    }

    public void turnLeft() {
      position.setDirection(position.getDirection().changeDirection(-1));
    }

    public void turnRight() {
      position.setDirection(position.getDirection().changeDirection(1));
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
