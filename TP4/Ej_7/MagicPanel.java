package TP4.Ej_7;

import java.util.ArrayList;

public class MagicPanel {
    private int [][] magicPanel;
    private int [] numbers;

    public MagicPanel(int size) {
        this.magicPanel = new int[size][size];
        this.initPanel();
    }

    private void initPanel() {
        for (int i = 0; i < magicPanel.length; i++) {
            for (int j = 0; j < magicPanel.length; j++) {
                magicPanel[i][j] = 0;
            }
        }
    }

    public boolean isSolution(int [][] arr, int s) {
        int rowAddition = 0;
        int colAddition = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                rowAddition += arr[i][j];
                colAddition += arr[j][i];
            }    
            if (rowAddition != s || colAddition != s)        
                return false;
            rowAddition = 0;
            colAddition = 0;
        }
        return true;
    }

    private boolean isValidRowAddition(int row, int s) {
        int total = 0;
        for (int i = 0; i < magicPanel.length; i++)
            total += magicPanel[row][i];
        return total == s;
    }

    private boolean isValidColumnAddition(int column, int s) {
        int total = 0;
        for (int i = 0; i < magicPanel.length; i++)
            total += magicPanel[i][column];
        return total == s;
    }
    

    public int[] generateNumbers(int k) {
        int [] aux = new int[k];
        for (int i = 1; i < k; i++){
            aux[i] = k;
        }
        return aux;
    }

    public int[][] getSolution(int k, int s) { 
        int [][] solution = magicPanel;
        ArrayList<Integer> numbersUsed = new ArrayList<>();       
        int cellsCompleted = 0;
        int row = 0;
        int column = 0;
        this.numbers = generateNumbers(k);
        backtrack(s, row, column, cellsCompleted, solution, numbersUsed);
        return solution;
    }

    private void backtrack(int s, int row, int column, int cellsCompleted, int[][] solution, ArrayList<Integer> numbersUsed) {
        if (cellsCompleted == magicPanel.length * magicPanel.length)
            return;
        else {
           

        }
        
    }
}