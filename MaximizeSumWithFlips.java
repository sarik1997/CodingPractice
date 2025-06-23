import java.util.*;

public class MaximizeSumWithFlips {

    public static long maximize(List<Integer> array, int k) {
        // Sort list by absolute value descending
        array.sort((a, b) -> Integer.compare(Math.abs(b), Math.abs(a)));

        // Flip negative numbers first
        for (int i = 0; i < array.size() && k > 0; i++) {
            if (array.get(i) < 0) {
                array.set(i, -array.get(i));
                k--;
            }
        }
        // If k is odd, flip the element with the smallest absolute value
        /**
         * 🔍 What happens if k is even?
         * 	•	Flipping any number twice (once positive, once negative) brings it back to original.
         * 	•	E.g., 5 → -5 → 5 → no net effect
         * 	•	You can pair up the remaining flips
         * 	•	Use them on any number, and it won’t hurt the sum
         * ✅ No additional adjustment needed if k is even
         * 🔍 What happens if k is odd?
         * 	•	You have one unpaired flip remaining.
         * 	•	This flip must be applied
         * 	•	So, you will end up flipping one extra number
         * This will reduce the sum no matter what — but we can minimize the damage by flipping the number with the smallest absolute value.
         */
        if (k % 2 == 1) {
            // Find the minimum absolute value element's index
            int minIndex = 0;
            for (int i = 1; i < array.size(); i++) {
                if (Math.abs(array.get(i)) < Math.abs(array.get(minIndex))) {
                    minIndex = i;
                }
            }
            array.set(minIndex, -array.get(minIndex));
        }

        // Compute the sum
        long sum = 0;
        for (int num : array) {
            sum += num;
        }

        return sum;
    }

    // Example usage
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(-2, 0, 5, -1, 2);
        int k = 4;
        System.out.println("Maximized Sum: " + maximize(array, k));  // Output: 10
    }
}