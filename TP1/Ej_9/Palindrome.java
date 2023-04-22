package TP1.Ej_9;

import java.util.Scanner;

public class Palindrome {

    public boolean isPalindrome(String word){
        int firstChar = 0;
        int lastChar = word.length() - 1;
        return isPalindrome(word, firstChar, lastChar);
    }

    private boolean isPalindrome(String word, int firstChar, int lastChar) {
        // Si la longitud de la palabra es 0 o 1, entonces es palíndromo
        if (firstChar >= lastChar) {
            return true;
        }
        
        // Si el primer caracter es diferente al último, entonces no es palíndromo
        if (word.charAt(firstChar) != word.charAt(lastChar)) 
            return false;
        
        // Caso recursivo:
        // Se comparan los caracteres que están en las posiciones 
        // intermedias de la palabra, es decir, desde el segundo 
        // hasta el penúltimo
        // 
        //DEPRECATED: agrega complejidad (String subword = word.substring(1, word.length() - 1);)
        // El resultado será verdadero si la sub-palabra también es palíndromo
        return isPalindrome(word, firstChar + 1, lastChar -1);
    }

    public static void main (String[] args){
        try (Scanner scanner = new Scanner(System.in)){
            Palindrome p = new Palindrome();
            System.out.print("Ingrese la palabra para combrobar si es palindromo: ");
            String data = scanner.nextLine();
            data = data.toLowerCase();
            if (p.isPalindrome(data))
                System.out.println("La palabra ingresada es un palindromo.");
            else
                System.out.println("La palabra ingresada no es un palindromo.");
        }
    }
}