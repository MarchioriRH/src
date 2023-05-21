package TP4.Ej_3;

import java.util.ArrayList;

public class FindSubsets {
    

    public ArrayList<ArrayList<Integer>> findSubsets(int[] nums, int targetSum) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        backtrack(nums, subsets, new ArrayList<>(), targetSum, 0);
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
}
