package com.robot.utility;

import com.robot.exception.InvalidGameRobotException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GameCommandReader {

    private static Logger LOGGER = LoggerFactory.getLogger(GameCommandReader.class);
    public List<String> processFile(File fileName) throws FileNotFoundException {
        if (fileName == null) {
            throw new InvalidGameRobotException("File is not found");
        }
        readFile(fileName);
        return null; //todo change logic
    }

    private List<String> readFile(File file) throws FileNotFoundException {
        List<String> resultList = new LinkedList<>();
        try (Scanner fileScanner = new Scanner(file)){
            while (fileScanner.hasNext()) {
                LOGGER.info("result = " + fileScanner.nextLine());
            }
        }
        return resultList;
    }
}
