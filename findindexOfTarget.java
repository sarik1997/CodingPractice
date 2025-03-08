import java.util.Arrays;

public class findindexOfTarget {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8))); // [3, 4]
        System.out.println(Arrays.toString(Solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6))); // [-1, -1]
        System.out.println(Arrays.toString(Solution.searchRange(new int[]{}, 0))); // [-1, -1]
        System.out.println(Arrays.toString(Solution.searchRange(new int[]{1, 1, 1, 1, 1}, 1))); // [0, 4]
        int[] index = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println("First occurence of " + 8 + " is at index " + index[0]);
        System.out.println("Last occurence of " + 8 + " is at index " + index[1]);
    }
    // O(n)
    public static int[] searchRange(int[] nums, int target) {
            int n = nums.length;
            int first = -1;
            int last = -1;
            int mid = n/2;
            for (int i = 0; i < n; i++) {
                if (target != nums[i])
                    continue;
                if (first == -1)
                    first = i;
                last = i;
            }
            return new int[]{first,last};
        }
    class Solution {
        public static int[] searchRange(int[] nums, int target) {
            int first = findBound(nums, target, true);  // Find first occurrence
            int last = findBound(nums, target, false); // Find last occurrence
            return new int[]{first, last};
        }
        //O(logn) binary search
        private static int findBound(int[] nums, int target, boolean isFirst) {
            int left = 0, right = nums.length - 1;
            int result = -1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    result = mid; // Found target, store index
                    if (isFirst) {
                        right = mid - 1; // Search towards left for first occurrence
                    } else {
                        left = mid + 1; // Search towards right for last occurrence
                    }
                } else if (nums[mid] < target) {
                    left = mid + 1; // Move right
                } else {
                    right = mid - 1; // Move left
                }
            }

            return result;
        }
    }

}

