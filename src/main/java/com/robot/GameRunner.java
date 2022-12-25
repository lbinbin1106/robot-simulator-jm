package com.robot;

import com.robot.utility.GameCommandReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.util.List;

public class GameRunner {
    private static Logger LOGGER = LoggerFactory.getLogger(GameCommandReader.class);
    public static void main(String[] args) {
        try {
            GameCommandReader commandReader = new GameCommandReader();
            if(args.length == 1 && !args[0].isEmpty()){
                printResult(commandReader.processFile(new File(args[0])));
            } else {
                LOGGER.error("Please run command with proper argument");
            }
        } catch (Exception ex) {
            LOGGER.error("Process throw exception {}", ex);
        }
    }

    private static void printResult(List<String> result) {
        result.stream().forEach(re -> {
            LOGGER.info("Report result {}", re);
        });
    }
}
