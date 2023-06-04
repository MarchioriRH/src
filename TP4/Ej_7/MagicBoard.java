package TP4.Ej_7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MagicBoard {
	private int [][] magicPanel;
    private Queue<Integer> validNumbers;
	private ArrayList<int[][]> solutions;
	private boolean[] usedValues;
	private int s, k, counter;

	
    public MagicBoard(int size) {
        this.magicPanel = new int[size][size];
		validNumbers = new LinkedList<>();
    }
	
	public void printSolution() {
		for (int i = 0; i < magicPanel.length; i++) {
			for (int j = 0; j < magicPanel.length; j++) {
				System.out.print(magicPanel[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}    

	private void initPanel() {
		for (int i = 0; i < magicPanel.length; i++) {
			for (int j = 0; j< magicPanel.length; j++) {
				magicPanel[i][j] = 1;
			}
		}
	}

	public boolean isSolution() {
		int rowAddition = 0;
		int colAddition = 0;
		for (int i = 0; i < magicPanel.length; i++) {
			for (int j = 0; j < magicPanel.length; j++) {
				rowAddition += magicPanel[i][j];
				colAddition += magicPanel[j][i];
			}    
			if (rowAddition != s || colAddition != s)        
				return false;
			rowAddition = 0;
			colAddition = 0;
		}
		return true;
	}
			
	private int isValidRowAddition(int row){
		int total = 0;
		for (int i = 0; i < magicPanel.length; i++)
			total += magicPanel[row][i];
		return total;
	}
	
	private int isValidColumnAddition(int column) {
		int total = 0;
		for (int i = 0; i < magicPanel.length; i++)
			total += magicPanel[i][column];
		return total;
	}
		
	private void generateNumbers(int k){
		for (int i = 1; i <= k; i++) {
			validNumbers.add(i);
		}
	}

	public boolean populateBoard(int k, int s){
		boolean res = false;
		generateNumbers(k);
		this.s = s;
		this.counter = 0;
		res = populateBoardFranco(0, 0);
		return res;
	}

	private boolean populateBoardFranco(int row, int column){
		boolean res = false;
		if (counter == magicPanel.length*magicPanel.length){
			return true;
		} else {
			int aux = validNumbers.size();
			while (!validNumbers.isEmpty() && aux > 0 && !res){
				magicPanel[row][column] = validNumbers.poll();
				counter++;									
				if (column < magicPanel.length-1) {
					if (row == magicPanel.length-1) {
						if (isValidColumnAddition(column) == s) {
							res = populateBoardFranco(row, column+1);
						}
					} else {
						res = populateBoardFranco(row, column+1);
					}
				} else if (isValidRowAddition(row) == s) {
					res = populateBoardFranco(row+1, 0);
				}				
				if (!res) {
					validNumbers.add(magicPanel[row][column]);
					magicPanel[row][column] = 0;
					counter--;
				}
				aux--;
			}
		}
		return res;
	}



    public ArrayList<int [][]> populateBoardB(int k, int s){
		this.usedValues = new boolean[k + 1];
		this.solutions = new ArrayList<>();
		this.s = s;
		this.k = k;
		this.counter = 0;
        int row = 0;
        int column = 0;
		backtrack(row, column, usedValues);
		return solutions;
	}

	private void backtrack(int row, int column, boolean [] usedValues){
		if (counter == magicPanel.length * magicPanel.length){
			if (isSolution()) {
				if (!solutions.contains(magicPanel)) {
					int [][] aux = new int[magicPanel.length][magicPanel.length];
					for (int k = 0; k < magicPanel.length; k++) {
						for (int j = 0; j< magicPanel.length; j++) {
							aux[k][j] = magicPanel[k][j];
						}
					}
					solutions.add(aux);
					initPanel();
					for (int j = 0; j <= k; j++)
						usedValues[j] = false;
				}
			} 
		} else {	
			int i = 1;
            while(i <= k) {
                if (usedValues[i] == false) {
					if (column == magicPanel.length && row < magicPanel.length) {
						row++;
						column = 0;
					}
					if (row == magicPanel.length) {
						row = 0;
						column = 0;
					}									
                    magicPanel[row][column] = i;
                    usedValues[i] = true;
					counter++;
					i++; 
					  				
                    // if (isValidColumnAddition(column) == s) {
					// 	if (backtrack(row, column + 1, usedValues)) {
					// 		return true;						
					// 	}
					// }
					// if (isValidRowAddition(row) == s) {
					// 	if (backtrack(row + 1, column, usedValues)) {
					// 		return true;
					// 	}
					// }
					backtrack(row, column + 1, usedValues);

					i--;
                    usedValues[i] = false;         
                    magicPanel[row][column] = 1;
					counter--;
                }
				i++;
            }
		}
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MagicBoard other = (MagicBoard) obj;
		if (!Arrays.deepEquals(magicPanel, other.magicPanel))
			return false;
		return true;
	}


	
}