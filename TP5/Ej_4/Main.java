package TP5.Ej_4;

import java.util.ArrayList;

import TP3.Ej_2.*;

public class Main {
    public static <T> void main(String[] args) {
        //Grafo<Integer> grafo = new GrafoNoDirigido<>();

        /* Vertice<Integer> v1 = new Vertice<>(1);
        Vertice<Integer> v2 = new Vertice<>(2);
        Vertice<Integer> v3 = new Vertice<>(3);
        Vertice<Integer> v4 = new Vertice<>(4);
        Vertice<Integer> v5 = new Vertice<>(5);
       
        grafo.agregarVertice(v1);
        grafo.agregarVertice(v2);
        grafo.agregarVertice(v3);
        grafo.agregarVertice(v4);
        grafo.agregarVertice(v5);

        grafo.agregarArco(v1, v2, 10);
        grafo.agregarArco(v1, v4, 30);
        grafo.agregarArco(v1, v5, 100);
        grafo.agregarArco(v2, v3, 50);
        grafo.agregarArco(v4, v3, 20);
        grafo.agregarArco(v4, v5, 60);
        grafo.agregarArco(v3, v5, 10); */

        Grafo<Integer> grafo = new GrafoDirigido<>();

        Vertice<Integer> v1 = new Vertice<>(1); //A
        Vertice<Integer> v2 = new Vertice<>(2); //B
        Vertice<Integer> v3 = new Vertice<>(3); //C
        Vertice<Integer> v4 = new Vertice<>(4); //D
        Vertice<Integer> v5 = new Vertice<>(5); //E
        Vertice<Integer> v6 = new Vertice<>(6); //F
       
        grafo.agregarVertice(v1);
        grafo.agregarVertice(v2);
        grafo.agregarVertice(v3);
        grafo.agregarVertice(v4);
        grafo.agregarVertice(v5);
        grafo.agregarVertice(v6);

        grafo.agregarArco(v2, v1, 2);
        grafo.agregarArco(v2, v3, 5);
        grafo.agregarArco(v3, v1, 9);
        grafo.agregarArco(v1, v4, 10);
        grafo.agregarArco(v3, v4, 6);
        grafo.agregarArco(v3, v5, 3);
        grafo.agregarArco(v5, v4, 4);
        grafo.agregarArco(v4, v6, 7);
        // grafo.agregarArco(v4, v2, 20);
        // grafo.agregarArco(v5, v2, 12);
        // grafo.agregarArco(v5, v6, 16);
        // grafo.agregarArco(v6, v1, 24);
        // grafo.agregarArco(v6, v4, 5);

        Dijkstra<T> dijkstra = new Dijkstra<>();
        ArrayList<int[]> dijkstraSolver = dijkstra.solve(grafo, v2);
        for (int i = 1; i <= grafo.cantidadVertices(); i++)
            System.out.print(i + " / ");
        System.out.println();
        for (int[] arr : dijkstraSolver) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == -1)
                    System.out.print("i / ");
                else
                    System.out.print(arr[i]+" / ");
            }
            System.out.println();
        }
        
    }

}
