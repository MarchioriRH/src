package Practica;

import java.util.ArrayList;

public class RobotPseudo {
    public ArrayList<Position> robotWay(Position init) {  // Position es un a clase que contine los valores de x e y en la matriz que representa la casa.
        ArrayList<Position> bestWay = new ArrayList<>();
        ArrayList<Position> currentWay = new ArrayList<>();
        Position actualPos = init;
        robotBack(e, currentWay, bestWay, actualPos);
        return bestWay;
    }

    private void robotBack(Estado e, ArrayList<Position> currentWay, ArrayList<Position> bestWay, Position actualPos) {
        if (e.getBasePosition() == actualPos) { // getBasePosition devuelve la coordenada de ubicacion de la base
            if (e.compareWay(currentWay, bestWay) > 0) {  // Si el camino mas a la izq es menor, devualte > 0
                bestWay = currentWay;
                return;
            }
        } else {
            ArrayList<Position> currentPositions = e.getRobotValidMoves(actualPos); // Devuelve los posible movimientos desde la posicion actual
            for (Position p : currePositions) {
                currentWay.add(p);
                // int oldPos = actualPos;
                // actualPos = p;
                robotBack(e, currentWay, p);
            //   actualPos = oldPos;
                currentWay.remove(p);
            }
        }
    }
}
