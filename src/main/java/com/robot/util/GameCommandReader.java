package com.robot.util;

import com.robot.exception.InvalidGameRobotException;
import com.robot.exceptions.InvalidRobotException;

import java.io.File;
import java.util.List;

public class GameCommandReader {
    public List<String> processFile(File fileName){
        //validate whether file is readable
        validateFile(fileName);
        return null; //todo change logic
    }
    private void validateFile(File file){
        if (file == null) {
            throw new InvalidGameRobotException("File is not found");
        }
        if (!file.exists()) {
            throw new InvalidGameRobotException("File is not exist");
        }
    }
}
