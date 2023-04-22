package TP1.Ej_10;

public class Order <T extends Comparable<? super T>> {

    public Integer isInOrder(T[] arr){
        int index = 0;
        // Retorna TRUE si alguna de las dos busquedas es verdadera
        if (isInOrderAsc(arr, index))
            return 1;
        else if (isInOrderDesc(arr, index))
                return -1;
            else 
                return 0;
    }

    private boolean isInOrderAsc(T[] arr, int index){
        // Caso base, el arreglo tiene un elemento
        if (arr.length < 2)
            return true;
        // Verifica que el orden ascendente se mantenga
        if (arr[index].compareTo(arr[index + 1]) > 0)
            return false;
        // Se llama recursivamente con el arreglo con el elemento 0 truncado.
        // Deprecated: la siguiente linea solo agrega complejidad.
        // Integer[] aux = Arrays.copyOfRange(arr, index + 1, arr.length);        
        if (index + 1 >= arr.length - 1)
            return true;
        else
            return isInOrderAsc(arr, index + 1);       
    }

    private boolean isInOrderDesc(T[] arr, int index){
        // Caso base, el arreglo tiene un elemento
        if (arr.length < 2)
            return true;
        // Verifica que el orden ascendente se mantenga
        if (arr[index].compareTo(arr[index + 1]) < 0)
            return false;
        // Se llama recursivamente con el arreglo con el elemento 0 truncado.
        // Deprecated: la siguiente linea solo agrega complejidad.
        // Integer[] aux = Arrays.copyOfRange(arr, index + 1, arr.length); 
        if (index + 1 >= arr.length - 1)
            return true;
        else        
            return isInOrderDesc(arr, index + 1);       
    }


    public static void main(String[] args){
        Integer[] arr = {40, 200, 300};
        Order<Integer> o = new Order<>();
        if (o.isInOrder(arr) == 1)
            System.out.println("Arreglo ordenado ascendentemente.");
        else if (o.isInOrder(arr) == -1)
                System.out.println("El arreglo esta ordenado descendentemente.");
            else
                System.out.println("El arreglo se encuentra desordenado.");
    }
}
