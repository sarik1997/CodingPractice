package ArraysQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeANDFourSum {
    public static void main(String[] args) {
        int[] arr = new int[]{-4, -1, 0, 2, 3, -4, -5, -6, -1, -1, 2, -2, 3, -3, 5, 9, -8};
        System.out.println("Three Sum :");
        System.out.println(threeSum(arr));
        System.out.println("Four Sum :");
        System.out.println(fourSum(arr, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) { //Edge case if length is less than 4.
            return result;
        }
        Arrays.sort(nums);
        for (int first = 0; first < length - 3; first++) {
            // Skip duplicate values for the first number
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // Second number: iterate through possible second elements
            for (int second = first + 1; second < length - 2; second++) {
                // Skip duplicate values for the second number
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                int left = second + 1;
                int right = length - 1;
                while (left < right) {
                    long sum = (long)nums[first] + nums[second] + nums[right] + nums[left];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        result.add(List.of(nums[first], nums[second], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
            }

        }
        return result;

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

