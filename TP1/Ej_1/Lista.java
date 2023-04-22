package TP1.Ej_1;

import java.util.Comparator;
import java.util.Iterator;

public class Lista<T> implements Iterable<T>{
	protected Nodo<T> first;
	private int cantidad;
	private Comparator<T> comparador;
	
	public Lista(Comparator<T> comp){
		first = null;
		this.comparador = comp;
		cantidad = 0;
	}
	
	public static <T extends Comparable<? super T>> Lista<T> createWithComparable() {
        return new Lista<T>(new Comparator<T>() {
            @Override
            public int compare(T p1,T p2) {
                return p1.compareTo(p2);
            }
        });
    }

	public void setOrder(Comparator<T> comp){
		if (comp != null){
			this.comparador = comp;
			Iterator<T> oldIterator = iterator();
			first = null;
			for (Iterator<T> itr=oldIterator; itr.hasNext();)  {
				add(itr.next());
			}
		}
	}

	public void insertFront(T o){
		if (o != null){
			Nodo<T> nuevo = new Nodo<T>(o);
			nuevo.setNext(this.first);
			first = nuevo;
		}
	}

	public T extractFront(){
		if (first != null){
			Nodo<T> aux = new Nodo<T>(null);
			aux.setNext(first);
			first = first.getNext();
			return aux.getNext().getObject();
		}
		return null;
	}

	public T get(int index){
		if (index < 0 || index >= length()){
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + length());
		} else {
			Nodo<T> aux = first;
			int cont = 0;
			while (cont < index && aux != null){
				aux = aux.getNext();
				cont++;
			}
			if (aux == null)
				return null;
			else
				return aux.getObject();
		}
	}

	public void setOrderReversed(){
		setOrder(comparador.reversed());
	}

	public void add(T o){
		Nodo<T> nuevo = new Nodo<>(o);
		if (first == null){
			first = nuevo;
			cantidad++;
		}
		else {		
			Nodo<T> aux = first;
			Nodo<T> detras = null;	
			while (aux != null && comparador.compare(aux.getObject(), nuevo.getObject()) < 0){
				detras = aux;
				aux = aux.getNext();
			} 			
			if (aux == null){
				detras.setNext(nuevo);
				cantidad++;
			} else {
				nuevo.setNext(aux);
				if (aux == first){
					first = nuevo;
					cantidad++;
				} else {
					detras.setNext(nuevo);
					cantidad++;
				}
			}
		}	
	}
	
	public void remove(int index){
		if (index<0 || index>=length()){
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + length());
		}
		if (index == 0){
			first = first.getNext();
			cantidad--;
		}else{
			Nodo<T> actual = first;
			for (int i = 1; i <= index; i++, actual = actual.getNext()) {
				if (i == index){
					actual.setNext(actual.getNext().getNext());
					cantidad--;
				}
			}
		}
	}
	
	public void remove(T o){
		if ((first != null) && (first.getObject().equals(o))) {
			first = first.getNext();
			cantidad--;
		} else {
			Nodo<T> actual = first;
			while (actual.getNext() != null) {
				if (actual.getNext().getObject().equals(o)){
					actual.setNext(actual.getNext().getNext());
					cantidad--;
				} else {
					actual = actual.getNext();
				}
			}
		}
	}
	
	public int indexOf(T o){
		int index = 0;
		Nodo<T> actual = first;
		while (actual != null) {
			if (actual.getObject().equals(o)){
				return index;
			}
			index++;
			actual = actual.getNext();
		}
		return -1;
	}

	public int length(){
		return this.cantidad;
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
		return new Iterador<T>(first);
	}
	
	private class Iterador<T> implements Iterator<T>{
		private Nodo<T> actual;
		
		public Iterador(Nodo<T> n){
			this.actual = n;
		}
		
		@Override
		public boolean hasNext() {			
			return actual != null;
		}

		@Override
		public T next() {			
			T temp = actual.getObject();
			actual = actual.getNext();
			return temp;
		}
	}
}
