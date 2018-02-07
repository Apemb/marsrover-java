package com.octo.marsrover.commands;

import com.octo.marsrover.Direction;
import com.octo.marsrover.PositionVector;
import org.junit.Test;

import static org.junit.Assert.*;

public class TurnRightCommandTest {

    @Test
    public void test_turnRightCommand_shouldDisplayCorrectString() {
        // Arrange
        String expectedDisplayableString = "Turn Right";
        TurnRightCommand turnRightCommand = new TurnRightCommand();

        // Act
        String displayableString = turnRightCommand.displayableString();

        // Assert
        assertEquals(displayableString, expectedDisplayableString);
    }

    @Test
    public void test_handle_shouldChangeBearingToEast_whenBearingIsNorth() throws UnhandledBearingException {
        // Arrange
        Direction expectedBearing = Direction.EAST;
        TurnRightCommand turnRightCommand = new TurnRightCommand();
        PositionVector positionVector = new PositionVector(0,0, Direction.NORTH);

        // Act
        Direction changedBearing = turnRightCommand.handle(positionVector).getBearing();

        // Assert
        assertEquals(expectedBearing,changedBearing);
    }

    @Test
    public void test_handle_shouldChangeBearingToNorth_whenBearingIsWest() throws UnhandledBearingException {
        // Arrange
        Direction expectedBearing = Direction.NORTH;
        TurnRightCommand turnRightCommand = new TurnRightCommand();
        PositionVector positionVector = new PositionVector(0,0, Direction.WEST);

        // Act
        Direction changedBearing = turnRightCommand.handle(positionVector).getBearing();

        // Assert
        assertEquals(expectedBearing,changedBearing);
    }

    @Test
    public void test_handle_shouldChangeBearingToWest_whenBearingIsSouth() throws UnhandledBearingException {
        // Arrange
        Direction expectedBearing = Direction.WEST;
        TurnRightCommand turnRightCommand = new TurnRightCommand();
        PositionVector positionVector = new PositionVector(0,0, Direction.SOUTH);

        // Act
        Direction changedBearing = turnRightCommand.handle(positionVector).getBearing();

        // Assert
        assertEquals(expectedBearing,changedBearing);
    }

    @Test
    public void test_handle_shouldChangeBearingToSouth_whenBearingIsEast() throws UnhandledBearingException {
        // Arrange
        Direction expectedBearing = Direction.SOUTH;
        TurnRightCommand turnRightCommand = new TurnRightCommand();
        PositionVector positionVector = new PositionVector(0,0, Direction.EAST);

        // Act
        Direction changedBearing = turnRightCommand.handle(positionVector).getBearing();

        // Assert
        assertEquals(expectedBearing,changedBearing);
    }

}