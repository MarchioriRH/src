package TP4.Ej_2;

public class Data {
    private int value;
    private boolean west, east, north, south;

    public Data(int value, boolean north, boolean south, boolean west, boolean east) {
        this.value = value;
        this.west = west;
        this.east = east;
        this.north = north;
        this.south = south;
    }

    public int getValue() {
        return value;
    }

    public boolean isWest() {
        return west;
    }

    public boolean isEast() {
        return east;
    }

    public boolean isNorth() {
        return north;
    }

    public boolean isSouth() {
        return south;
    }

    
}
