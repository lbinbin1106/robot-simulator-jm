package com.robot;

import com.robot.utility.GameCommandReader;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class GameRunner {
    private static Logger LOGGER = LoggerFactory.getLogger(GameRunner.class);
    public static void main(String[] args) {
        try {
            GameCommandReader commandReader = new GameCommandReader();
            if (args.length == 1 && !args[0].isEmpty()) {
                printResult(commandReader.processFile(new File(args[0])));
            } else {
                LOGGER.error("Please run command with proper argument");
            }
        } catch(Exception ex) {
            LOGGER.error("Process file throw exception={}", ex);
        }
    }

    private static void printResult(List<String> processFile) {
        processFile.stream().forEach(result ->{
            LOGGER.info("Report result {}", result);
        });
    }
}
