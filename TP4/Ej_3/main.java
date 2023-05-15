package TP4.Ej_3;

import java.util.ArrayList;

public class main {
    public static void main (String[] args){
        int[] set = new int[10] ;

        set[0] = 1;
        set[1] = 7;
        set[2] = 3;
        set[3] = 3;
        set[4] = 8;
        set[5] = 9;
        set[6] = 1;
        set[7] = 2;
        set[8] = 4;
        set[9] = 6;


        Conjunto c = new Conjunto();
        ArrayList<ArrayList<Integer>> result = c.findSubsets(set,33);

        for(ArrayList<Integer> array : result)
            System.out.println(array);
    }
}
