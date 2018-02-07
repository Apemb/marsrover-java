package com.octo.marsrover.commands;

import com.octo.marsrover.Direction;
import com.octo.marsrover.PositionVector;
import org.junit.Test;

import static org.junit.Assert.*;

public class TurnLeftCommandTest {

    @Test
    public void test_turnLeftCommand_shouldDisplayTurnLeft() {
        // Arrange
        String expectedDisplayableString = "Turn Left";
        TurnLeftCommand turnLeftCommand = new TurnLeftCommand();

        // Act
        String displayableString = turnLeftCommand.displayableString();

        // Assert
        assertEquals(displayableString, expectedDisplayableString);
    }

    @Test
    public void test_handle_shouldChangeBearingToWest_whenBearingIsNorth() throws UnhandledBearingException {
        // Arrange
        Direction expectedBearing = Direction.WEST;
        TurnLeftCommand turnLeftCommand = new TurnLeftCommand();
        PositionVector positionVector = new PositionVector(0,0, Direction.NORTH);

        // Act
        Direction changedBearing = turnLeftCommand.handle(positionVector).getBearing();

        // Assert
        assertEquals(expectedBearing,changedBearing);
    }

    @Test
    public void test_handle_shouldChangeBearingToSouth_whenBearingIsWest() throws UnhandledBearingException {
        // Arrange
        Direction expectedBearing = Direction.SOUTH;
        TurnLeftCommand turnLeftCommand = new TurnLeftCommand();
        PositionVector positionVector = new PositionVector(0,0, Direction.WEST);

        // Act
        Direction changedBearing = turnLeftCommand.handle(positionVector).getBearing();

        // Assert
        assertEquals(expectedBearing,changedBearing);
    }

    @Test
    public void test_handle_shouldChangeBearingToEast_whenBearingIsSouth() throws UnhandledBearingException {
        // Arrange
        Direction expectedBearing = Direction.EAST;
        TurnLeftCommand turnLeftCommand = new TurnLeftCommand();
        PositionVector positionVector = new PositionVector(0,0, Direction.SOUTH);

        // Act
        Direction changedBearing = turnLeftCommand.handle(positionVector).getBearing();

        // Assert
        assertEquals(expectedBearing,changedBearing);
    }

    @Test
    public void test_handle_shouldChangeBearingToNorth_whenBearingIsEast() throws UnhandledBearingException {
        // Arrange
        Direction expectedBearing = Direction.NORTH;
        TurnLeftCommand turnLeftCommand = new TurnLeftCommand();
        PositionVector positionVector = new PositionVector(0,0, Direction.EAST);

        // Act
        Direction changedBearing = turnLeftCommand.handle(positionVector).getBearing();

        // Assert
        assertEquals(expectedBearing,changedBearing);
    }
}