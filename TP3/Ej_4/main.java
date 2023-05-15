package TP3.Ej_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import TP3.Ej_1.*;

public class main {
    public static <T> void main (String[] args){
        Grafo<Integer> g = new GrafoDirigido<>();

        g.agregarVertice(1);
        g.agregarVertice(2);
        g.agregarVertice(3);
        g.agregarVertice(4);
        g.agregarVertice(5);
        g.agregarVertice(6);
        g.agregarVertice(7);
        g.agregarVertice(8);

        g.agregarArco(1, 3, null);
        g.agregarArco(1, 2, null);
        g.agregarArco(1, 4, null);
        g.agregarArco(3, 5, null);
        //g.agregarArco(3, 4, null);
       // g.agregarArco(3, 1, null);
        g.agregarArco(2, 4, null);
        g.agregarArco(4, 6, null);
        g.agregarArco(4, 5, null);
        
        g.agregarArco(3, 8, null);
        g.agregarArco(8, 4, null);
        g.agregarArco(6, 7, null);
        //g.agregarArco(5, 1, null);        

        

        System.out.print("Vertices del grafo: [");
		Iterator<Integer> itVertices = g.obtenerVertices();
		while (itVertices.hasNext()){
			Integer value = itVertices.next();
			if (!itVertices.hasNext())
				System.out.println(value + "]");
			else
				System.out.print(value + ", ");			
		}
		try (Scanner scanner = new Scanner(System.in)){            
            System.out.print("Ingrese el vertice de origen: ");
            Integer origen = scanner.nextInt();
			System.out.print("Ingrese el vertice de destino: ");
            Integer destino = scanner.nextInt();
			CaminoMasLargo<T> c = new CaminoMasLargo<T>();
            ArrayList<Integer> caminoMasLargo = c.largestRoad(g, origen, destino);
			
			if (caminoMasLargo.size() == 0)
				System.out.println("No hay camino/s posible/s entre los vertices ingresados.");
			else {
				System.out.println("Camino mas largo entre el vertice " + origen + " y el " + destino + ": " + caminoMasLargo);				
			}           
        }
    }
}
