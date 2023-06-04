package TP5.Ej_1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Change c = new Change(3363);
        c.addChange(2000);
        c.addChange(1000);
        c.addChange(500);
        c.addChange(200);
        c.addChange(100);
        c.addChange(50);
        c.addChange(20);
        c.addChange(10);
        c.addChange(5);
        c.addChange(2);
        c.addChange(1);

        ArrayList<Integer> res = c.greedy();
        if (res.isEmpty())
            System.out.println("No hay solucion.");
        else    
            System.out.println("Solucion: " + res.toString());
    }
}
