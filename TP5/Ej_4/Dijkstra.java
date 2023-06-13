package TP5.Ej_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import TP3.Ej_2.*;

public class Dijkstra <T> {
    private int[] father;
    private int[] distances;
    private ArrayList<Integer> isVisited;

    // Metodo privado para obtener el vertice mas cercano
    private int getMinDistVertex(int[] distances, ArrayList<Integer> visited) {
        int minDistance = Integer.MAX_VALUE;
        int vertexMinDistance = -1;
        for (int i = 0; i < distances.length; i++) {  
            int distance = distances[i];            
            if (!visited.contains(i) && distance < minDistance) { // Si el vertice no fue visitado y la distancia registrada es menor que la
                minDistance = distance;                           // minima distancia,la minima distancia se vuelve la distancia registrada y 
                vertexMinDistance = i;                            // el vertice a devolver se vuelve el actual
            }
        }        
        return vertexMinDistance + 1;
    }

    // Metodo privado para obtener un vertice del grafo
    private Vertice<Integer> getVertex(Grafo<Integer> grafo, int actualVertex) {
        Iterator<Vertice<Integer>> itVertices = grafo.obtenerVertices();
        while (itVertices.hasNext()){
            Vertice<Integer> data = itVertices.next();                
            if (data.getKey() == actualVertex)
                return data;
        }
        return null;
    }

    public ArrayList<int[]> solve(Grafo<Integer> grafo, Vertice<Integer> v1) {
        this.father = new int[grafo.cantidadVertices()];
        this.distances = new int[grafo.cantidadVertices()];
        this.isVisited = new ArrayList<>();             // isVisited será el conjunto de vértices ya considerados
        ArrayList<int[]> res = new ArrayList<>();       // Inicializacion
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(father, -1);
        int vertex = (int) v1.getKey();                 // Se obtiene el valor de la key del vertice
       
        distances[vertex-1] = 0;                        // Se setea el valor de la distancia del origen en 0
       
        while (isVisited.size() < grafo.cantidadVertices()) { // loop principal
            
            int actualVertex = getMinDistVertex(distances, isVisited);      // Se obtiene el vertice mas cercano al actual
            isVisited.add(actualVertex-1);                                      // Se agrega a la lista de vistados
            
            Vertice<Integer> aux = getVertex(grafo, actualVertex);              
            Iterator<Arco<Integer>> archs = grafo.obtenerArcos(aux);   // Se obtienen los vertices adyacentes
            if (archs == null)
                System.out.println();          
            while (archs != null && archs.hasNext()) {
                Arco<Integer> arch = archs.next();
                Vertice<Integer> destinyVertex = arch.getVerticeDestino();
                int archWeight = arch.getEtiqueta();
                int totalDistance = distances[actualVertex-1] + archWeight;      // Se calcula la distancia entre el vertice actual y el siguiente
                
                if (totalDistance < distances[destinyVertex.getKey()-1]) {      // Si la distancia calculada es menor que la que esta setedada en el
                    distances[destinyVertex.getKey()-1] = totalDistance;        // arreglo de distancias para ese vertice, se reemplaza por la nueva
                    father[destinyVertex.getKey()-1] = actualVertex;            // Se agrega al vertice actual como padre del calculado
                }
            }
        } 
        res.add(distances);
        res.add(father);      
        return res;
    }
}   
