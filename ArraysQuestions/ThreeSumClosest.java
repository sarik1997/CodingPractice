package ArraysQuestions;

import java.util.Arrays;


public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        int closestSum = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int left = i + 1;
            int right = length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                if (currentSum == target) {
                    return currentSum;
                }
                //abs because have to write for negative current - target and closestSum - target again.
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                if (currentSum > target) {
                    right--;
                } else {
                    left++;
                }

            }

        }
        return closestSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 2, 1, -4};
        System.out.println(threeSumClosest(arr, 1));
    }

}

