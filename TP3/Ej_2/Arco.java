package TP3.Ej_2;

/*
 * La clase arco representa un arco del grafo. Contiene un vertice origen, un vertice destino y una etiqueta.
 * Nota: Para poder exponer los arcos fuera del grafo y que nadie los modifique se hizo esta clase inmutable
 * (Inmutable: una vez creado el arco no es posible cambiarle los valores).
 */
public class Arco<T> {

	private Vertice<T> verticeOrigen;
	private Vertice<T> verticeDestino;
	private T etiqueta;

	public Arco(Vertice<T> verticeOrigen, Vertice<T> verticeDestino, T etiqueta) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.etiqueta = etiqueta;
	}
	
	public Arco(T verticeOrigen, T verticeDestino, T etiqueta) {
		this.verticeOrigen = new Vertice<T>(verticeOrigen);
		this.verticeDestino = new Vertice<T>(verticeDestino);
		this.etiqueta = etiqueta;
	}

	public Arco(){
		this.verticeDestino = null;
		this.verticeOrigen = null;
		this.etiqueta = null;
	}

	public Arco(Vertice<T> verticeOrigen, Vertice<T> verticeDestino) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.etiqueta = null;
	}
	
	public Vertice<T> getVerticeOrigen() {  //¿Esta bien devolver el vertice? ¿Devolver una copia?
		Vertice<T> copy = verticeOrigen;
		return copy;
	}
	
	public Vertice<T> getVerticeDestino() {
		Vertice<T> copy = verticeDestino;
		return copy;
	}

	public T getEtiqueta() {
		return etiqueta;
	}

	@Override
    public String toString() {		
        return "Arco: (Origen: " + getVerticeOrigen() + ", destino: " + getVerticeDestino() + ", peso: " + getEtiqueta() + ")";
    }

}