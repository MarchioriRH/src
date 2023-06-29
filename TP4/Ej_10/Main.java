package TP4.Ej_10;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> values = new Stack<>();
        int [] valuesArr = {-7, -3, -2, -1, 5, 8, -5, 7, -13};

        for (int i = 0; i < valuesArr.length;i++) {
            values.push(valuesArr[i]);
        }

        ZeroSubsets subsets = new ZeroSubsets();

        ArrayList<ArrayList<Integer>> res = subsets.bactracking(values, 4);
        
        for (ArrayList<Integer> a : res) {
            System.out.println(a.toString());
        }
    }
}
