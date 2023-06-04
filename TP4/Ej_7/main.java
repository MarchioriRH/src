package TP4.Ej_7;

import java.util.ArrayList;

public class main {

    public static void printSolution(int [][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}    
    
    public static void main(String[] args) {
        
        MagicBoard panel = new MagicBoard(3);
        //panel.populateBoard(10, 15);
        System.out.println("Panel de 3x3, numeros 10, nro magico 15.");
        System.out.println("Posibles soluciones: ");
        ArrayList<int[][]> aux = new ArrayList<>();
        aux = panel.populateBoardB(10, 15);
        for (int[][] p : aux) {
            printSolution(p);
        }
    }
}
