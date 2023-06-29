package TP5.Prim;

import java.util.*;
import TP3.Ej_2.*;

public class PrimAlgorithm {

    public static void primMST(HashMap<Integer, Integer> vertices, Set<Arco<Integer>> edges) {
        // Crear un conjunto para almacenar los vértices visitados
        Set<Integer> visited = new HashSet<>();

        // Crear un PriorityQueue para almacenar los arcos (ordenados por peso)
        PriorityQueue<Arco<Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Arco<Integer>::getEtiqueta));

        // Escoger un vértice inicial arbitrario
        Integer startVertex = vertices.keySet().iterator().next();
        visited.add(startVertex);

        // Agregar los arcos adyacentes al vértice inicial al minHeap
        addAdjacentEdges(startVertex, edges, minHeap);

        int totalWeight = 0;
        int metric = 0;
        // Iterar hasta que se visiten todos los vértices
        while (visited.size() < vertices.size()) {
            //metric++;
            // Extraer el arco de menor peso del minHeap
            Arco<Integer> minEdge = minHeap.poll();
            
            // Obtener el vértice adyacente no visitado
            Integer nextVertex = minEdge.getVerticeDestino().getKey();

            // Si el vértice adyacente no ha sido visitado, agregarlo al árbol y marcarlo como visitado
            if (!visited.contains(nextVertex)) {
                metric++;
                visited.add(nextVertex);
                totalWeight += minEdge.getEtiqueta();
                System.out.println("Edge: " + minEdge.getVerticeOrigen() + " - " + minEdge.getVerticeDestino() + ", Weight: " + minEdge.getEtiqueta());
                addAdjacentEdges(nextVertex, edges, minHeap);
            }
        }
        System.out.println("Total weight: " + totalWeight);
        System.out.println("Metrica: " + metric);
    }

    private static void addAdjacentEdges(Integer vertex, Set<Arco<Integer>> edges, PriorityQueue<Arco<Integer>> minHeap) {
        for (Arco<Integer> edge : edges) {
            if (edge.getVerticeOrigen().getKey().equals(vertex)) {
                minHeap.offer(edge);
            }
        }
    }

    public static void main(String[] args) {
        // Crear el mapa de vértices y el conjunto de arcos
        HashMap<Integer, Integer> vertices = new HashMap<>();
        vertices.put(1, 0);
        vertices.put(2, 1);
        vertices.put(3, 2);
        vertices.put(4, 3);
        vertices.put(5, 4);
        vertices.put(6, 5);

        // Dataset1
        // Set<Arco<Integer>> edges = new HashSet<>();
        // edges.add(new Arco<Integer>(1, 2, 15));
        // edges.add(new Arco<Integer>(1, 3, 30));
        // edges.add(new Arco<Integer>(1, 4, 50));
        // edges.add(new Arco<Integer>(3, 4, 20));
        // edges.add(new Arco<Integer>(2, 4, 400));
        // edges.add(new Arco<Integer>(2, 3, 34));
        
        // Dataset1
        // E1;E2;15
        // E1;E3;30
        // E1;E4;50
        // E3;E4;20
        // E2;E4;400
        // E2;E3;34

        //Dataset3
        Set<Arco<Integer>> edges = new HashSet<>();
        edges.add(new Arco<Integer>(1, 2, 25));
        edges.add(new Arco<Integer>(1, 3, 60));
        edges.add(new Arco<Integer>(1, 4, 90));
        edges.add(new Arco<Integer>(1, 5, 50));
        edges.add(new Arco<Integer>(1, 6, 50));
        edges.add(new Arco<Integer>(2, 3, 60));
        edges.add(new Arco<Integer>(2, 6, 35));
        edges.add(new Arco<Integer>(2, 5, 30));
        edges.add(new Arco<Integer>(2, 4, 70));
        edges.add(new Arco<Integer>(3, 5, 60));
        edges.add(new Arco<Integer>(3, 6, 80));
        edges.add(new Arco<Integer>(4, 3, 10));
        edges.add(new Arco<Integer>(4, 5, 70));
        edges.add(new Arco<Integer>(4, 6, 70));
        edges.add(new Arco<Integer>(6, 5, 10));




        //Dataset 2
        // E1;E2;25
        // E1;E4;90
        // E1;E3;60
        // E1;E5;50
        // E1;E6;50
        // E2;E3;60
        // E2;E6;35
        // E2;E5;30
        // E2;E4;70
        // E3;E5;60
        // E3;E6;80
        // E4;E3;10
        // E4;E5;70
        // E4;E6;70
        // E6;E5;10    

        // Aplicar el algoritmo de Prim
        primMST(vertices, edges);
    }
}
