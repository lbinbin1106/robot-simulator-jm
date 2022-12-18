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

    private int maxXPos;
    private int maxYPos;

    public Position(int xPos, int yPos, Direction direction){
        this.xPos = xPos;
        this.yPos = yPos;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return xPos + "," + yPos + "," + direction.getDescription();
    }

    public void updatePosition(int xMovement, int yMovement) {
        if (yMovement == 0) {
            setXPos(getUpdatePos(getXPos(), xMovement, maxXPos));
        }
        if (xMovement == 0) {
            setYPos(getUpdatePos(getYPos(), yMovement, maxYPos));
        }
    }

    private int getUpdatePos(int currentPos, int movement, int maxPos) {
        int updatePos = currentPos + movement;
        if (updatePos > maxPos) {
            updatePos = maxPos;
        }  else if (updatePos < 0) {
            updatePos = 0;
        }
        return updatePos;
    }
}
