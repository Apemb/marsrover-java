package com.octo.marsrover;

import com.octo.marsrover.commands.*;
import com.octo.marsrover.parser.IncorrectArgumentsException;
import com.octo.marsrover.parser.Parser;

import java.util.List;

public class Application {

    private final String INCORRECT_ARGUMENTS_MESSAGE = "Mars Rover aborting mission.\nReason: Some starting arguments" +
            " are wrong or are missing.";

    private Console console;

    public Application(String[] args, Console console) throws UnhandledBearingException {
        this.console = console;

        PositionVector initialPositionVector = null;
        List<Command> commands;
        try {
            Parser parser = new Parser(args);
            initialPositionVector = parser.getPositionVector();
            commands = parser.getCommands();

        } catch (IncorrectArgumentsException incorrectArgumentsException) {
            console.print(INCORRECT_ARGUMENTS_MESSAGE);
            return;
        }

        displayInitialMessage(initialPositionVector, commands);
        Display display = new Display(console);
        CommandCenter commandCenter = new CommandCenter(initialPositionVector, display);
        commandCenter.receiveCommands(commands);
    }

    private void displayInitialMessage(PositionVector positionVector, List<Command> commands) {
        StringBuilder commandStringBuilder = new StringBuilder("Commands to execute are:\n");
        commands.forEach(command -> commandStringBuilder.append(" > " + command.displayableString() + "\n"));
        commandStringBuilder.append("\n");

        String initialArgumentsString = "\nInitial rover position is:\n" +
                " > latitude: " + positionVector.getLatitude() + "\n" +
                " > longitude: " + positionVector.getLongitude() + "\n" +
                "Initial rover bearing is:\n" +
                " > " + positionVector.getBearing() + "\n\n" +
                commandStringBuilder.toString();

        console.print(initialArgumentsString);
    }
}
