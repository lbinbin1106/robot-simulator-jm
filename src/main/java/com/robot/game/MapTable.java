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
    //todo validate initialposition < maxXPosition, >=0
        return true;
    }
}
