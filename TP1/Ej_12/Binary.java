package TP1.Ej_12;

import java.util.Scanner;

public class Binary {
    public String inBinary(Integer num){
        String res = "";
        return inBinaryOp(num, res);
    }

    private String inBinaryOp(Integer num, String res){
        // Caso base, si el numero se redujo a 1 o o, retorna la cadena con
        // el ultimo resto y la invierte 
        if (num <= 1)
            return (num % 2) + res;    
        // Deprecated: la linea siguiente se quito por agregar complejidad al algoritmo
        // return new StringBuilder(res + (num % 2)).reverse().toString();
        // Se obtiene el resto de la division por 2.
        int resto = num % 2;
        // Se obtiene el cociente
        int cociente = num / 2;
        // Se agrega a la cadena el resto obtenido en la division.
        res = resto + res;
        
        return inBinaryOp(cociente, res);
    }

    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)){
            Binary b = new Binary();
            System.out.print("Ingrese el decimal a convertir en binario: ");
            Integer data = scanner.nextInt();
            System.out.println("Resultado: "+b.inBinary(data));
        }
    }
}
