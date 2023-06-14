package TP5.Ej_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import TP5.Ej_4.Dijkstra;

public class PuertosCiudades {
    private int[] ciudades;
    private ArrayList<Integer> puertos; // Candidatos

    // NOTA: supongo que los arreglos de ciudades, puertos y distancias estan ordenados por nombre y/o numero de ciudad,
    // asi, en la posicion 0 del array de distancias se encuentra la distancia de esa ciudad al puerto en la posicion 0 de su array.

    public Map<int[], int[]> caminosPuerto() {
        Map<int[], int[]> soluciones = new HashMap<>();
        int[] distanciaSolucionActual = new int[ciudades.length];
        Arrays.fill(distanciaSolucionActual, Integer.MAX_VALUE);
        int[] puertoSolucionActual = new int[ciudades.length];
        int i = 0;
        while (i < puertos.size()) {    // Mientras haya candidatos (puertos)
            int[] posibledistanciaSolucionActual = dijkstra(puertos.get(i)); // Mediante disjkstra se obtiene el arreglo de distancias de un puerto a cada ciudad
            int j = 0;
            while (j < ciudades.length) {  // Se recorre el array de ciudades
                if (distanciaSolucionActual[j] > posibledistanciaSolucionActual[j]) {    // Si la solucion guardada es mayor, se intercambia con la obtenida.
                    distanciaSolucionActual[j] = posibledistanciaSolucionActual[j];
                    puertoSolucionActual[j] = i;
                }
                j++;
            }
            i++;
        }
        soluciones.put(distanciaSolucionActual, puertoSolucionActual);
        return soluciones;
    }
}
