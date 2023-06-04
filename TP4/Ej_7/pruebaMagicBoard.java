package TP4.Ej_7;

import java.util.Arrays;

public class pruebaMagicBoard {   

    private static int[][] matrix;
    private static int[] nums;
    private static int n;
    private static int k;
    private static int targetSum;
    private static boolean[] used;

    public static void main(String[] args) {
        n = 3; // Tamaño de la matriz (n x n)
        k = 10; // Tamaño del arreglo de números naturales (k > n * n)
        targetSum = 15; // Suma objetivo para cada fila y columna

        nums = new int[k];
        for (int i = 0; i < k; i++) {
            nums[i] = i + 1; // Generar números naturales mayores a 1
        }

        used = new boolean[k];
        matrix = new int[n][n];

        if (fillMatrix(0, 0)) {
            System.out.println("Se encontró una solución:");
            printMatrix();
        } else {
            System.out.println("No se encontró ninguna solución.");
        }
    }

    private static boolean fillMatrix(int row, int col) {
        if (row == n) {
            return true; // Se llenó toda la matriz
        }

        for (int i = 0; i < k; i++) {
            if (!used[i]) {
                int num = nums[i];

                if (isValidPlacement(row, col, num)) {
                    matrix[row][col] = num;
                    used[i] = true;

                    int nextRow = row;
                    int nextCol = col + 1;
                    if (nextCol == n) { // Cambiar a la siguiente fila si se llenó la columna actual
                        nextRow++;
                        nextCol = 0;
                    }

                    if (fillMatrix(nextRow, nextCol)) {
                        return true; // Se encontró una solución
                    }

                    used[i] = false; // Deshacer la selección si no lleva a una solución
                }
            }
        }

        return false; // No se encontró ninguna solución
    }

    private static boolean isValidPlacement(int row, int col, int num) {
        // Verificar que num no se repita en la misma fila o columna
        for (int i = 0; i < n; i++) {
            if (matrix[row][i] == num || matrix[i][col] == num) {
                return false;
            }
        }

        // Verificar que la suma de la fila y columna actual sea igual al objetivo
        int rowSum = Arrays.stream(matrix[row]).sum();
        int colSum = 0;
        for (int i = 0; i < n; i++) {
            colSum += matrix[i][col];
        }

        return rowSum + num <= targetSum && colSum + num <= targetSum;
    }

    private static void printMatrix() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}


