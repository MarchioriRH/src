package TP4.Ej_9;

import java.util.ArrayList;

public class OrderBoard {
    public int [][] board;
    public int initRow, initCol;
    public static int SIZE = 4;

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

    public void solve() {
        //backtrack();
    }

    public boolean backtrack() {
        if (board[SIZE -1][SIZE - 1] == 0) {
            if (isSolution())
                return true;
            else 
                return false;
        } else {
           // board[initRow][initCol] = board[initCol + 1] 
        }
        return false;

    }
}
