package TP1.Ej_2;

//import java.util.Comparator;
import java.util.Iterator;

public class Pila<T> implements Iterable<T>{
	private Nodo<T> first;
	private int cantidad;
	
	public Pila(){
		first = null;
		cantidad = 0;
	}
	
	public void push(T o){
		if (o != null){
			Nodo<T> nuevo = new Nodo<T>(o);
			nuevo.setNext(this.first);
			first = nuevo;
			cantidad++;
		}
	}

	public T pull(){
		if (first != null){
			Nodo<T> aux = new Nodo<T>(null);
			aux.setNext(first);
			first = first.getNext();
			cantidad--;
			return aux.getNext().getObject();			
		}
		return null;
	}	

	public void reverse(){
		Pila<T> aux = new Pila<>();
		while (first != null){
			aux.push(first.getObject());
			first = first.getNext();
		}
		first = aux.first;
	}

	public T top(){
		if (!this.isEmpty())
			return first.getObject();
		return null;
	}
	
	public boolean isEmpty(){
		return this.cantidad == 0;
	}

	@Override
	public String toString() {
		String res = "[";
		for (T obj : this) {
			res += obj + " -> ";
		}
		if (first != null){
			res = res.substring(0, res.length()-4);
		}
		return res + "]";
	}

	@Override
	public Iterator<T> iterator() {
		return new IteradorDeNodos(first);
	}
	
	private class IteradorDeNodos implements Iterator<T>{
		private Nodo<T> current;
		
		public IteradorDeNodos(Nodo<T> n){
			this.current = n;
		}
		
		@Override
		public boolean hasNext() {			
			return current != null;
		}

		@Override
		public T next() {			
			T temp = current.getObject();
			current = current.getNext();
			return temp;
		}
	}
}
