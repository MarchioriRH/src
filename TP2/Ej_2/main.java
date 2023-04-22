package TP2.Ej_2;

public class main {
    public static void main(String[] args){
        Integer[] arrA = {34, 55, 1, 6, 99, 3, 9, 33, 109, 1005, 8, 19, 35};
        Integer[] arrB = {34, 55, 1, 6, 99, 3, 9, 33, 109, 1005, 8, 19, 35};
        MergeSort<Integer> ms = new MergeSort<>();
        System.out.println("----------------------- MERGESORT -----------------------");
        System.out.println("Array desordenado: "+ ms.toString(arrA));
        ms.sort(arrA);
        System.out.println("Array ordenado: "+ ms.toString(arrA));
        

        System.out.println("----------------------- QUICKSORT -----------------------");
        QuickSort<Integer> qs = new QuickSort<>();
        System.out.println("Array desordenado: "+ qs.toString(arrB));
        qs.sort(arrB);
        System.out.println("Array ordenado: "+ qs.toString(arrB));
    }
    
}
