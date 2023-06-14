package TP5.Ej_6;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.AbstractMap.SimpleEntry;

import TP3.Ej_2.Arco;
import TP3.Ej_2.Grafo;
import TP3.Ej_2.Vertice;

public class ProblemaDelViajante <T> {
    private Grafo<Integer> mapaDeCiudades;

    public ProblemaDelViajante(Grafo<Integer> mapaDeCiudades) {
        this.mapaDeCiudades = mapaDeCiudades;
    }

    private SimpleEntry<Integer, Integer> getProximaCiudad(Integer ciudad, ArrayList<Integer> caminoSolucion) {
        Vertice<Integer> ciudadActual = new Vertice<>(ciudad);
        SimpleEntry<Integer, Integer> res;
        int distancia = Integer.MAX_VALUE;
        int vecino = 0;
        Iterator<Arco<Integer>> ciudadesVecinas = mapaDeCiudades.obtenerArcos(ciudadActual);
        while (ciudadesVecinas.hasNext()) {
            Arco<Integer> actual = ciudadesVecinas.next();
            if (actual.getEtiqueta() < distancia && !caminoSolucion.contains(actual.getVerticeOrigen().getKey())) {
                vecino = actual.getVerticeDestino().getKey();
                distancia = actual.getEtiqueta();
            }
        }
        res = new SimpleEntry<Integer,Integer>(vecino, distancia);
        return res;
    }

    public SimpleEntry<ArrayList<Integer>, Integer> solvePDV(int ciudadInicio) {
        SimpleEntry<ArrayList<Integer>, Integer> solucionPDV;
        Vertice<Integer> ciudadInicial = new Vertice<>(ciudadInicio);
        ArrayList<Integer> caminoSolucion = new ArrayList<>();
        ArrayList<Integer> ciudades = new ArrayList<>();
        caminoSolucion.add(ciudadInicio);

        Iterator<Vertice<Integer>> itCiudades = mapaDeCiudades.obtenerAdyacentes(ciudadInicial);
        while (itCiudades.hasNext()) {
            Vertice<Integer> aux = itCiudades.next();
            if (aux.getKey() != ciudadInicio)
                ciudades.add(aux.getKey());   
        }    
        int i = 0;
        int distancia = 0;
        while (i < ciudades.size()) {
            SimpleEntry<Integer, Integer> mejorCandidato = getProximaCiudad(ciudadInicio, caminoSolucion);
            distancia += mejorCandidato.getValue();
            caminoSolucion.add(mejorCandidato.getKey());
            ciudadInicio = mejorCandidato.getKey();
            i++;
        }
        solucionPDV = new SimpleEntry<ArrayList<Integer>,Integer>(caminoSolucion, distancia);
        return solucionPDV;
    }
}
