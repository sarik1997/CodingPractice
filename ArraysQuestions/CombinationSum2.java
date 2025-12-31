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
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, curr, target, result, 0);
        return result;
    }
    public void backtrack(int[] candidates, List<Integer> curr,int remSum,List<List<Integer>> result ,int index){
        if(remSum == 0){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(index >= candidates.length  || remSum < 0 ){
            return;
        }
        curr.add(candidates[index]);
        backtrack(candidates, curr, remSum - candidates[index], result, index +1);
        curr.remove(curr.size() - 1);
        index++;
        while(index < candidates.length && candidates[index] == candidates[index-1]) {
            index++;
        }

        backtrack(candidates, curr, remSum , result, index);

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
