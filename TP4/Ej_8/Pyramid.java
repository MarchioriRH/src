package TP4.Ej_8;

import java.util.ArrayList;

public class Pyramid {
    private int[] pyramid;
    private int k, base;
    private ArrayList<int[]> solutions;
    private ArrayList<Integer> usedNumbers;

    public Pyramid(int base, int k){
        this.base = base;
        int res = 0;
        for (int i = 1; i <= base; i++)
            res += i;
        this.pyramid = new int[res];
        for (int i = 0; i < pyramid.length; i++)
            pyramid[i] = -1;
        this.usedNumbers = new ArrayList<>();
        this.k = k;
        this.solutions = new ArrayList<>();
    }

    public ArrayList<int[]> solve() {
        int initCell = 0;
        backtrack(initCell);
        return solutions;
    }

    public boolean backtrack(int actualCell) {
        if (actualCell >= pyramid.length) {
           //printPyramid();
            if (isSolution())
                return true;
        } else {
            int i = 1;
            while(i < k) {
                if (!usedNumbers.contains(i)) {
                
                    pyramid[actualCell] = i;
                    usedNumbers.add(i);
                    i++;                   
                   
                    if (backtrack(actualCell + 1)){
                        int[] aux = new int[pyramid.length];
                        for (int j = 0; j < pyramid.length; j++)
                            aux[j] = pyramid[j];
                        solutions.add(aux); 
                    }                

                    // Deshacer el movimiento                   
                    usedNumbers.remove(Integer.valueOf(pyramid[actualCell]));
                    pyramid[actualCell] = 0;
                }
                i++;
            }
        }
        return false;
    }

    // Metodo para saber si la piramide obtenida es una solucion
    public boolean isSolution() {
        int val = 0;
        for (int b = 1; b <= this.base; b++) {
            int i = 0;
            while ((i < b) && (val + b < pyramid.length)) {
                //if (pyramid[val] > 0) {
                    if (pyramid[val] != pyramid[b + val] + pyramid[b + val + 1])
                        return false;
                //}
                i++;
                val += 1;
            }            
        }
        return true;
    }

    public void printPyramid(int[] pyr) {
        int maxWidth = String.valueOf(k).length();

        int index = 0;
        for (int row = 0; row < base; row++) {
            for (int spaces = 0; spaces < base - row - 1; spaces++) {
                for (int i = 0; i < maxWidth; i++) {
                    System.out.print(" ");
                }
            }

            for (int col = 0; col <= row; col++) {
                int value = pyr[index++];
                String valueStr = (value == -1) ? "" : String.valueOf(value);

                for (int i = valueStr.length(); i < maxWidth; i++) {
                    System.out.print(" ");
                }

                System.out.print(valueStr);
                System.out.print(" ");
            }

            System.out.println();
        }
    }

}
