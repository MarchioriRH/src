package TP3.Ej_6;

import java.util.*;
import TP3.Ej_1.*;

public class Ej_6 {
    
        private Grafo<?> grafo;
        private int origen;
        private int destino;
        private int noFunciona;
        private HashMap<Integer, HashSet<Integer>> arcos;
        
       
        public Ej_6(Grafo<?> grafo, int origen, int destino, int noFunciona) {
            this.grafo = grafo;
            this.origen = origen;
            this.destino = destino;
            this.noFunciona = noFunciona;
            this.arcos = new HashMap<>();
        }
    
        public List<List<Integer>> conexionesPosibles() {   
            if (grafo.contieneVertice(noFunciona))
                grafo.borrarVertice(noFunciona);         
            List<List<Integer>> roads = new ArrayList<>();
            List<Integer> aux = new ArrayList<>();
            caminosDFS(origen, roads, aux);
            return roads;
        }
    
    
        private void caminosDFS(Integer v, List<List<Integer>> roads, List<Integer> caminoActual){
            if (v == destino && !caminoActual.isEmpty()) { 
                caminoActual.add(v);
                roads.add(new ArrayList<>(caminoActual));
            } else {
                caminoActual.add(v);
            }
            arcos.putIfAbsent(v, new HashSet<>());
            Iterator<Integer> itAdjacents  = grafo.obtenerAdyacentes(v);
            while (itAdjacents.hasNext()) {
                Integer Adjacent = itAdjacents.next();
                if (!arcos.get(v).contains(Adjacent)) {
                    arcos.get(v).add(Adjacent);
                    caminosDFS(Adjacent, roads, caminoActual);
                    caminoActual.remove(caminoActual.size()-1);
                    arcos.get(v).remove(Adjacent);                    
                }
            }
            return;
        }
    }

    

