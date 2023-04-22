package TP1.Ej_2;

public class Main {
    public static void main (String [] args){
        Pila<Integer> P1 = new Pila<>();

        P1.push(2);
        P1.push(8);
        P1.push(3);
        P1.push(14);
        P1.push(1);
        System.out.println("Pila: "+P1.toString());
        P1.push(33);        
        System.out.println("Pila: "+P1.toString());
        System.out.println("Pull: "+P1.pull());
        System.out.println("Pila: "+P1.toString());
        System.out.println("Top: "+P1.top());
        System.out.println("Reverse...");
        P1.reverse();
        System.out.println("Pila: "+P1.toString());

    }
}
