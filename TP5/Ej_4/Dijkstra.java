package TP5.Ej_4;

import java.util.Arrays;
import java.util.Iterator;

import TP3.Ej_2.*;

public class Dijkstra <T> {
    private int[] father;
    private int[] distances;
    private boolean[] isVisited;

    public Dijkstra() {
        
    }

    private int getMinDistVertex(int[] distances, boolean[] visited) {
        int minDistance = Integer.MAX_VALUE;
        int vertexMinDistance = -1;
        for (int i = 0; i < distances.length; i++) {
            int distance = distances[i];            
            if (!visited[i] && distance < minDistance) {
                minDistance = distance;
                vertexMinDistance = i;
            }
        }        
        return vertexMinDistance;
    }

    private Vertice<Integer> getVertex(Grafo<Integer> grafo, int actualVertex) {
        Iterator<Vertice<Integer>> itVertices = grafo.obtenerVertices();
        while (itVertices.hasNext()){
            Vertice<Integer> data = itVertices.next();                
            if (data.getKey() == actualVertex)
                return data;
        }
        return null;
    }

    public int[] solve(Grafo<Integer> grafo, Vertice<Integer> v1) {
        this.father = new int[grafo.cantidadVertices()];
        this.distances = new int[grafo.cantidadVertices()];
        this.isVisited = new boolean[grafo.cantidadVertices()]; // isVisited será el conjunto de vértices ya considerados
        Arrays.fill(isVisited, false);
        int vertex = (int) v1.getKey();

        Iterator<Vertice<Integer>> itVertices = grafo.obtenerVertices(); // Inicialización
        while (itVertices.hasNext()){
            Vertice<Integer> data = itVertices.next();                 // La distancia inicial desde el origen al vértice v 
            distances[(int) data.getKey()-1] = Integer.MAX_VALUE; // se establece en infinito
            father[(int) data.getKey()-1] = 0;                     // El nodo anterior en el camino óptimo desde el origen
        }
        
        distances[vertex-1] = 0;
        //isVisited[vertex-1] = true;                       // Distancia desde el origen hasta el origen
       
        while (!isVisited[vertex-1]) { // no es vacío - loop principal
            //u = vértice en (G.Vértices – S) tal que dist[u] tiene el menor valor
            
            int actualVertex = getMinDistVertex(distances, isVisited) + 1;
            isVisited[actualVertex-1] = true;
            
            // for each v en (G.Vértices – S) que sea adyacente a u:
            //     if (dist[u] + dist_entre(u, v)) < dist[v]) 
            //     dist[v] = dist[u] + dist_entre(u, v)
            //     padre[v] = u
            Vertice<Integer> aux = getVertex(grafo, actualVertex);
            //Vertice<Integer> aux = new Vertice<>(actualVertex);
            Iterator<Arco<Integer>> archs = grafo.obtenerArcos(aux);
            
            //if (archs != null) {
                while (archs.hasNext()) {
                    Arco<Integer> arch = archs.next();
                    Vertice<Integer> destinyVertex = arch.getVerticeDestino();
                    int archWeight = arch.getEtiqueta();
                    
                    if (!isVisited[(int) destinyVertex.getKey()-1]) {
                        int totalDistance = distances[actualVertex-1] + archWeight;
                        
                        if (totalDistance < distances[destinyVertex.getKey()-1]) {
                            distances[destinyVertex.getKey()-1] = totalDistance;
                            father[destinyVertex.getKey()-1] = actualVertex-1;
                        }
                    }
                }
                vertex = vertex+1;
            //}
        }
        return father;

    }
}   
