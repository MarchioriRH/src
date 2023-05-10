package TP3.Ej_3;

import java.util.*;

import TP3.Ej_1.*;

public class main <T extends Comparable<? super T>> {    

    private Map<Integer, Integer> state = new HashMap<>();
	private Map<Integer, int[]> tiempos = new HashMap<>();;

    public void DFS(Grafo<?> g){
		int time = 0;
		state.clear();
        Iterator<Integer> itVertices = g.obtenerVertices();
        while(itVertices.hasNext()){
            Integer aux = itVertices.next();
			if (state.getOrDefault(aux, 0) == 0) // Si el vertice esta, devuelve el valor, sino 0
				time = DFS_Visit(g, aux, time);
		}
	}

	private int DFS_Visit(Grafo<T> g, Integer origen, int time){
		time += 1;		
		int[] times = new int[2];
		times[0] = time;
		tiempos.put(origen, times);
		state.put(origen, 1); // state: 0 = no visitado, 1 = visitado y 2 = finalizado

		Iterator<Arco<T>> adyacentes = g.obtenerArcos(origen);

		if (adyacentes != null){
			while(adyacentes.hasNext()){
                Arco<T> aux = adyacentes.next();
				if (state.getOrDefault(aux.getVerticeDestino(), 0) == 0){
					time = DFS_Visit(g, aux.getVerticeDestino(), time);
				}
				else if (state.get(aux.getVerticeDestino()) == 1)
					System.out.println("Hay un ciclo en el grafo.");
			}
		}
		time += 1;
		times[1] = time;
		tiempos.put(origen, times);
		state.put(origen, 2);
		return time;
	}

    public static <T> void main(String[] args){
        Grafo<Integer> g1 = new GrafoDirigido<>();

        g1.agregarVertice(1);
        g1.agregarVertice(2);
        g1.agregarVertice(3);
        g1.agregarVertice(4);
        g1.agregarVertice(5);
        g1.agregarVertice(6);
        g1.agregarVertice(7);
        g1.agregarVertice(8);


        g1.agregarArco(1, 3, 3);        
        g1.agregarArco(1, 5, 23);        
        g1.agregarArco(1, 2, 21);
        g1.agregarArco(2, 3, 21);
        g1.agregarArco(2, 5, 2);
        g1.agregarArco(3, 1, 12);
        g1.agregarArco(4, 5, 4);
        g1.agregarArco(4, 6, 44);
        
        g1.agregarArco(5, 3, 2);
        g1.agregarArco(6, 5, 2);
        g1.agregarArco(7, 4, 2);
        g1.agregarArco(7, 8, 2);
        g1.agregarArco(7, 6, 2);
        g1.agregarArco(8, 5, 2);

        DFS(g1);

    }
}