package com.octo.marsrover.commands;

import com.octo.marsrover.Console;
import com.octo.marsrover.Display;
import com.octo.marsrover.PositionVector;

import java.util.List;

public class CommandCenter {

    private PositionVector currentPositionVector;
    private Display display;

    public CommandCenter(PositionVector initialPositionVector, Display display) {
        this.currentPositionVector = initialPositionVector;
        this.display = display;
        display.print(initialPositionVector);
    }

    private void receiveCommand(Command command) throws UnhandledBearingException {
        currentPositionVector = command.handle(currentPositionVector);
        display.print(currentPositionVector);
    }

    public void receiveCommands(List<Command> commands) throws UnhandledBearingException {
        for (Command command : commands) {
            receiveCommand(command);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
}
