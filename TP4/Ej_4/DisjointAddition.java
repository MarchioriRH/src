package TP4.Ej_4;

import java.util.ArrayList;

public class DisjointAddition {

    public ArrayList<ArrayList<Integer>> findSubsets(int[] nums) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        backtrack(nums, subsets, new ArrayList<>(), 0);
        return subsets;
    }

    private void backtrack(int[] nums, ArrayList<ArrayList<Integer>> subsets, ArrayList<Integer> currentSubset, int start) {
        ArrayList<Integer> subSetaux = new ArrayList<>();
        for (int i = start; i < nums.length; i++)
            subSetaux.add(nums[i]);
        if (check(currentSubset, subSetaux, nums)) {
            subsets.add(new ArrayList<>(currentSubset));
            subsets.add(new ArrayList<>(subSetaux));
            return;            
        } else  {
            for (int i = start; i < nums.length; i++) {
                if (i < nums.length) {
                    currentSubset.add(nums[i]);
                    backtrack(nums, subsets, currentSubset, i + 1);
                    currentSubset.remove(currentSubset.size() - 1);
                }
            }
        }
    }

    private boolean check(ArrayList<Integer> currentSubset, ArrayList<Integer> subSetaux, int[] nums) {
        return (areDisjoints(currentSubset, subSetaux) && arrayAddition(currentSubset) == arrayAddition(subSetaux)
            && (currentSubset.size() + subSetaux.size()) == nums.length);
    }

    private int arrayAddition(ArrayList<Integer> arr) {
        int res = 0;
        for (Integer i : arr)
            res += i;
        return res;
    }

    private boolean areDisjoints(ArrayList<Integer> currentSubset, ArrayList<Integer> subSetaux) {
        for (Integer i : currentSubset){
            if (subSetaux.contains(i))
                return false;
        }
        return true;
    }
}

