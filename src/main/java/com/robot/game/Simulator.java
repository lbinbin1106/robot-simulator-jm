package com.robot.game;

import com.robot.utility.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Simulator {
    // pass command to Robot
    private MapTable mapTable;
    private Robot robot;
    public String executeCommand(String commandLine){
       return null;
    }
    private void placeCommand(String commands){

    }
    private String otherCommand(Command currentCommand){
        return null;
    }
}
