package com.robot.game;

import com.robot.exception.InvalidGameRobotException;
import com.robot.utility.Command;
import com.robot.utility.Direction;
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
        Direction direction = Direction.getDirection(commandPositionArrays[2]);
        Position position = new Position(xValue,yValue,direction);
        robot.placeRobot(position,mapTable);
    }

    private String otherCommand(Command currentCommand) {
        String output = "";
        //Todo validate command position is not null
        //Todo validate other command is not null
        switch (currentCommand) {
            case MOVE:
                robot.move();
                break;
            case LEFT:
                robot.turnLeft();
                break;
            case RIGHT:
                robot.turnRight();
                break;
            case REPORT:
                output = robot.reportPosition();
                break;
        }
        return output;
    }

}
