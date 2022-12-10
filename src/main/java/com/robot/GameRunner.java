package com.robot;

import com.robot.utility.GameCommandReader;

import java.io.File;
import java.io.FileNotFoundException;

public class GameRunner {
    public static void main(String[] args) throws FileNotFoundException {
        //process input text file
        GameCommandReader commandReader = new GameCommandReader();
        commandReader.processFile(new File(args[0]));
        //pass input into simulator and return result
        //print game result

    }
}
