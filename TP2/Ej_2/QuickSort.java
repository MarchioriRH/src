package TP2.Ej_2;

// COMPLEJIDAD: O(n^2), PROMEDIO O(n log n)

public class QuickSort<T extends Comparable<? super T>> {
    private T[] numbers;
    private int size;
    
    public void sort(T[] values) {
        this.numbers = values;
        size = values.length;
        quickSort(this.numbers, 0, size - 1);
    }
    
    private void quickSort(T[] arr, int izq, int der) {

        T pivote = arr[izq]; // tomamos primer elemento como pivote
        int i = izq;         // i realiza la búsqueda de izquierda a derecha
        int j = der;         // j realiza la búsqueda de derecha a izquierda
        T aux;
       
        while(i < j){                          // mientras no se crucen las búsquedas                                   
            while(arr[i].compareTo(pivote) <= 0 && i < j) 
                i++;                // busca elemento mayor que pivote
                while(arr[j].compareTo(pivote) > 0) 
                    j--;           // busca elemento menor que pivote
                    if (i < j) {                        // si no se han cruzado                      
                        aux = arr[i];                      // los intercambia
                        arr[i] = arr[j];
                        arr[j] = aux;
                    }             
            
        }
         
        arr[izq] = arr[j];    // se coloca el pivote en su lugar de forma que tendremos                                    
        arr[j] = pivote;      // los menores a su izquierda y los mayores a su derecha
         
        if(izq < j - 1)
            quickSort(arr, izq, j - 1);          // ordenamos subarray izquierdo
        if(j + 1 < der)
            quickSort(arr, j + 1, der);          // ordenamos subarray derecho
         
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
