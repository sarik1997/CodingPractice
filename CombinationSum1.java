import java.util.*;

/**
 * 	•	You’re given an array of distinct integers candidates and a target sum.
 * 	•	You can use the same number unlimited times.
 * 	•	Return all unique combinations that sum up to the target.
 *
 * ⸻
 *
 * ✅ Problem Recap
 *
 * Find all combinations where numbers can be used multiple times, and the sum equals the target.
 */
public class CombinationSum1 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), results);
        return results;
    }

    private void backtrack(int[] candidates, int target, int start,
                           List<Integer> current, List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) continue;

            current.add(candidates[i]);
            // Allow reuse of same element → i (not i + 1)
            backtrack(candidates, target - candidates[i], i, current, results);
            current.remove(current.size() - 1); // backtrack
        }
    }

    // Test
    public static void main(String[] args) {
        CombinationSum1 solver = new CombinationSum1();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = solver.combinationSum(candidates, target);
        System.out.println(result);
    }
}