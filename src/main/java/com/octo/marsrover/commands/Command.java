package com.octo.marsrover.commands;

import com.octo.marsrover.PositionVector;

public interface Command {
    String displayableString();
    PositionVector handle(PositionVector positionVector) throws UnhandledBearingException;
}
