package TP2.Ej_2;

//import java.lang.reflect.Array;
import java.util.ArrayList;

// COMPLEJIDAD O(n log n)

public class MergeSort<T extends Comparable<? super T>>{
    private T[] numbers;
    private ArrayList<T> helper;
    private int size;
    
    public void sort(T[] values) {
        this.numbers = values;
        size = values.length;
       //this.helper = (T[]) Array.newInstance(values.getClass().getComponentType(), size);
       //this.numbers = new T[size];
        this.helper = new ArrayList<T>();
        mergesort(0, size - 1);
    }
    
    private void mergesort(int low, int high) {
        // si low es menor que high continua el ordenamiento
        // si low no es menor que high entonces el array está ordenado
        // ya que es el caso base donde el array tiene un solo elemento.
        if (low < high) {
            // obtener el indice del elemento que se encuentra en la mitad
            // al ser int redondea el resultado al entero menor
            int middle = (low + high) / 2;
            // ordenar la mitad izquierda del array – llamada recursiva
            mergesort(low, middle);
            // ordenar la mitad derecha del array – llamada recursiva
            mergesort(middle + 1, high);
            // combinar ambas mitades ordenadas
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {
        // copiar ambas partes al array helper
        for (int i = low; i <= high; i++) {
            helper.add(i, numbers[i]);
        }
        int i = low;
        int j = middle + 1;
        int k = low;
        // copiar de manera ordenada al array original los valores de la
        // mitad izquierda o de la derecha
        while (i <= middle && j <= high) {
            if (helper.get(i).compareTo(helper.get(j)) <= 0) {
                numbers[k] = helper.get(i);
                i++;
            } else {
                numbers[k] = helper.get(j);
                j++;
            }
            k++;
        }
        // si quedaron elementos copiarlos al array original
        while (i <= middle) {
            numbers[k] = helper.get(i);
            k++;
            i++;
        }
        while (j <= high) {
            numbers[k] = helper.get(j);
            k++;
            j++;
        }        
    }

    
	public String toString(T[] arr) {
		String res = "[";
		for (int i = 0; i < arr.length; i++ ) {
			if (i == arr.length - 1)
                res += arr[i];
            else
                res += arr[i] + " - ";
		}
        return res + "]";
	}

    
}
