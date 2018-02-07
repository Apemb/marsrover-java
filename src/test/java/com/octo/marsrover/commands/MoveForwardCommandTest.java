package com.octo.marsrover.commands;

import com.octo.marsrover.Direction;
import com.octo.marsrover.PositionVector;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoveForwardCommandTest {

    @Test
    public void test_moveForwardCommand_shouldDisplayCorrectString() {
        // Arrange
        String expectedDisplayableString = "Move Forward";
        MoveForwardCommand moveForwardCommand = new MoveForwardCommand();

        // Act
        String displayableString = moveForwardCommand.displayableString();

        // Assert
        assertEquals(displayableString, expectedDisplayableString);
    }

    @Test
    public void test_handle_shouldDecreaseLongitude_whenBearingIsWest() throws UnhandledBearingException {
        // Arrange
        PositionVector initialPositionVector = new PositionVector(3, 3, Direction.WEST);

        // Act
        MoveForwardCommand moveForwardCommand = new MoveForwardCommand();
        PositionVector currentPositionVector = moveForwardCommand.handle(initialPositionVector);

        // Assert
        PositionVector expectedPositionVector = new PositionVector(2, 3, Direction.WEST);
        assertEquals(expectedPositionVector, currentPositionVector);
    }

    @Test
    public void test_handle_shouldDecreaseLatitude_whenBearingIsSouth() throws UnhandledBearingException {
        // Arrange
        PositionVector initialPositionVector = new PositionVector(3, 3, Direction.SOUTH);

        // Act
        MoveForwardCommand moveForwardCommand = new MoveForwardCommand();
        PositionVector currentPositionVector = moveForwardCommand.handle(initialPositionVector);

        // Assert
        PositionVector expectedPositionVector = new PositionVector(3, 2, Direction.SOUTH);
        assertEquals(expectedPositionVector, currentPositionVector);
    }

    @Test
    public void test_handle_shouldIncreaseLongitude_whenBearingIsEast() throws UnhandledBearingException {
        // Arrange
        PositionVector initialPositionVector = new PositionVector(3, 3, Direction.EAST);

        // Act
        MoveForwardCommand moveForwardCommand = new MoveForwardCommand();
        PositionVector currentPositionVector = moveForwardCommand.handle(initialPositionVector);

        // Assert
        PositionVector expectedPositionVector = new PositionVector(4, 3, Direction.EAST);
        assertEquals(expectedPositionVector, currentPositionVector);
    }

    @Test
    public void test_handle_shouldIncreaseLatitude_whenBearingIsNorth() throws UnhandledBearingException {
        // Arrange
        PositionVector initialPositionVector = new PositionVector(3, 3, Direction.NORTH);

        // Act
        MoveForwardCommand moveForwardCommand = new MoveForwardCommand();
        PositionVector currentPositionVector = moveForwardCommand.handle(initialPositionVector);

        // Assert
        PositionVector expectedPositionVector = new PositionVector(3, 4, Direction.NORTH);
        assertEquals(expectedPositionVector, currentPositionVector);
    }
}