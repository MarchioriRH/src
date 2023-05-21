package TP4.Ej_6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class AtilaHorse {   

    // Matriz para representar el garden
    private int[][] garden;
    private Set<Coordinate> coordsCellsStepped;
    private ArrayList<ArrayList<Coordinate>> routes;
    private ArrayList<Coordinate> actualRoute;
    private int initRow, initColumn, cellsStepped, visitedCellsCounter, size;

    public AtilaHorse(Set<Coordinate> coords, int size){
        this.garden = new int[size][size];
        this.size = size;
        this.routes = new ArrayList<>();
        this.actualRoute = new ArrayList<>();
        this.coordsCellsStepped = coords;
        this.initRow = 0;
        this.initColumn = 0;
        visitedCellsCounter = 1;
        this.cellsStepped = coords.size();
        gardenInit(coordsCellsStepped);
    }

    // Metodo para inicializar el jardin (matriz)
    private void gardenInit(Set<Coordinate> coords){
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                garden[i][j] = -1;
            }
        }
        Iterator<Coordinate> itCoordinates = coords.iterator();
        while (itCoordinates.hasNext()){
            Coordinate aux = itCoordinates.next();
            garden[aux.getRow()][aux.getColumn()] = 0;
        }
    }

    // Metodo para imprimir el jardin
    public void printGarden() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(garden[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Metodo para obtener las posiciones validas para realizar un movimiento a partir de una celda
    private ArrayList<Coordinate> getValidPositions(int row, int column) {
        ArrayList<Coordinate> res = new ArrayList<>();
        if (row + 1 < size && garden[row  +1][column] == 0)
            res.add(new Coordinate(row + 1, column));
        if (row - 1 >= 0 && garden[row - 1][column] == 0)
            res.add(new Coordinate(row - 1, column));
        if (column + 1 < size && garden[row][column + 1] == 0)
            res.add(new Coordinate(row, column + 1));
        if (column - 1 >= 0 && garden[row][column - 1] == 0)
            res.add(new Coordinate(row, column - 1));    
        return res;
    }

    // Metodo para detectar si dos celdas son adyacentes       
    private boolean adyacentCells(int row, int column, int initRow, int initColumn) {
        return ((Math.abs(row - initRow) == 1 && initColumn == column) ||
                (initRow == row && Math.abs(column - initColumn) == 1));
    }

    // Metodo para obtener las coordenadas validas desde donde iniciar el recorrido
    public ArrayList<Coordinate> getValidInitCoordintes(){
        ArrayList<Coordinate> res = new ArrayList<>();
        int i = 0;
        while (i < size){
            if (garden[initRow][i] != -1){
                Coordinate aux = new Coordinate(initRow, i);
                if (!res.contains(aux))
                    res.add(aux);
            }
            if (garden[i][initColumn] != -1) {
                Coordinate aux = new Coordinate(i, initColumn);
                if (!res.contains(aux))
                    res.add(aux);
            }
            if (garden[i][size - 1] != -1) {
                Coordinate aux = new Coordinate(i, size - 1);
                if (!res.contains(aux))
                    res.add(aux);
            }
            if (garden[size - 1][i] != -1) {
                Coordinate aux = new Coordinate(size - 1, i);
                if (!res.contains(aux))
                    res.add(aux);
            }
            i++;
        }
        return res;
    }

    // Inicio para buscar soluciones
    public ArrayList<ArrayList<Coordinate>> getSolutions() { 
        ArrayList<Coordinate> validInitCoordinates = getValidInitCoordintes();
        for (Coordinate coord : validInitCoordinates) {
            initRow = coord.getRow();
            initColumn = coord.getColumn();
            actualRoute.add(new Coordinate(coord.getRow(), coord.getColumn()));
            garden[coord.getRow()][coord.getColumn()] = -2;
            backtrack(coord.getRow(), coord.getColumn(), visitedCellsCounter);
            gardenInit(coordsCellsStepped);            
            visitedCellsCounter = 1;
            actualRoute.clear();
        } 
        return routes;
    }

    // Metodo recursiva para encontrar las soluciones
    private void backtrack(int row, int column, int visitedCellsCounter) {
        // Caso base: Si se han visitado todas las casillas y se termina en una adyacente
        if (visitedCellsCounter == cellsStepped && adyacentCells(row, column, initRow, initColumn)) {
            routes.add(new ArrayList<>(actualRoute));
            Coordinate aux = actualRoute.get(0);
            actualRoute.clear();
            actualRoute.add(aux);
        } else {             
                for (Coordinate coord : getValidPositions(row, column)) {
                    actualRoute.add(coord);
                    garden[coord.getRow()][coord.getColumn()] = -2;                                       
                    backtrack(coord.getRow(), coord.getColumn(), visitedCellsCounter + 1);
                    actualRoute.remove(coord);
                    garden[coord.getRow()][coord.getColumn()] = 0;
                }
        }
    }    
}

    
    


