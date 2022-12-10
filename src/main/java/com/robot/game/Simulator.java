package com.robot.game;

import com.robot.exception.InvalidGameRobotException;
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
        String[] commandArrays = commandLine.split(" ");
        String output = "";
        try {
            Command command = Command.valueOf(commandArrays[0]);
            if (command == Command.PLACE) {
                placeCommand(commandArrays[1]);
            } else {
                otherCommand(command);
            }
        } catch (IllegalArgumentException ex) {
            throw new InvalidGameRobotException("Please enter valid command");
        }
        return output;
    }
    private void placeCommand(String commands){
        int xValue = 0;
        int yValue = 0;
        String[] commandPositionArrays = commands.split(",");
        try {
            xValue = Integer.valueOf(commandPositionArrays[0]);
            yValue = Integer.valueOf(commandPositionArrays[1]);
        } catch (Exception ex) {
            throw new InvalidGameRobotException("Please only enter numbers");
        }
        //Direction and position assigning

    }
    private String otherCommand(Command currentCommand){
        return null;
    }
}
