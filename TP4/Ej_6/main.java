package TP4.Ej_6;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        
        
        Set<Coordinate> cellsStepped = new HashSet<>();
        cellsStepped.add(new Coordinate(0, 0));
        cellsStepped.add(new Coordinate(0, 1));
        cellsStepped.add(new Coordinate(0, 2));
        cellsStepped.add(new Coordinate(1, 0));
        cellsStepped.add(new Coordinate(1, 1));
        cellsStepped.add(new Coordinate(1, 2));
        cellsStepped.add(new Coordinate(2, 1));
        cellsStepped.add(new Coordinate(2, 2));
        cellsStepped.add(new Coordinate(1, 3));
        cellsStepped.add(new Coordinate(2, 3));

        AtilaHorse horse = new AtilaHorse(cellsStepped, 4);
        System.out.println("Posibles celdas de entrada al jardin: " + horse.getValidInitCoordintes());
        System.out.println("Posibles caminos recorridos: ");
        ArrayList<ArrayList<Coordinate>> routes = horse.getSolutions();
        int counter = 0;
        for (ArrayList<Coordinate> route : routes){
            System.out.println(counter + ": "+ route);
            counter++;
        }
    }
}
