package ArraysQuestions;

import java.util.*;

/**
 * 	Finds all unique combinations in a given array candidates where the numbers sum to a target.
 * 	•	Each number can be used at most once.
 * 	•	The solution must not contain duplicate combinations.
 *
 * ⸻
 *
 * ✅ Problem Recap
 *
 * Given a collection of candidate numbers candidates (may contain duplicates) and a target number, find all unique combinations that sum to the target.
 * Each number in candidates may only be used once in each combination.
 */
public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates); // Sort to handle duplicates
        backtrack(candidates, target, 0, new ArrayList<>(), results);
        return results;
    }

    private void backtrack(int[] candidates, int target, int start,
                           List<Integer> combination, List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates at same level
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            if (candidates[i] > target) break; // Prune the search

            combination.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, combination, results); // i+1 to not reuse same number
            combination.remove(combination.size() - 1); // backtrack
        }
    }

    // Test
    public static void main(String[] args) {
        CombinationSum2 solver = new CombinationSum2();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> result = solver.combinationSum2(candidates, target);
        System.out.println(result);
    }
}
