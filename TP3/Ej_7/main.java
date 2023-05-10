package TP3.Ej_7;

import TP3.Ej_1.*;
//import TP3.Ej_5.*;
import java.util.*;

public class main {
    public static void main(String[] args){
        Grafo<Integer> g = new GrafoNoDirigido<>();

        g.agregarVertice(1);
        g.agregarVertice(2);
        g.agregarVertice(3);
        g.agregarVertice(4);
        g.agregarVertice(5);
        g.agregarVertice(6);
        g.agregarVertice(7);
        g.agregarVertice(8);
        g.agregarVertice(9);
        g.agregarVertice(10);
        g.agregarVertice(11);
        g.agregarVertice(12);
        g.agregarVertice(13);
        g.agregarVertice(14);
        g.agregarVertice(15);
        g.agregarVertice(16);

        g.agregarArco(1, 2, null);
        g.agregarArco(2, 3, null);
        g.agregarArco(3, 4, null);
        g.agregarArco(1, 5, null);
        g.agregarArco(5, 6, null);
        g.agregarArco(6, 7, null);
        g.agregarArco(7, 8, null);
        g.agregarArco(9, 10, null);
        g.agregarArco(10, 11, null);
        g.agregarArco(12, 13, null);
        g.agregarArco(13, 14, null);
        g.agregarArco(15, 16, null);         
        g.agregarArco(2, 6, null);
        g.agregarArco(3, 7, null);
        g.agregarArco(4, 8, null);
        g.agregarArco(6, 9, null);
        g.agregarArco(7, 10, null);
        g.agregarArco(8, 11, null);
        g.agregarArco(9, 12, null);
        g.agregarArco(10, 13, null);
        g.agregarArco(11, 14, null);
        g.agregarArco(12, 15, null);
        g.agregarArco(13, 16, null);

        System.out.print("Esquinas del mapa: [");
		Iterator<Integer> itVertices = g.obtenerVertices();
		while (itVertices.hasNext()){
			Integer value = itVertices.next();
			if (!itVertices.hasNext())
				System.out.println(value + "]");
			else
				System.out.print(value + ", ");			
		}
        
        try (Scanner scanner = new Scanner(System.in)){
            System.out.print("Ingrese la esquina de origen: ");
            Integer origen = scanner.nextInt(); 
            System.out.print("Ingrese la esquina de destino: ");
            Integer destino = scanner.nextInt(); 
        
            Ej_7 <Integer> grafo = new Ej_7<>(g, origen, destino);

            List<Integer> recorrido = new ArrayList<>();
            recorrido = grafo.recorrido();
           
            System.out.println("Camino mas corto entre " + origen + " y destino " + destino + ": " + recorrido);          
             
        }
    }
}
