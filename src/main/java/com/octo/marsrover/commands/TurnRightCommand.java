package com.octo.marsrover.commands;

import com.octo.marsrover.Direction;
import com.octo.marsrover.PositionVector;

public class TurnRightCommand implements Command {

    private static final String DISPLAYABLE_NAME = "Turn Right";

    @Override
    public String displayableString() {
        return DISPLAYABLE_NAME;
    }

    @Override
    public PositionVector handle(PositionVector positionVector) throws UnhandledBearingException {
        Direction direction;
        switch (positionVector.getBearing()) {
            case NORTH:
                direction = Direction.EAST;
                break;
            case SOUTH:
                direction = Direction.WEST;
                break;
            case EAST:
                direction = Direction.SOUTH;
                break;
            case WEST:
                direction = Direction.NORTH;
                break;
            default:
                throw new UnhandledBearingException();
        }

        return new PositionVector(positionVector.getLongitude(),
                positionVector.getLatitude(),
                direction);
    }

    @Override
    public boolean equals(Object o) {
        return this == o || o != null && getClass() == o.getClass();
    }
}
