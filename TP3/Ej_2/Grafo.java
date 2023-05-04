package TP3.Ej_2;

import java.util.Iterator;

public interface Grafo<T> {
	
	// Recorrido DFS de un grafo.
	public void DFS();

	// Agrega un vertice 
	public void agregarVertice(Vertice<T> verticeId);

	// Borra un vertice
	public void borrarVertice(Vertice<T> verticeId);

	// Agrega un arco con una etiqueta, que conecta el verticeId1 con el verticeId2
	public void agregarArco(Vertice<T> verticeId1, Vertice<T> verticeId2, T etiqueta);

	// Borra el arco que conecta el verticeId1 con el verticeId2
	public void borrarArco(Vertice<T> verticeId1, Vertice<T> verticeId2);

	// Verifica si existe un vertice
	public boolean contieneVertice(Vertice<T> verticeId);  

	// Verifica si existe un arco entre dos vertices
	public boolean existeArco(Vertice<T> verticeId1, Vertice<T> verticeId2);
	
	// Obtener el arco que conecta el verticeId1 con el verticeId2
	public Arco<T> obtenerArco(Vertice<T> verticeId1, Vertice<T> verticeId2);

	// Devuelve la cantidad total de vertices en el grafo
	public int cantidadVertices();

	// Devuelve la cantidad total de arcos en el grafo
	public int cantidadArcos();

	// Obtiene un iterador que me permite recorrer todos los vertices almacenados en el grafo 
	public Iterator<Vertice<T>> obtenerVertices();

	// Obtiene un iterador que me permite recorrer todos los vertices adyacentes a verticeId 
	public Iterator<Vertice<T>> obtenerAdyacentes(Vertice<T> verticeId);

	// Obtiene un iterador que me permite recorrer todos los arcos del grafo
	public Iterator<Arco<T>> obtenerArcos();
		
	// Obtiene un iterador que me permite recorrer todos los arcos que parten desde verticeId
	public Iterator<Arco<T>> obtenerArcos(Vertice<T> verticeId);
	
	
}