package TP1.Ej_13;

import java.util.Scanner;

public class Fibonacci {
    public String fibonacci(int limit){
        String res = "";
        // En este ciclo se obtiene la cadena de numeros de Fibonacci.
        for(int i = 0; i < limit; i++){
            if (res == "")
                res = res + obtenerFibonacci(i);
            else
                res = res + " - " + obtenerFibonacci(i);
        }
        return res;
    }

    private Integer obtenerFibonacci(int limit){
        // Caso base, si limite es menor que dos, devuele el valor limite.
        if (limit < 2)
            return limit;
        else 
            // Si no, devuelve recursivamente el calculo de valor de Fibonnacci.
            return (obtenerFibonacci(limit - 1) + obtenerFibonacci(limit - 2));
        
    }

    public static void main (String[] args){
        try (Scanner scanner = new Scanner(System.in)){
            Fibonacci f = new Fibonacci();
            System.out.print("Ingrese cuantos numeros de la secuencia de Fibonacci quiere obtener: ");
            Integer data = scanner.nextInt();
            System.out.println("Resultado: "+f.fibonacci(data));
        }
    }
}
