package ArraysQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = new int[]{-4, -1, 0, 2, 3, -4, -5, -6, -1, -1, 2, -2, 3, -3, 5, 9, -8};
        System.out.println(threeSum(arr));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = len - 1;
            int requiredSum = -nums[i];
            while (left < right) {
                if (nums[left] + nums[right] == requiredSum) {
                    List<Integer> list = new ArrayList<>();
                    list.addAll(Arrays.asList(nums[i], nums[left], nums[right]));
                    result.add(list);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                } else if (nums[left] + nums[right] < requiredSum) {
                    left++;
                } else {
                    right--;
                }

            }
        }
        return result;
    }
}

