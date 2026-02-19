package ArraysQuestions;

public class MissingNumber {

    public static void main(String[] args) {

        int[] nums = {3, 0, 1};
        System.out.println("Missing Number: " + missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;

        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
}