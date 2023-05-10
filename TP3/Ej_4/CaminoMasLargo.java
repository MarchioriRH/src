package TP3.Ej_4;

import java.util.*;

import TP3.Ej_1.*;

public class CaminoMasLargo <T> {
    private ArrayList<Integer> caminoMasLargo, caminoMasLargoAux;
    private Map<Integer, Integer> state;

    public CaminoMasLargo(){
        this.state = new HashMap<>();
        //this.isCyclic = false;
    } 
      
    public ArrayList<Integer> largestRoad(Grafo<?> g, Integer init, Integer end){
        caminoMasLargo = new ArrayList<>();
        caminoMasLargoAux = new ArrayList<>();            
        largestRoadVisit(g, init, end, caminoMasLargo, caminoMasLargoAux);
        return caminoMasLargo;
    }

    private ArrayList<Integer> largestRoadVisit(Grafo<?> g, Integer init, Integer end, ArrayList<Integer> caminoMaslargo,
                                                ArrayList<Integer> caminoMaslargoAux){   
        
        if (init == end){                             // Si origen == destino            
            if (caminoMasLargo.size() < caminoMasLargoAux.size()){ // Si el camino guardado es mas corto que el descubierto
                caminoMaslargo.clear();                            // Elimina el que estaba guardado
                caminoMasLargo.addAll(caminoMaslargoAux);          // Guarda el que fue descubierto
                System.out.println("Camino largo: "+caminoMaslargo);
            }
        }
        if (!caminoMaslargoAux.contains(init)) // Aqui se va armando el nuevo camino que se va descubriendo
            caminoMaslargoAux.add(init);
        state.put(init, 1); // Se marca el vertice como visitado, state: 0 = no visitado, 1 = visitado y 2 = finalizado

        Iterator<Integer> adyacentes = g.obtenerAdyacentes(init); // Se obtienen los vertices adyacentes al actual
        System.out.println("Camino Aux: "+ caminoMaslargoAux);

        if (adyacentes != null){    // Si el vertice tiene adyacentes
            while(adyacentes.hasNext()){    // Mientras haya adyacentes se recorre la lista
                Integer value = adyacentes.next();  // Se toma el valor actual
                if (state.getOrDefault(value, 0) == 0){     // Si el vertice no fue visitado
                    caminoMaslargoAux.add(value);           // Agrega el adyacente al camino que se viene armando
                    largestRoadVisit(g, value, end, caminoMaslargo, caminoMaslargoAux); // Recursivamente se hace el recorrido con el vertice actual
                    caminoMaslargoAux.remove(value);    // Si no es un camino valido, se remueve el ultimo valor agregado de la lista auxiliar
                    state.replace(value, 0);    // Se marca el vertice como no visitado por si hay que utilizarlo en otro recorrido
                }               
            }
        }       
       
        return caminoMaslargo;
        
    }
      
}
