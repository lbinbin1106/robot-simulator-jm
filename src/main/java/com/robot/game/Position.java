package com.robot.game;

import com.robot.utility.Direction;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Position {
    private int xPos;
    private int yPos;
    private Direction direction;
    public Position(int xPos, int yPos, Direction direction){
        this.xPos = xPos;
        this.yPos = yPos;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return xPos + "," + yPos + "," + direction.getDescription();
    }
    // update position
}
