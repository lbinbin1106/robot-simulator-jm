package com.robot.game;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class MapTable {
    private int rowPosition;
    private int columnPosition;

    public boolean isValidatePosition(Position initialPosition) {
        int xValue = initialPosition.getXPos();
        int yValue = initialPosition.getYPos();
        if (xValue < 0 || xValue > rowPosition || yValue < 0 || yValue > columnPosition) {
            return false;
        }
        return true;
    }
}
