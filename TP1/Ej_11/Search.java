package TP1.Ej_11;

import java.util.Scanner;
import TP1.Timer;

public class Search <T extends Comparable<? super T>>{

    public boolean searchElem(T[] arr, T elem){
        return searchElem(arr, elem, 0);
    }

    private boolean searchElem(T [] arr, T elem, int index){
        // Caso base, si indice llega al fina y el elemento no es el 
        // buscado retorna false.
        if(index == arr.length && !(arr[index - 1].equals(elem)))
            return false;
        // Si encuentra el elemento, retorna true.
        if(arr[index].equals(elem))
            return true;
        // Llamado recursivo con el indice aumentado en 1.
        return searchElem(arr, elem, index + 1);
    }

    public boolean searchElemBinary(T[] arr, T X){
        int init = 0;
        int end = arr.length - 1;
        return searchElemBinary(arr, X, init, end);
    }

    private boolean searchElemBinary(T[] arr, T X, int init, int end){       
        int half;
        if (init > end) 
            return false; 
        else {
            half = (init + end) / 2; 
            if (X.compareTo(arr[half]) > 0)
                return searchElemBinary(arr, X, half + 1, end);
            else
                if (X.compareTo(arr[half]) < 0)
                    return searchElemBinary(arr, X, init, half - 1);
                else
                    return true;
        }
    }

    public static void main (String[] args){
        Timer t1 = new Timer();
        Search<Integer> s = new Search<>();
        Integer[] arr = {1, 2, 3, 7, 66, 77, 265, 676};
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Numero a buscar (no binaria): ");
            Integer dataA = scanner.nextInt();
            t1.start();
            System.out.println("Resultado: "+s.searchElem(arr, dataA));
            System.out.println("Time no binaria: "+t1.stop());

            t1.start();
            System.out.print("Numero a buscar (binaria): ");
            Integer dataB = scanner.nextInt();
            System.out.println("Resultado: "+s.searchElemBinary(arr, dataB));
            System.out.println("Time binaria: "+t1.stop());
        }
    }
}
