package TP4.Ej_10;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[] values = {-7, -3, -2, -1, 5, 8};

        ZeroSubsets subsets = new ZeroSubsets();

        ArrayList<ArrayList<Integer>> res = subsets.bactracking(values, 3);
        
        for (ArrayList<Integer> a : res) {
            System.out.println(a.toString());
        }
    }
}
