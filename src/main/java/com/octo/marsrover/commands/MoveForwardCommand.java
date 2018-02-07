package com.octo.marsrover.commands;

import com.octo.marsrover.PositionVector;

public class MoveForwardCommand implements Command {

    private static final String DISPLAYABLE_NAME = "Move Forward";

    @Override
    public String displayableString() {
        return DISPLAYABLE_NAME;
    }

    @Override
    public PositionVector handle(PositionVector positionVector) throws UnhandledBearingException {
        int longitude = positionVector.getLongitude();
        int latitude = positionVector.getLatitude();
        switch (positionVector.getBearing()) {
            case WEST:
                longitude--;
                break;
            case SOUTH:
                latitude--;
                break;
            case EAST:
                longitude++;
                break;
            case NORTH:
                latitude++;
                break;
            default:
                throw new UnhandledBearingException();
        }
        return new PositionVector(longitude, latitude, positionVector.getBearing());
    }
    @Override
    public boolean equals(Object o) {
        return this == o || o != null && getClass() == o.getClass();
    }
}
