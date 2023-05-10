package TP3.Ej_6;

import TP3.Ej_1.*;
import TP3.Ej_5.*;
import java.util.*;

public class main {
    public static void main(String[] args){
        Grafo<Integer> g = new GrafoDirigido<>();

        g.agregarVertice(1);
        g.agregarVertice(2);
        g.agregarVertice(3);
        g.agregarVertice(4);
        g.agregarVertice(5);
        g.agregarVertice(6);
        g.agregarVertice(7);

        g.agregarArco(1, 3, null);
        g.agregarArco(1, 2, null);
        g.agregarArco(1, 4, null);
        g.agregarArco(3, 5, null);
        g.agregarArco(3, 4, null);
        g.agregarArco(3, 1, null);
        g.agregarArco(2, 4, null);
        g.agregarArco(4, 6, null);
        g.agregarArco(4, 5, null);
        g.agregarArco(5, 6, null);
        g.agregarArco(6, 7, null);
        g.agregarArco(5, 1, null);  

        System.out.print("PCs disponibles: [");
		Iterator<Integer> itVertices = g.obtenerVertices();
		while (itVertices.hasNext()){
			Integer value = itVertices.next();
			if (!itVertices.hasNext())
				System.out.println(value + "]");
			else
				System.out.print(value + ", ");			
		}
        
        try (Scanner scanner = new Scanner(System.in)){
            System.out.print("Ingrese la PC de origen: ");
            Integer origen = scanner.nextInt(); 
            System.out.print("Ingrese la PC de destino: ");
            Integer destino = scanner.nextInt(); 
            System.out.print("Ingrese la PC fuera de servicio: ");
            Integer noFunciona = scanner.nextInt(); 
        
            Ej_6 grafo = new Ej_6(g, origen, destino, noFunciona);

            List<List<Integer>> conexiones = new ArrayList<>();
            conexiones = grafo.conexionesPosibles();

            if (conexiones.size() == 0)
                    System.out.println("No hay conexion/es posible/s entre las PC ingresadas.");
                else {
                    System.out.println("Conexion/es posible/s entre la PC " + origen + " y la PC " + destino + ": ");
                    int index = 1;
                    for (List<Integer> camino : conexiones) {
                        System.out.println("  " + index + ": " + camino);
                        index++;
                    }
                }     
        }
    }
}
