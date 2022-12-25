package com.robot.utility;

import com.robot.exception.InvalidGameRobotException;
import com.robot.game.MapTable;
import com.robot.game.Robot;
import com.robot.game.Simulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GameCommandReader {

    private Simulator initSimulator() {
        return new Simulator(new MapTable(5,5), new Robot());
    }
    public List<String> processFile(File fileName) throws FileNotFoundException {
        if (fileName == null) {
            throw new InvalidGameRobotException("File is not found");
        }
        return readFile(fileName);
    }

    private List<String> readFile(File file) throws FileNotFoundException {
        List<String> resultList = new LinkedList<>();
        try (Scanner fileScanner = new Scanner(file)){
            Simulator simulator = initSimulator();
            String output="";
            String currentLine="";
            while (fileScanner.hasNext()) {
                currentLine = fileScanner.nextLine();
                output = simulator.executeCommand(currentLine);
                if(currentLine.equalsIgnoreCase("REPORT")){
                    resultList.add(output);
                }
            }
        }
        return resultList;
    }
}
