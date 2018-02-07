package com.octo.marsrover;

import com.octo.marsrover.commands.UnhandledBearingException;

public class Main {

    public static void main(String[] args) throws UnhandledBearingException {
        Console console = new Console();

        Application application = new Application(args, console);
    }
}
