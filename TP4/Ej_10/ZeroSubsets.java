package TP4.Ej_10;

import java.util.ArrayList;
import java.util.Collections;

public class ZeroSubsets {
    private ArrayList<ArrayList<Integer>> solutions;

    private boolean isValid(ArrayList<Integer> currentSolution) {
        int res = 0;
        for (int i = 0; i < currentSolution.size(); i++) {
            res += currentSolution.get(i);
        }
        return res == 0; 
    }

    private boolean isNotSame(ArrayList<Integer> current) {
        Collections.sort(current);
        return solutions.contains(current);
    }


    public ArrayList<ArrayList<Integer>> bactracking(int[] set, int n) {
        this.solutions = new ArrayList<>();
        int start = 0;
        ArrayList<Integer> currentSolution = new ArrayList<>();
        back(set, n, currentSolution, start);
;       return solutions;
    }


    private void back(int[] set, int n, ArrayList<Integer> currentSolution, int start) {
        if (currentSolution.size() == n) {
            if (isValid(currentSolution)) {
                ArrayList<Integer> aux = new ArrayList<>(currentSolution);
                if (!solutions.contains(aux) && !isNotSame(aux))
                    solutions.add(aux);
                currentSolution.clear();
            } 
        } else {
            for (int i = start; i < set.length; i++) {
                currentSolution.add(set[i]);
                if (currentSolution.size() <= n )
                    back(set, n, currentSolution, start + 1);
                currentSolution.remove(Integer.valueOf(set[i]));
            }
        }
    }
}
