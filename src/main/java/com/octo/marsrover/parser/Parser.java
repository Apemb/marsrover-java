package com.octo.marsrover.parser;

import com.octo.marsrover.Direction;
import com.octo.marsrover.PositionVector;
import com.octo.marsrover.commands.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    private String[] args;

    public Parser(String[] args) {
        this.args = args;
    }

    public PositionVector getPositionVector() throws IncorrectArgumentsException {
        List<String> argumentList = Arrays.asList(this.args);

        int latitude;
        int longitude;
        Direction direction = null;

        try {
            int latitudeIndex = argumentList.indexOf("-lat");
            int longitudeIndex = argumentList.indexOf("-lon");
            int directionIndex = argumentList.indexOf("-d");

            longitude = Integer.parseInt(argumentList.get(longitudeIndex + 1));
            latitude = Integer.parseInt(argumentList.get(latitudeIndex + 1));
            direction = castToDirection(argumentList.get(directionIndex + 1));

        } catch (Exception e) {
            throw new IncorrectArgumentsException();
        }

        return new PositionVector(longitude, latitude, direction);
    }

    private Direction castToDirection(String directionArgument) throws Exception {
        switch (directionArgument) {
            case "N":
                return Direction.NORTH;
            case "S":
                return Direction.SOUTH;
            case "E":
                return Direction.EAST;
            case "W":
                return Direction.WEST;
            default:
                throw new Exception();
        }
    }

    public List<Command> getCommands() throws IncorrectArgumentsException {
        List<String> argumentList = Arrays.asList(this.args);

        String commandsString;
        List<Command> commands = new ArrayList<>();

        try {
            int commandsIndex = argumentList.indexOf("-com");
            commandsString = argumentList.get(commandsIndex + 1);
            List<String> commandStringList = Arrays.asList(commandsString.split(""));

            for (String commandString : commandStringList) {
                commands.add(commandForCommandString(commandString));
            }

        } catch (Exception e) {
            throw new IncorrectArgumentsException();
        }

        return commands;
    }

    private Command commandForCommandString(String commandString) throws IncorrectArgumentsException {
        switch (commandString) {
            case "f":
                return new MoveForwardCommand();
            case "b":
                return new MoveBackwardCommand();
            case "r":
                return new TurnRightCommand();
            case "l":
                return new TurnLeftCommand();
            default:
                throw new IncorrectArgumentsException();
        }
    }
}
