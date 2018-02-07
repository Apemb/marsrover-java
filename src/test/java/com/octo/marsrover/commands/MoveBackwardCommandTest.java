package com.octo.marsrover.commands;

import com.octo.marsrover.Direction;
import com.octo.marsrover.PositionVector;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoveBackwardCommandTest {

    @Test
    public void test_moveBackwardCommand_shouldDisplayCorrectString() {
        // Arrange
        String expectedDisplayableString = "Move Backward";
        MoveBackwardCommand moveBackwardCommand = new MoveBackwardCommand();

        // Act
        String displayableString = moveBackwardCommand.displayableString();

        // Assert
        assertEquals(displayableString, expectedDisplayableString);
    }

    @Test
    public void test_handle_shouldIncrementLongitude_whenBearingIsWest() throws UnhandledBearingException {
        // Arrange
        PositionVector initialPositionVector = new PositionVector(3, 3, Direction.WEST);

        // Act
        MoveBackwardCommand moveBackwardCommand = new MoveBackwardCommand();
        PositionVector currentPositionVector = moveBackwardCommand.handle(initialPositionVector);

        // Assert
        PositionVector expectedPositionVector = new PositionVector(4, 3, Direction.WEST);
        assertEquals(expectedPositionVector, currentPositionVector);
    }

    @Test
    public void test_handle_shouldIncreaseLatitude_whenBearingIsSouth() throws UnhandledBearingException {
        // Arrange
        PositionVector initialPositionVector = new PositionVector(3, 3, Direction.SOUTH);

        // Act
        MoveBackwardCommand moveBackwardCommand = new MoveBackwardCommand();
        PositionVector currentPositionVector = moveBackwardCommand.handle(initialPositionVector);

        // Assert
        PositionVector expectedPositionVector = new PositionVector(3, 4, Direction.SOUTH);
        assertEquals(expectedPositionVector, currentPositionVector);
    }
}