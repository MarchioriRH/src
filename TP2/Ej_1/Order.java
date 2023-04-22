package TP2.Ej_1;

public class Order <T extends Comparable<? super T>> {
    
    public void boobleSort (T[] arr){       //COMPLEJIDAD: O(n^2)
        boolean swapped = true;
        int j = 0;
        T tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < arr.length - j; i++) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }
    
    public void selectionSort(T[] arr){     //COMPLEJIDAD: O(n^2)
        T tmp, aux;
        int index = 0;
        for (int i = 0; i < arr.length; i++){
            tmp = arr[i];
            for (int j = i + 1; j < arr.length; j++){
                if (tmp.compareTo(arr[j]) > 0){
                    tmp = arr[j];
                    index = j;
                }
            }
            if (index != 0){
                aux = arr[i];
                arr[i] = tmp;
                arr[index] = aux;
                index = 0;
            }
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

    public static void main(String[] args){
        Integer[] arrA = {34, 55, 1, 6, 99, 3, 9, 33, 109, 1005, 8, 19, 35};
        Integer[] arrB = {34, 55, 1, 6, 99, 3, 9, 33, 109, 1005, 8, 19, 35};
        Order<Integer> o = new Order<>();
        System.out.println("----------------------- BOOBLESORT ADAPTATIVO -----------------------");
        System.out.println("Array desordenado: "+ o.toString(arrA));
        o.boobleSort(arrA);
        System.out.println("Array ordenado: "+ o.toString(arrA));
        System.out.println("----------------------- SELECTIONSORT -----------------------");
        System.out.println("Array desordenado: "+ o.toString(arrB));
        o.selectionSort(arrB);
        System.out.println("Array ordenado: "+ o.toString(arrB));
    }
}
