package TP1.Ej_6_7;

import java.util.Iterator;

public class MyIterator<T> implements Iterator<T>{
        private Nodo<T> actual;
		
		public MyIterator(Nodo<T> n){
			this.actual = n;
		}

		public T getObj(){
			T tmp = actual.getObject();
			return tmp;
		}

		public void nextObj(){
			actual = actual.getNext();
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
