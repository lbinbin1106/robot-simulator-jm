package com.robot.exception;

public class InvalidGameRobotException extends RuntimeException {
	private String message;

	public InvalidGameRobotException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
