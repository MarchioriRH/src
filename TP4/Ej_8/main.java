package TP4.Ej_8;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Pyramid guiza = new Pyramid(3, 20);
        ArrayList<int[]> res =  guiza.solve();
        if (!res.isEmpty()) {
            System.out.println("Posibles soluciones: ");
            for (int[] a : res) {
                guiza.printPyramid(a);           
                System.out.println();
            }
        } else {   
            System.out.println("No se encontro solucion.");
        }

        // int[] arr = {8,5,3,4,1,2};
        // System.out.println(guiza.isSolutionPrueba(arr));
    }
}
