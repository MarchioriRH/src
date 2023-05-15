package TP3.Ej_7;

import TP3.Ej_1.*;
import java.util.*;

public class Ej_7 <T> {
    private Integer esqOrigen, esqDestino;
    private Grafo<Integer> grafo;
	private Queue<Integer> visitados;
    private ArrayList<Integer> camino;

    public Ej_7(Grafo<Integer> grafo, int esqOrigen, int esqDestino){
        this.esqOrigen = esqOrigen;
        this.esqDestino = esqDestino;
        this.grafo = grafo;
		this.visitados = new LinkedList<>();
        this.camino = new ArrayList<>();      
    }

    public ArrayList<Integer> recorrido(){
		BFS(esqOrigen, esqDestino, camino);	
        return camino;		
	}

	private void BFS(Integer esqOrigen, Integer esqDestino, ArrayList<Integer> camino){
		int[] distancia = new int[grafo.cantidadVertices()];
        int[] padre = new int[grafo.cantidadVertices()];
        Arrays.fill(distancia, Integer.MAX_VALUE);
        Arrays.fill(padre, -1);
        distancia[esqOrigen-1] = 0;
		visitados.offer(esqOrigen);
        //camino.add(esqOrigen);
		while (!visitados.isEmpty()){
			//System.out.println(visitados.peek());
            Integer esqActual = visitados.poll();
            if (esqActual == esqDestino){
                visitados.clear();
                break;							  
            }
            Iterator<Arco<Integer>> itArcos = grafo.obtenerArcos(esqActual);                
			while (itArcos.hasNext()){
                Arco<Integer> arco = itArcos.next();               
                if (distancia[arco.getVerticeDestino()-1] == Integer.MAX_VALUE){  
                    distancia[arco.getVerticeDestino()-1] = distancia[arco.getVerticeDestino()-1] + 1;
                    padre[arco.getVerticeDestino()-1] = esqActual;
                    visitados.offer(arco.getVerticeDestino());                             
                }
            }
		}  
        int actual = esqDestino;
        while (actual != -1) {
            camino.add(actual);
            actual = padre[actual-1];
        }
        Collections.reverse(camino);        
	} 
}
