package TP3.Ej_1;

/*
 * La clase arco representa un arco del grafo. Contiene un vertice origen, un vertice destino y una etiqueta.
 * Nota: Para poder exponer los arcos fuera del grafo y que nadie los modifique se hizo esta clase inmutable
 * (Inmutable: una vez creado el arco no es posible cambiarle los valores).
 */
public class Arco<T> {

	private Integer verticeOrigen;
	private Integer verticeDestino;
	private T etiqueta;

	public Arco(int verticeOrigen, int verticeDestino, T etiqueta) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.etiqueta = etiqueta;
	}

	public Arco(){
		this.verticeDestino = null;
		this.verticeOrigen = null;
		this.etiqueta = null;
	}

	public Arco(int verticeOrigen, int verticeDestino) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.etiqueta = null;
	}
	
	public Integer getVerticeOrigen() {
		return verticeOrigen;
	}
	
	public Integer getVerticeDestino() {
		return verticeDestino;
	}

	public T getEtiqueta() {
		return etiqueta;
	}

	@Override
    public String toString() {		
        return "Arco: (Origen: " + getVerticeOrigen() + ", destino: " + getVerticeDestino() + ", peso: " + getEtiqueta() + ")";
    }

}