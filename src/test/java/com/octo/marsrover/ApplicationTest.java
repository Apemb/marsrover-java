package com.octo.marsrover;

import com.octo.marsrover.commands.UnhandledBearingException;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class ApplicationTest {

    @Test
    public void test_application_whenStarted_withSomeCorrectArguments_shouldDisplayInitialArguments() throws UnhandledBearingException {
        // Arrange
        String expectedInitialArgumentsString = "\n" +
                "Initial rover position is:\n" +
                " > latitude: 5\n" +
                " > longitude: 2\n" +
                "Initial rover bearing is:\n" +
                " > NORTH\n" +
                "\n" +
                "Commands to execute are:\n" +
                " > Move Forward\n" +
                " > Move Backward\n" +
                "\n";
        Console consoleMock = mock(Console.class);

        // Act
        String[] args = {"-lat", "5", "-lon", "2", "-d", "N", "-com", "fb"};
        Application _ = new Application(args, consoleMock);

        // Assert
        verify(consoleMock).print(expectedInitialArgumentsString);
    }

    @Test
    public void test_application_whenStarted_withMissingArguments_shouldDisplayMissingArgumentString() throws UnhandledBearingException {
        // Arrange
        String expectedErrorString = "Mars Rover aborting mission.\nReason: Some starting arguments are wrong or are " +
                "missing.";
        Console consoleMock = mock(Console.class);

        // Act
        String[] args = {"-lon", "2", "-d", "N", "-com", "ffrrb"};
        Application _ = new Application(args, consoleMock);

        // Assert
        verify(consoleMock).print(expectedErrorString);
    }

    @Test
    public void test_application_whenStarted_withArguments_shouldDisplayMapAfterCommand() throws UnhandledBearingException {
        // Arrange
        Console consoleMock = mock(Console.class);
        String expectedMapString = "" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️⬆️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n";

        // Act
        String[] args = {"-lon", "2", "-lat", "2", "-d", "N", "-com", "f"};
        Application _ = new Application(args, consoleMock);

        // Assert
        verify(consoleMock).print(expectedMapString);
    }

    @Test
    public void test_application_whenStarted_withArguments_shouldDisplayMapAfterMultipleCommands() throws
            UnhandledBearingException {
        // Arrange
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        Console consoleMock = mock(Console.class);
        String expectedMapString = "" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️⬆️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n";

        // Act
        String[] args = {"-lon", "2", "-lat", "0", "-d", "N", "-com", "flbrf"};
        Application _ = new Application(args, consoleMock);

        // Assert
        verify(consoleMock,times(7)).print(stringArgumentCaptor.capture());
        assertEquals(expectedMapString,stringArgumentCaptor.getValue());
    }
}