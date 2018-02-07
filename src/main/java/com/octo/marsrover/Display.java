package com.octo.marsrover;

public class Display {

    private Console console;

    public Display(Console console) {
        this.console = console;
    }

    public void print(PositionVector positionVector) {
        console.print(generatePrintableString(positionVector));
    }

    private String generatePrintableString(PositionVector positionVector) {
        String emptyMapString = "" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n" +
                "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n";

        StringBuilder mapStringBuilder = new StringBuilder(emptyMapString);

        String roverString = "";
        switch (positionVector.getBearing()) {
            case NORTH:
                roverString = "⬆️";
                break;
            case SOUTH:
                roverString = "⬇️";
                break;
            case EAST:
                roverString = "➡️";
                break;
            case WEST:
                roverString = "⬅️";
                break;
        }

        int indexOfRover = (189 + 2 * positionVector.getLongitude()) - positionVector.getLatitude() * 21;
        mapStringBuilder.replace(indexOfRover, indexOfRover + 2, roverString);

        return mapStringBuilder.toString();
    }
}
