package TP4.Ej_3;

import java.util.ArrayList;

public class Conjunto {
    

    /* public ArrayList<ArrayList<Integer>> subSets(int value){    
        int possition = 0;    
        return subSets(partialSolution, value, this.addition, possition);
    }

    private ArrayList<ArrayList<Integer>> subSets(ArrayList<Integer> partialSolution, int value, int addition, int possition){
        if (addition == value){
            this.solution.add(partialSolution);
            addition = 0;
        } else {              
                   //possition = 0;             
                    //if (addition < value){
                        Integer num = set[possition];
                        partialSolution.add(num);
                        addition += num;
                        subSets(partialSolution, value, addition, possition+1);
                        partialSolution.remove(num);
                        addition = 0;
                   // }
                }
        
        return solution;
    } */

    public ArrayList<ArrayList<Integer>> findSubsets(int[] nums, int targetSum) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        backtrack(nums, subsets, new ArrayList<>(), targetSum, 0);
        return subsets;
    }

    private void backtrack(int[] nums, ArrayList<ArrayList<Integer>> subsets, ArrayList<Integer> currentSubset, int targetSum, int start) {
        if (targetSum == 0 && !subsets.contains(currentSubset)) {
            subsets.add(new ArrayList<>(currentSubset));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (targetSum - nums[i] >= 0) {
                currentSubset.add(nums[i]);
                backtrack(nums, subsets, currentSubset, targetSum - nums[i], i + 1);
                currentSubset.remove(currentSubset.size() - 1);
            }
        }
    }
}
