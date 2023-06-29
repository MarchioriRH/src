package TP4.Ej_4;

import java.util.ArrayList;
import java.util.Stack;

public class main {
    public static void main (String[] args){
        int[] arrNums = new int[13] ;

        arrNums[0] = 1;
        arrNums[1] = 43;
        arrNums[2] = 9;
        arrNums[3] = 6;
        arrNums[4] = 12;
        arrNums[5] = 45;
        arrNums[6] = 11;
        arrNums[7] = 5;
        arrNums[8] = 4;
        arrNums[9] = 8;
        arrNums[10] = 17;
        arrNums[11] = 2;
        arrNums[12] = 10;

        Stack<Integer> pilaNums = new Stack<>();

        for (int i = arrNums.length - 1; i >= 0; i--)
            pilaNums.push(arrNums[i]);


        // DisjointAddition set = new DisjointAddition();
        // ArrayList<ArrayList<Integer>> result = set.findSubsets(arrNums);

        DisjointAddition set = new DisjointAddition();
        ArrayList<ArrayList<Integer>> result = set.subsetsAddition(pilaNums);

        for(ArrayList<Integer> array : result)
            System.out.println(array);
    }
}
