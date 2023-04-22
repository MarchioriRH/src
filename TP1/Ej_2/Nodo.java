package TP1.Ej_2;

public class Nodo<T>{
	private Nodo<T> Next;
	private T obj;
	
	public Nodo(T o){
		this.Next = null;
		this.obj = o;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
	
	public T getObject(){
		return this.obj;
	}

	public Nodo<T> getNext(){
		return this.Next;
	}
	
	public void setNext(Nodo<T> n){
		this.Next = n;
	}
	
	@Override
	public String toString() {
		return obj.toString();
	}
}
