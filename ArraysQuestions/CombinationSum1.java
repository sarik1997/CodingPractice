package ArraysQuestions;

import java.util.*;

/**
 * •	You’re given an array of distinct integers candidates and a target sum.
 * •	You can use the same number unlimited times.
 * •	Return all unique combinations that sum up to the target.
 * <p>
 * ⸻
 * <p>
 * ✅ Problem Recap
 * <p>
 * Find all combinations where numbers can be used multiple times, and the sum equals the target.
 */
public class CombinationSum1 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        backtrack(candidates, target, current, result, 0);
        return result;
    }

    public static void backtrack(int[] candidates, int remainingSum, List<Integer> current, List<List<Integer>> result, int index) {
        if (remainingSum == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (remainingSum < 0 || index > candidates.length-1) {
            return;
        }
        current.add(candidates[index]);
        // we can repeat same element so index here is same
        backtrack(candidates, remainingSum - candidates[index], current, result, index);
        current.remove(current.size() - 1);
        // changing index for considering other element
        backtrack(candidates, remainingSum, current, result, index + 1);

    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result);
    }
}