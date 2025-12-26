package ArraysQuestions;

public class TwoMissingSorted {

        public static int[] findTwoMissing(int[] arr, int n) {
            int missing1 = -1, missing2 = -1;
            int idx = 0;

            for (int num = 1; num <= n; num++) {
                if (idx < arr.length && arr[idx] == num) {
                    idx++;  // number is present
                } else {
                    // number is missing
                    if (missing1 == -1) missing1 = num;
                    else missing2 = num;
                }
            }

            return new int[]{missing1, missing2};
        }

        public static void main(String[] args) {
            int[] arr = {1, 2, 4, 6, 7}; // sorted array
            int n = 7;

            int[] result = findTwoMissing(arr, n);
            System.out.println(result[0] + " " + result[1]);  // Output: 3 5
        }

}
