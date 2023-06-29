package TP4.Ej_3;

import java.util.ArrayList;

public class FindSubsets {
    private ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
    

    public ArrayList<ArrayList<Integer>> findSubsets(int[] nums, int targetSum) {
        //ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        //backtrack(nums, subsets, new ArrayList<>(), targetSum, 0);
        backtrack(nums, targetSum, new ArrayList<>(), 0);
        return subsets;
    }

    private void backtrack(int[] nums, ArrayList<ArrayList<Integer>> subsets, ArrayList<Integer> currentSubset, int targetSum, int start) {
        if (targetSum == 0 && !subsets.contains(currentSubset)) {
            subsets.add(new ArrayList<>(currentSubset));
            return;
        } else {
            for (int i = start; i < nums.length; i++) {
                if (targetSum - nums[i] >= 0) {
                    currentSubset.add(nums[i]);
                    backtrack(nums, subsets, currentSubset, targetSum - nums[i], i + 1);
                    currentSubset.remove(currentSubset.size() - 1);
                }
            }
        }
    }

    private boolean isSolution(ArrayList<Integer> currentSolution, int target) {
        for (int i : currentSolution)
            target -= i;
        return target == 0;
    }

    private void backtrack(int[] nums, int target, ArrayList<Integer> currentSolution, int index) {      
        if (isSolution(currentSolution, target)) {
            if (!subsets.contains(currentSolution))
                subsets.add(new ArrayList<>(currentSolution));
        } else {
            if (index < nums.length) {
                int x = nums[index];
                backtrack(nums, target, currentSolution, index + 1);
                nums[index] = x;

                x = nums[index];
                currentSolution.add(x);
                backtrack(nums, target, currentSolution, index + 1); 
                currentSolution.remove(Integer.valueOf(x));
                nums[index] = x;
            }
        }
    }
}
