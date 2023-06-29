package TP4.Ej_4;

import java.util.ArrayList;
import java.util.Stack;

public class DisjointAddition {
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();


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

    public ArrayList<ArrayList<Integer>> subsetsAddition(Stack<Integer> nums) {
        ArrayList<Integer> subSet1 = new ArrayList<>();
        ArrayList<Integer> subSet2 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> bothSubsets = new ArrayList<>();
        bothSubsets.add(subSet1);
        bothSubsets.add(subSet2);
        res = new ArrayList<>(bothSubsets);
        backtrackB(nums, bothSubsets);        
        return res;
    }

    private boolean backtrackB(Stack<Integer> nums, ArrayList<ArrayList<Integer>> bothSubsets) {
        if (nums.isEmpty()) {
            if (checkDisjoints(bothSubsets)) {
                res = new ArrayList<>(bothSubsets);
                return true;
            }
        } else {
            int x = nums.pop();
            for (ArrayList<Integer> subSet : bothSubsets) {
                subSet.add(x);
                if (backtrackB(nums, bothSubsets))
                    return true;
                subSet.remove(Integer.valueOf(x));
            }
            nums.push(x);
        }
        return false;
    }

    private boolean checkDisjoints(ArrayList<ArrayList<Integer>> subSets) {
        return (areDisjoints(subSets.get(0), subSets.get(1)) && arrayAddition(subSets.get(0)) == arrayAddition(subSets.get(1)));
    }
}

