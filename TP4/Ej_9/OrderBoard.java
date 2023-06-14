package TP4.Ej_9;

import java.util.ArrayList;

public class OrderBoard {
    private int [][] board;
    private int initRow, initCol;
    private static int SIZE = 3;
    private ArrayList<Coordinate> pasos;
    private ArrayList<int[][]> solucion;

    public OrderBoard(int initRow, int initCol) {
        this.board = new int[SIZE][SIZE];
        this.initCol = initCol;
        this.initRow = initRow;
        initBoard();
    }

    private void initBoard() {
        ArrayList<Integer> numbers = new ArrayList<>();
        int k = 0;
        while (k < (SIZE * SIZE -1)) {
            int value = (int) (Math.random() * (SIZE * SIZE -1)) + 1;
            if (!numbers.contains(value)) {
                numbers.add(value);
                k++;
            }
        }
        int m = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i != initRow || j != initCol) {
                    board[i][j] = numbers.get(m);
                    m++;  
                }
            }
        }
        board[initRow][initCol] = 0;
    }

    // Only for test
    /* public void initBoardForTesting(){
        int m = 1;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                    board[i][j] = m;
                    m++;  
                }
        }
        board[3][3] = 0;
    } */
    
    
    public void printSolution() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}  
    
    public boolean isSolution() {
        int k = 1;
        if (board[SIZE - 1][SIZE - 1] != 0)
            return false;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != k) 
                    return false;
                if (k == SIZE*SIZE - 1 && i == SIZE - 1)
                    k = 0;
                else
                    k++;
            }
        }
        return true;
    }

    // Metodo para obtener las posiciones validas para realizar un movimiento a partir de una celda
    private ArrayList<Coordinate> getValidPositions(int row, int column, ArrayList<Coordinate> pasos) {
        ArrayList<Coordinate> res = new ArrayList<>();
        if (row + 1 < SIZE && board[row  + 1][column] != 0) {
            Coordinate aux = new Coordinate(row + 1, column);
            if (!pasos.contains(aux))
                res.add(aux);
        }
        if (row - 1 >= 0 && board[row - 1][column] != 0) {
            Coordinate aux = new Coordinate(row - 1, column);
            if (!pasos.contains(aux))
                res.add(aux);
        }
        if (column + 1 < SIZE && board[row][column + 1] != 0) {
            Coordinate aux = new Coordinate(row, column + 1);
            if (!pasos.contains(aux))
            res.add(aux);
        }
        if (column - 1 >= 0 && board[row][column - 1] != 0) {
            Coordinate aux = new Coordinate(row, column - 1);
            if (!pasos.contains(aux))
                res.add(aux);
        }
        return res;
    }

    private int[][] arrayCopy(int[][] origin) {
        int [][] copy = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++) {
                copy[i][j] = origin[i][j];
            }
        }
        return copy;
    }

    private boolean isValidEstado(ArrayList<int[][]> estado) {
        int cont = 0;
        boolean notSame = true;

        for (int[][] mat : estado) {
            
            cont++;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (mat[i][j] != board[i][j]) {
                        //System.out.println("Boards counter "+cont);
                        notSame = false;
                    } else  
                        notSame = true;
                }
            }

        }
        //System.out.println("Boards counter "+cont);
        return notSame == true ? true : false;
    }

    public void solve() {
        ArrayList<int[][]> estado = new ArrayList<>();
        this.solucion = new ArrayList<>();
        this.pasos = new ArrayList<>();
        
        int iteraciones = 0;
        backtrack(iteraciones, initRow, initCol, estado, pasos);
    }

    public void backtrack(int iteraciones, int row, int col, ArrayList<int[][]> estado, ArrayList<Coordinate> pasos) {
        if (board[SIZE -1][SIZE - 1] == 0) {
            System.out.println("Entro");
            //printSolution();
            if (isSolution()) {
                System.out.println("Entro solucion"); 
                int[][] copy = new int [SIZE][SIZE];
                copy = arrayCopy(board);
                solucion.add(copy);                             
                //return true;
            } else {
                //System.out.println("Borro pasos"); 
                pasos.clear();
                //return false;
            }
        } else {
                iteraciones++;
                if (estado.isEmpty() || isValidEstado(estado)) {   
                  // System.out.println("pasos "+pasos); 
                    //Coordinate coord = new Coordinate(row, col);
                    if (estado.isEmpty()) {
                        int[][] copy = new int[SIZE][SIZE];
                        copy = arrayCopy(board);
                        estado.add(copy);
                    }
                    if (iteraciones == 30) 
                         System.out.println("l");;                
                    for (Coordinate coord : getValidPositions(row, col, pasos)) {           
                        
                        
                        int[][] copy = new int [SIZE][SIZE];                       
                        pasos.add(coord);
                        board[row][col] = board[coord.getRow()][coord.getColumn()];
                        board[coord.getRow()][coord.getColumn()] = 0;
                        copy = arrayCopy(board);                      
                        estado.add(copy);
                        backtrack(iteraciones, coord.getRow(), coord.getColumn(), estado, pasos);
                            //return true;
                        estado.remove(copy);
                        board[coord.getRow()][coord.getColumn()] = board[row][col];
                        board[row][col] = 0;                        
                        pasos.remove(coord);
                    }
                }
        }
       // return false;
    }

}

