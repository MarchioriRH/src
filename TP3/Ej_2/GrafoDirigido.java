package TP3.Ej_2;

import java.util.*;

public class GrafoDirigido<T> implements Grafo<T> {
	private Map<Vertice<T>, Set<Arco<T>>> vertices;
	private int cantArchs;

	public GrafoDirigido(){
		this.vertices = new HashMap<>();
		this.cantArchs = 0;
	}

	@Override
    public void agregarVertice(Vertice<T> vertice) {
        vertices.putIfAbsent(vertice, new HashSet<>());
    }


	@Override
	public void agregarArco(Vertice<T> verticeId1, Vertice<T> verticeId2, T etiqueta) {
        Arco<T> a = new Arco<T>(verticeId1, verticeId2, etiqueta);
		Boolean found = false;
		for (Map.Entry<Vertice<T>, Set<Arco<T>>> e : vertices.entrySet()){
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
	public void borrarArco(Vertice<T> verticeId1, Vertice<T> verticeId2) {
		if (vertices.containsKey(verticeId1)){
			Arco<T> a = this.obtenerArco(verticeId1, verticeId2);
			for (Map.Entry<Vertice<T>, Set<Arco<T>>> e : vertices.entrySet()){
				e.getValue().remove(a);
				cantArchs--;
			}
        } 
    }

	@Override
	public Arco<T> obtenerArco(Vertice<T> verticeId1, Vertice<T> verticeId2){
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
	public void borrarVertice(Vertice<T> verticeId) {
		if (vertices.containsKey(verticeId)){
			vertices.remove(verticeId);
			for (Map.Entry<Vertice<T>, Set<Arco<T>>> e : vertices.entrySet())
				for (Arco<T> a : e.getValue()){
					if (a.getVerticeDestino() == verticeId)
						this.borrarArco(e.getKey(), verticeId);
				}
		}
	}	

	@Override
	public boolean contieneVertice(Vertice<T> verticeId) {
		return this.vertices.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(Vertice<T> verticeId1, Vertice<T> verticeId2) {
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
		return this.cantArchs;
		/* int res = 0;
		for (Map.Entry<Vertice<T>, Set<Arco<T>>> e : vertices.entrySet())		
				res += e.getValue().size();
		return res; */
	}

	public void DFS(){
		for (Map.Entry<Vertice<T>, Set<Arco<T>>> e : vertices.entrySet()){
			e.getKey().setColor("blanco");
		}

		int time = 0;

		for (Map.Entry<Vertice<T>, Set<Arco<T>>> e : vertices.entrySet()){
			if (e.getKey().getColor().equals("blanco"))
				DFS_Visit(e.getKey(), time);
		}
	}

	private void DFS_Visit(Vertice<T> v, int time){
		v.setColor("amarillo");
		time += 1;
		v.setFoundTime(time);
		Set<Arco<T>> adyacentes = vertices.get(v);
		for(Arco<T> a : adyacentes){
			if (a.getVerticeDestino().getColor().equals("blanco"))
				DFS_Visit(a.getVerticeDestino(), time);
			else
				if (a.getVerticeDestino().getColor().equals("amarillo"))
					System.out.println("Hay ciclo.");
		}
		v.setColor("negro");
		time += 1;
		v.setEndTime(time);
	}

	

	@Override
	public Iterator<Vertice<T>> obtenerVertices() {
		ArrayList<Vertice<T>> verticesList = new ArrayList<>();
		for (Map.Entry<Vertice<T>, Set<Arco<T>>> e : vertices.entrySet()){
			verticesList.add(e.getKey());
		}
		Iterator<Vertice<T>> itVertices = verticesList.iterator();
		return itVertices;
	}

	@Override
	public Iterator<Vertice<T>> obtenerAdyacentes(Vertice<T> verticeId) {
		if (vertices.containsKey(verticeId)){
			ArrayList<Vertice<T>> adyacentList = new ArrayList<>();
			for (Map.Entry<Vertice<T>, Set<Arco<T>>> e : vertices.entrySet()){
				if (e.getKey() == verticeId)
					for (Arco<T> a : e.getValue())
						adyacentList.add(a.getVerticeDestino());
			}
			Iterator<Vertice<T>> itAdyacentes = adyacentList.iterator();
			return itAdyacentes;
		}
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		ArrayList<Arco<T>> setArcos = new ArrayList<>();
		if (!vertices.isEmpty()){
			for (Map.Entry<Vertice<T>, Set<Arco<T>>> e : vertices.entrySet())
				for (Arco<T> a : e.getValue())
					setArcos.add(a);
			Iterator<Arco<T>> itArcos = setArcos.iterator();
			return itArcos;
		}
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(Vertice<T> verticeId) {
		if (vertices.containsKey(verticeId)){
			ArrayList<Arco<T>> setArcos = new ArrayList<>();
			setArcos.addAll(vertices.get(verticeId));
			Iterator<Arco<T>> itArcos = setArcos.iterator();
			return itArcos;
		}
		return null;
	}

	@Override
	public String toString(){
		String res = "";
		for (Map.Entry<Vertice<T>, Set<Arco<T>>> a : vertices.entrySet())
			res += a.toString() + "\n";		
		return res;
	}

}
