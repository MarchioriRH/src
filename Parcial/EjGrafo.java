package Parcial;

import java.util.ArrayList;
import java.util.Iterator;

import TP3.Ej_2.*;

public class EjGrafo {
    private static ArrayList<Integer> res = new ArrayList<>();
    private static ArrayList<Integer> camino = new ArrayList<>();

    public static ArrayList<Integer> DFS(Grafo<Integer> g) {
        camino.clear();
        res.clear();
        Iterator<Vertice<Integer>> itVertices = g.obtenerVertices();
        while (itVertices.hasNext()) {
            Vertice<Integer> ver = itVertices.next();
            ver.setColor("BLANCO");
        }
        itVertices = g.obtenerVertices();
        while (itVertices.hasNext()) {
            Vertice<Integer> v = itVertices.next();
            if (v.getColor() == "BLANCO") {
                DFS_Visit(g, v);
            }           
        }
        return res;
    }

    private static void DFS_Visit(Grafo<Integer> g, Vertice<Integer> v) {
        v.setColor("AMARILLO");
        camino.add(v.getKey());
        System.out.println("camino " + camino.toString());
        Iterator<Vertice<Integer>> adyAV = g.obtenerAdyacentes(v);
        while (adyAV.hasNext()) {
            Vertice<Integer> vAdy = adyAV.next();
            if (vAdy.getColor() == "BLANCO") 
                DFS_Visit(g, vAdy);
            else 
                if (vAdy.getColor() == "AMARILLO") {
                    camino.add(vAdy.getKey());
                    camino = trimRoad(camino, vAdy);
                    if (res.size() < camino.size())
                        res = new ArrayList<Integer>(camino);
                    camino.clear();
                }
        }
        v.setColor("BLANCO");
    }

    private static ArrayList<Integer> trimRoad(ArrayList<Integer> road, Vertice<Integer> vAdy) {
        int i = 0;
        while (road.get(i) != vAdy.getKey())
            road.remove(i);
        road.remove(road.size()-1);
        return road;
    }

    public static void main(String[] args) {
        Grafo<Integer> g1 = new GrafoDirigido<>();

        Vertice<Integer> v1 = new Vertice<>(1);
        Vertice<Integer> v2 = new Vertice<>(2);
        Vertice<Integer> v3 = new Vertice<>(3);
        Vertice<Integer> v4 = new Vertice<>(4);
        Vertice<Integer> v5 = new Vertice<>(5);
        Vertice<Integer> v6 = new Vertice<>(6);

        g1.agregarVertice(v1);
        g1.agregarVertice(v2);
        g1.agregarVertice(v3);
        g1.agregarVertice(v4);
        g1.agregarVertice(v5);
        g1.agregarVertice(v6);

        g1.agregarArco(v1, v3, 3);
        
        //g1.agregarArco(v1, v5, 23);
        g1.agregarArco(v1, v4, 23);
        g1.agregarArco(v2, v1, 21);
        
        g1.agregarArco(v4, v2, 21);
        //g1.agregarArco(v3, v1, 2);
        //g1.agregarArco(v3, v2, 12);
        g1.agregarArco(v3, v4, 4);
        g1.agregarArco(v5, v3, 2);
        g1.agregarArco(v6, v2, 2);

        ArrayList<Integer> result = DFS(g1);
        System.out.println(result.toString());
    }
    
}
