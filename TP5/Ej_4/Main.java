package TP5.Ej_4;

import TP3.Ej_2.*;

public class Main {
    public static <T> void main(String[] args) {
        Grafo<Integer> grafo = new GrafoDirigido<>();

        Vertice<Integer> v1 = new Vertice<>(1);
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
        grafo.agregarArco(v1, v3, 100);
        grafo.agregarArco(v1, v5, 30);
        grafo.agregarArco(v2, v4, 50);
        grafo.agregarArco(v4, v3, 10);
        grafo.agregarArco(v5, v4, 20);
        grafo.agregarArco(v5, v3, 60);

        Dijkstra<T> disjktra = new Dijkstra<>();
        int[] dijkstraSolver = disjktra.solve(grafo, v1);

        for (int i = 0; i < dijkstraSolver.length; i++) {
            System.out.print(dijkstraSolver[i]+" - ");
        }

        // Vertice<Integer> v10 = new Vertice<>(10);
        // Vertice<Integer> v13 = new Vertice<>(10);

        // System.out.println(v10.equals(v13));

    }

}
