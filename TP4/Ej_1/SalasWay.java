package TP4.Ej_1;

import java.util.ArrayList;
import java.util.Iterator;

import TP3.Ej_2.Grafo;
import TP3.Ej_2.GrafoDirigido;
import TP3.Ej_2.GrafoNoDirigido;
import TP3.Ej_2.Vertice;

public class SalasWay {
    private static ArrayList<Vertice<Integer>> res = new ArrayList<Vertice<Integer>>();

    public static ArrayList<Vertice<Integer>> findWay(Grafo<Integer> g, Vertice<Integer> entrance, Vertice<Integer> exit) {
        boolean[] visited = new boolean[g.cantidadVertices()+1];
        ArrayList<Vertice<Integer>> current = new ArrayList<Vertice<Integer>>();
        Vertice<Integer> index = entrance;
        current.add(entrance);
        findWayBack(g, index, exit, current, visited);
        return res;
    }

    private static void findWayBack(Grafo<Integer> g, Vertice<Integer> index, Vertice<Integer> exitRoom, ArrayList<Vertice<Integer>> current, boolean[] visited) {
        if (current.contains(exitRoom)) {
            if (res.size() < current.size()) {
                res = new ArrayList<>(current);
            }
        } else {
            Iterator<Vertice<Integer>> adyacentes = g.obtenerAdyacentes(index);
            while (adyacentes.hasNext()) {
                Vertice<Integer> v = adyacentes.next();
                if (visited[v.getKey()] == false) {
                    visited[v.getKey()] = true;
                    findWayBack(g, v, exitRoom, current, visited);
                    visited[v.getKey()] = false;
                    
                    visited[v.getKey()] = true;
                    current.add(v);
                    findWayBack(g, v, exitRoom, current, visited);
                    current.remove(v);
                    visited[v.getKey()] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Grafo<Integer> g1 = new GrafoDirigido<>();

        Vertice<Integer> v1 = new Vertice<>(1);
        Vertice<Integer> v2 = new Vertice<>(2);
        Vertice<Integer> v3 = new Vertice<>(3);
        Vertice<Integer> v4 = new Vertice<>(4);
        Vertice<Integer> v5 = new Vertice<>(5);
       // Vertice<Integer> v13 = new Vertice<>(13);

        g1.agregarVertice(v1);
        g1.agregarVertice(v2);
        g1.agregarVertice(v3);
        g1.agregarVertice(v4);
        g1.agregarVertice(v5);

        g1.agregarArco(v1, v3, 3);
        
        g1.agregarArco(v1, v5, 23);
        g1.agregarArco(v1, v4, 23);
        g1.agregarArco(v1, v2, 21);
        
        g1.agregarArco(v2, v4, 21);
        g1.agregarArco(v3, v1, 2);
        g1.agregarArco(v3, v2, 12);
        g1.agregarArco(v4, v5, 4);
        g1.agregarArco(v5, v3, 2);

        System.out.println(SalasWay.findWay(g1, v1, v5));
    }
}
