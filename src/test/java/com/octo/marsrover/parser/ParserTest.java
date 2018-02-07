package com.octo.marsrover.parser;

import com.octo.marsrover.Direction;
import com.octo.marsrover.PositionVector;
import com.octo.marsrover.commands.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void test_parser_whenGivenCorrectPositionArguments_shouldProvidePositionVector() throws IncorrectArgumentsException {
        // Arrange
        String[] args = {"-lat", "2", "-lon", "3", "-d", "N", "-com", "fb"};
        PositionVector expectedPositionVector = new PositionVector(3, 2, Direction.NORTH);
        Parser parser = new Parser(args);

        // Act
        PositionVector positionVector = parser.getPositionVector() ;

        // Assert
        assertEquals(expectedPositionVector, positionVector);
    }

    @Test
    public void test_parser_whenGivenCorrectCommandArguments_shouldProvideCommands() throws IncorrectArgumentsException {
        // Arrange
        String[] args = {"-com", "bflr"};
        List<Command> expectedCommands = new ArrayList<>();
        expectedCommands.add(new MoveBackwardCommand());
        expectedCommands.add(new MoveForwardCommand());
        expectedCommands.add(new TurnLeftCommand());
        expectedCommands.add(new TurnRightCommand());
        Parser parser = new Parser(args);

        // Act
        List<Command> commands = parser.getCommands();

        // Assert
        assertEquals(expectedCommands, commands);
    }
}