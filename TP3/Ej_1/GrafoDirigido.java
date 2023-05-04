package TP3.Ej_1;

import java.util.*;
import java.util.Map.Entry;

public class GrafoDirigido<T> implements Grafo<T> {
	private Map<Integer, Set<Arco<T>>> vertices;
	private Map<Integer, Integer> state;
	private Map<Integer, int[]> tiempos;
	private Queue<Integer> visitados;
	private int cantArchs;

	public GrafoDirigido(){
		this.vertices = new HashMap<>();
		this.state = new HashMap<>();
		this.tiempos = new HashMap<>();
		this.visitados = new LinkedList<>();
	}

	@Override
    public void agregarVertice(int vertice) {
        vertices.putIfAbsent(vertice, new HashSet<>());
    }


	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        Arco<T> a = new Arco<T>(verticeId1, verticeId2, etiqueta);
		Boolean found = false;
		for (Map.Entry<Integer, Set<Arco<T>>> e : vertices.entrySet()){
			for (Arco<T> aux : e.getValue())
				if (aux.getVerticeOrigen() == a.getVerticeOrigen() && aux.getVerticeDestino() == a.getVerticeDestino() 
					&& aux.getEtiqueta() == a.getEtiqueta())
					found = true;
		}
		if (!found){
			vertices.get(verticeId1).add(a);
			cantArchs++;
		}
    }

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if (vertices.containsKey(verticeId1)){
			Arco<T> a = this.obtenerArco(verticeId1, verticeId2);
			for (Map.Entry<Integer, Set<Arco<T>>> e : vertices.entrySet()){
				e.getValue().remove(a);
				cantArchs--;
			}
        } 
    }

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2){
		if (vertices.containsKey(verticeId1)){
			Set<Arco<T>> adyacentes = vertices.get(verticeId1);
			for (Arco<T> a : adyacentes){
				if (a.getVerticeOrigen() == verticeId1 && a.getVerticeDestino() == verticeId2){
					Arco<T> aux = a;
					return aux;
				}
			}			
		}
		return null;
	}
    	
	@Override
	public void borrarVertice(int verticeId) {
		if (vertices.containsKey(verticeId)){
			vertices.remove(verticeId);
			for (Map.Entry<Integer, Set<Arco<T>>> e : vertices.entrySet())
				for (Arco<T> a : e.getValue()){
					if (a.getVerticeDestino() == verticeId)
						this.borrarArco(e.getKey(), verticeId);
				}
		}
	}	

	@Override
	public boolean contieneVertice(int verticeId) {
		return this.vertices.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		if (vertices.containsKey(verticeId1)){
			Set<Arco<T>> adyacentes = vertices.get(verticeId1);
			for (Arco<T> a : adyacentes){
				if (a.getVerticeOrigen() == verticeId1 && a.getVerticeDestino() == verticeId2)
					return true;
			}
		}
		return false;
	}
	
	@Override
	public int cantidadVertices() {
		return this.vertices.size();
	}

	@Override
	public int cantidadArcos() {
		return cantArchs; //O(1)
		
		/* int res = 0; // O(a) donde a = cantidad de arcos
		for (Map.Entry<Integer, Set<Arco<T>>> e : vertices.entrySet())		
				res += e.getValue().size();
		return res; */
	}	

	@Override
	public void DFS(){
		int time = 0;
		state.clear();
		for (Map.Entry<Integer, Set<Arco<T>>> e : vertices.entrySet()){
			if (state.getOrDefault(e.getKey(), 0) == 0) // Si el vertice esta, devuelve el valor, sino 0
				time = DFS_Visit(e.getKey(), time);
		}
	}

	private int DFS_Visit(Integer origen, int time){
		time += 1;		
		int[] times = new int[2];
		times[0] = time;
		tiempos.put(origen, times);
		state.put(origen, 1); // state: 0 = no visitado, 1 = visitado y 2 = finalizado

		Set<Arco<T>> adyacentes = vertices.get(origen);

		if (adyacentes != null){
			for (Arco<T> a : adyacentes){
				if (state.getOrDefault(a.getVerticeDestino(), 0) == 0){
					time = DFS_Visit(a.getVerticeDestino(), time);
				}
				else if (state.get(a.getVerticeDestino()) == 1)
					System.out.println("Hay un ciclo en el grafo.");
			}
		}
		time += 1;
		times[1] = time;
		tiempos.put(origen, times);
		state.put(origen, 2);
		return time;
	}

	public void printDFSTimes(){
		for (Map.Entry<Integer, int[]> e : tiempos.entrySet()){
			System.out.print("Key: "+e.getKey() + ", values: (");
			for (Integer i : e.getValue())
				System.out.print(i + ",");
			System.out.println(")");
		}
	}

	@Override
	public void BFS(){
		state.clear();
		Set<Integer> e = vertices.keySet();
		for (Integer i : e)
			if (state.getOrDefault(i, 0) == 0) // Si el vertice esta, devuelve el valor, sino 0
				BFS(i);						 // 0 = no visitado, 1 = visitado.
		
	}

	private void BFS(Integer v){
		state.put(v, 1); // Se marca el vertice como visitado
		visitados.offer(v);
		while (!visitados.isEmpty()){
			System.out.println(visitados.peek());
			Set<Arco<T>> adyacentes = vertices.get(visitados.poll()); // Se saca el valor de la fila y se toma el set de arcos
			for (Arco<T> a : adyacentes){							  // de ese vertice para visitarlos.
				if (state.getOrDefault(a.getVerticeDestino(), 0) == 0){  // Si el vertice no fue visitado.
					state.put(a.getVerticeDestino(), 1);	// Se marca el vertice como visitado.
					visitados.offer(a.getVerticeDestino());		// Se agrega el vertice a la fila.
					System.out.print(a.getVerticeDestino()+" ");
				}
			}
			System.out.print("");
		}
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		ArrayList<Integer> verticesList = new ArrayList<>();
		for (Map.Entry<Integer, Set<Arco<T>>> e : vertices.entrySet()){
			verticesList.add(e.getKey());
		}
		Iterator<Integer> itVertices = verticesList.iterator();
		return itVertices;
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		if (vertices.containsKey(verticeId)){
			ArrayList<Integer> adyacentList = new ArrayList<>();
			for (Map.Entry<Integer, Set<Arco<T>>> e : vertices.entrySet()){
				if (e.getKey() == verticeId)
					for (Arco<T> a : e.getValue())
						adyacentList.add(a.getVerticeDestino());
			}
			Iterator<Integer> itAdyacentes = adyacentList.iterator();
			return itAdyacentes;
		}
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		if (!vertices.isEmpty()){
			for (Map.Entry<Integer, Set<Arco<T>>> e : vertices.entrySet())
				return e.getValue().iterator();
		}
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		if (vertices.containsKey(verticeId)){			
			Set<Arco<T>> itArcos = vertices.get(verticeId);
			return itArcos.iterator();
		}
		return null;
	}

	@Override
	public String toString(){
		String res = "";
		for (Map.Entry<Integer, Set<Arco<T>>> a : vertices.entrySet())
			res += a.toString() + "\n";		
		return res;
	}

}
