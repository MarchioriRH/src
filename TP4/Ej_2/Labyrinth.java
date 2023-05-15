package TP4.Ej_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Labyrinth {
    private Data[][] labyrinth;
    private ArrayList<Coordinate> road, roadAux;
    private int res;
    
    private class Coordinate {
        int x, y;
        
        Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "[" + x + "," + y + "]";
        }
        
    }

    public Labyrinth (Data[][] labyrinth){
        this.labyrinth = labyrinth;
        this.road = new ArrayList<>();
        this.roadAux = new ArrayList<>();
        this.res = 0;
    }

    private int addition(ArrayList<Coordinate> road) {
        int res = 0;
        for (Coordinate cell : road){
            res += labyrinth[cell.x][cell.y].getValue();
        }
        return res;
    }

    public ArrayList<Coordinate> recorrido(int x1, int y1, int destinoX, int destinoY){
        if (x1 == destinoX && y1 == destinoY){
            System.out.println("x1: "+x1+", y1: "+y1);
            if (road.isEmpty()) {
                this.road = new ArrayList<>(roadAux);
                res = addition(road);
            } else {
                if (res > addition(roadAux)){
                    res = addition(roadAux);
                    this.road = new ArrayList<>(roadAux);
                }
            }
        } else {
            if (labyrinth[x1][y1].isNorth()) {
                Coordinate coor = new Coordinate(x1, y1);
                roadAux.add(roadAux.size(), coor);
                recorrido(x1, y1-1, destinoX, destinoY);
                roadAux.remove(coor);
            }
            if (labyrinth[x1][y1].isEast()) {
                Coordinate coor = new Coordinate(x1, y1);
                roadAux.add(roadAux.size(), coor);
                recorrido(x1+1, y1, destinoX, destinoY);
                roadAux.remove(coor);
            }
            if (labyrinth[x1][y1].isSouth()) {
                Coordinate coor = new Coordinate(x1, y1);
                roadAux.add(roadAux.size(), coor);
                recorrido(x1, y1+1, destinoX, destinoY);
                roadAux.remove(coor);
            }
            if (labyrinth[x1][y1].isWest()) {
                Coordinate coor = new Coordinate(x1, y1);
                roadAux.add(roadAux.size(), coor);
                recorrido(x1-1, y1, destinoX, destinoY);
                roadAux.remove(coor);
            }
        }
          
        return road;
    }


}
