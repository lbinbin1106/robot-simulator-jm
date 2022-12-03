package com.robot;


import com.robot.reader.CommandReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		try {
			CommandReader reader = new CommandReader();
			if (args.length == 1 && !args[0].isEmpty()) {
				printResult(reader.readFrom(new File(args[0])));
			}else{
				System.out.println("Run command: java -jar robot-simulator-jm-1.0-SNAPSHOT.jar <input file>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void printResult(ArrayList<String> result) {
		result.stream().forEach(r -> {
			System.out.println("Output: " + r);
		});
	}
}
