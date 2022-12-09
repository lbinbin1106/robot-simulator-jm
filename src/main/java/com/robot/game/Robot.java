package com.robot.game;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Robot {
    //todo pass movement to position
    private Position position;

    public void move() {

    }
    public void turnLeft() {

    }
    public void turnRight() {

    }
    public void placeRobot(Position initialPosition, MapTable maptable) {

    }
    public String reportPosition() {
        return position.toString();
    }
}
