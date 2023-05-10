package TP3.Ej_5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import TP3.Ej_1.*;

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
        //g.agregarArco(3, 1, null);
        g.agregarArco(2, 4, null);
        g.agregarArco(4, 6, null);
        g.agregarArco(4, 5, null);
        g.agregarArco(5, 6, null);
        g.agregarArco(6, 7, null);
        //g.agregarArco(5, 1, null);  
        
        Ej_5 vertices = new Ej_5(g);

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
            System.out.print("Ingrese el vertice buscado: ");
            Integer buscado = scanner.nextInt();
			ArrayList<Integer> resultado = vertices.verticesQueLlegan(buscado);
			if (resultado.size() == 0)
				System.out.println("No hay vertices que lleguen al buscado.");
			else 
				System.out.println("Vertices que llegan a " + buscado + ": " + resultado);	        
        }      
    }
}
