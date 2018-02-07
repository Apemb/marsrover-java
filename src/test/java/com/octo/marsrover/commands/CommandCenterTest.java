package com.octo.marsrover.commands;

import com.octo.marsrover.Console;
import com.octo.marsrover.Direction;
import com.octo.marsrover.Display;
import com.octo.marsrover.PositionVector;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CommandCenterTest {

    @Test
    public void test_commandCenter_whenStarted_withSomePosition_shouldShowMapWithInitialRoverPosition() {
        // Arrange
        String expectedMapString = "" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️⬆️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n";
        Console consoleMock = mock(Console.class);
        Display display = new Display(consoleMock);
        PositionVector initialPositionVector = new PositionVector(1, 2, Direction.NORTH);

        // Act
        CommandCenter _ = new CommandCenter(initialPositionVector, display);

        // Assert
        verify(consoleMock).print(expectedMapString);
    }

    @Test
    public void test_commandCenter_whenStarted_withSomeOtherPosition_shouldShowMapWithInitialRoverPosition() {
        // Arrange
        String expectedMapString = "" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️➡️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n";
        Console consoleMock = mock(Console.class);
        Display display = new Display(consoleMock);
        PositionVector initialPositionVector = new PositionVector(6, 4, Direction.EAST);

        // Act
        CommandCenter _ = new CommandCenter(initialPositionVector, display);

        // Assert
        verify(consoleMock).print(expectedMapString);
    }

    @Test
    public void test_commandCenter_whenReceiveCommands_withMoveForwardCommand_shouldShowMapWithNewRoverPositionVector
            () throws UnhandledBearingException {
        // Arrange
        String expectedMapString = "" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️➡️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n";
        Console consoleMock = mock(Console.class);
        Display display = new Display(consoleMock);

        PositionVector initialPositionVector = new PositionVector(6, 4, Direction.EAST);
        CommandCenter commandCenter = new CommandCenter(initialPositionVector, display);

        // Act
        commandCenter.receiveCommands(Collections.singletonList(new MoveForwardCommand()));

        // Assert
        verify(consoleMock).print(expectedMapString);
    }

    @Test
    public void
    test_commandCenter_whenReceiveCommands_withMoveBackwardCommand_shouldShowMapWithNewRoverPositionVector() throws UnhandledBearingException {
        // Arrange
        ArgumentCaptor<String> consoleCaptor =   ArgumentCaptor.forClass(String.class);
        String expectedMapString = "" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️➡️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n";
        Console consoleMock = mock(Console.class);
        Display display = new Display(consoleMock);

        PositionVector initialPositionVector = new PositionVector(5, 4, Direction.EAST);
        CommandCenter commandCenter = new CommandCenter(initialPositionVector, display);

        // Act
        commandCenter.receiveCommands(Collections.singletonList(new MoveBackwardCommand()));

        // Assert
        verify(consoleMock, Mockito.times(2)).print(consoleCaptor.capture());
        assertEquals(expectedMapString,consoleCaptor.getValue());
    }

    @Test
    public void
    test_commandCenter_whenReceiveCommands_withMoveBackwardCommandAndNorthInitialBearing_shouldShowMapWithNewRoverPositionVector
            () throws UnhandledBearingException {
        // Arrange
        ArgumentCaptor<String> consoleCaptor =   ArgumentCaptor.forClass(String.class);
        String expectedMapString = "" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️⬆️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n";
        Console consoleMock = mock(Console.class);
        Display display = new Display(consoleMock);

        PositionVector initialPositionVector = new PositionVector(5, 4, Direction.NORTH);
        CommandCenter commandCenter = new CommandCenter(initialPositionVector, display);

        // Act
        commandCenter.receiveCommands(Collections.singletonList(new MoveBackwardCommand()));

        // Assert
        verify(consoleMock, Mockito.times(2)).print(consoleCaptor.capture());
        assertEquals(expectedMapString,consoleCaptor.getValue());
    }
}