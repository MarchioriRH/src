package TP2.Ej_3;

import TP1.Timer;
import TP2.Ej_2.*;

public class OrderComparation<T extends Comparable<? super T>> {
    public Integer[] generateArray(int n){
        Integer[] helper = new Integer[n];
        for (int i = 0; i < n; i++){
            helper[i] = (int) Math.floor(Math.random()*1000+1);
        }
        return helper;
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

        final int REPETICIONES = 1000;
        final int ELEMENTOS = 100;
        OrderComparation<Integer> oc = new OrderComparation<>();
        
        MergeSort<Integer> ms = new MergeSort<>();
        Timer t = new Timer();
        t.start();
        for (int i = 0; i < REPETICIONES; i++){
            Integer[] arr = oc.generateArray(ELEMENTOS);
            ms.sort(arr);
        }
        System.out.println("Tiempo ejecucion MergeSort X " + REPETICIONES + " veces (arreglo aleatorio de " + ELEMENTOS + " enteros): " + t.stop() + " ms.");

        QuickSort<Integer> qs = new QuickSort<>();
        t.start();
        for (int i = 0; i < REPETICIONES; i++){
            Integer[] arr = oc.generateArray(ELEMENTOS);
            qs.sort(arr);
        }
        System.out.println("Tiempo ejecucion QuickSort X " + REPETICIONES + " veces (arreglo aleatorio de " + ELEMENTOS + " enteros): " + t.stop() + " ms.");

    }
}
