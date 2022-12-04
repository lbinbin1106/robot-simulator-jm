package com.robot;

import com.robot.util.GameCommandReader;

import java.io.File;

public class GameRunner {
    public static void main(String[] args) {
        //process input text file
        GameCommandReader commandReader = new GameCommandReader();
        commandReader.processFile(new File(args[0]));
        //pass input into simulator and return result
        //print game result

    }
}
