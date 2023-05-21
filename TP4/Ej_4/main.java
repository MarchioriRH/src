package TP4.Ej_4;

import java.util.ArrayList;

public class main {
    public static void main (String[] args){
        int[] arrNums = new int[10] ;

        arrNums[0] = 1;
        arrNums[1] = 43;
        arrNums[2] = 9;
        arrNums[3] = 6;
        arrNums[4] = 12;
        arrNums[5] = 7;
        arrNums[6] = 11;
        arrNums[7] = 5;
        arrNums[8] = 4;
        arrNums[9] = 8;


        DisjointAddition set = new DisjointAddition();
        ArrayList<ArrayList<Integer>> result = set.findSubsets(arrNums);

        for(ArrayList<Integer> array : result)
            System.out.println(array);
    }
}
