package TP4.Ej_9;

public class Main {

    public static void main(String[] args) {

        OrderBoard panel = new OrderBoard(2, 2 );
        
        panel.printSolution();

        System.out.println(panel.isSolution());
    }
    
}
