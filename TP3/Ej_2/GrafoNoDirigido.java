package TP3.Ej_2;

public class GrafoNoDirigido<T> extends GrafoDirigido<T> {

	@Override
	public void agregarArco(Vertice<T> verticeId1, Vertice<T> verticeId2, T etiqueta) {
		super.agregarArco(verticeId1, verticeId2, etiqueta);
		super.agregarArco(verticeId2, verticeId1, etiqueta);
	}
	
	@Override
	public void borrarArco(Vertice<T> verticeId1, Vertice<T> verticeId2) {
		super.borrarArco(verticeId1, verticeId2);
		super.borrarArco(verticeId2, verticeId1);
	}

    @Override
    public int cantidadVertices(){
        return super.cantidadVertices() / 2;
    }

}