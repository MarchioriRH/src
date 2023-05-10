package TP3.Ej_5;

import java.util.*;

import TP3.Ej_1.Grafo;

public class Ej_5 {
    private Grafo<?> g;
    private Map<Integer, Integer> state;

    public Ej_5(Grafo<?> g){
        this.g = g;
        this.state = new HashMap<>();
    }

    public ArrayList<Integer> verticesQueLlegan(Integer buscado){
        ArrayList<Integer> verticesQueLlegan = new ArrayList<>();
        ArrayList<Integer> caminoAux = new ArrayList<>();
        Iterator<Integer> itVertices = g.obtenerVertices();            
        while (itVertices.hasNext()){
            Integer vertice = itVertices.next();
            //System.out.println("Vertice: "+vertice);
            state.clear();
            caminoAux.clear();
            verticesQueLlegan(vertice, buscado, verticesQueLlegan, caminoAux);
        }
        return verticesQueLlegan;
    }

    private ArrayList<Integer> verticesQueLlegan(Integer vertice, Integer buscado, ArrayList<Integer> verticesQueLlegan,
                                                ArrayList<Integer> caminoAux){   
        
        if (vertice == buscado){  
            if (caminoAux.size() > 0) {
                for (Integer i : caminoAux)
                    if (!verticesQueLlegan.contains(i) && i != buscado)                                            
                        verticesQueLlegan.add(i);                
            }
            caminoAux.clear();      
            //System.out.println("Los que llegan: "+verticesQueLlegan);
            }
        
        if (!caminoAux.contains(vertice)) // Aqui se va armando el nuevo camino que se va descubriendo
            caminoAux.add(vertice);
        state.put(vertice, 1); // Se marca el vertice como visitado, state: 0 = no visitado, 1 = visitado y 2 = finalizado

        Iterator<Integer> adyacentes = g.obtenerAdyacentes(vertice); // Se obtienen los vertices adyacentes al actual
        //System.out.println("Camino Aux: "+ caminoAux);

        if (adyacentes != null){    // Si el vertice tiene adyacentes
            while(adyacentes.hasNext()){    // Mientras haya adyacentes se recorre la lista
                Integer value = adyacentes.next();  // Se toma el valor actual
                if (state.getOrDefault(value, 0) == 0){     // Si el vertice no fue visitado
                    caminoAux.add(value);           // Agrega el adyacente al camino que se viene armando
                    verticesQueLlegan(value, buscado, verticesQueLlegan, caminoAux); // Recursivamente se hace el recorrido con el vertice actual
                    caminoAux.remove(value);    // Si no es un camino valido, se remueve el ultimo valor agregado de la lista auxiliar
                    state.replace(value, 0);    // Se marca el vertice como no visitado por si hay que utilizarlo en otro recorrido
                }               
            }
        }        
        return verticesQueLlegan;        
    } 
}
