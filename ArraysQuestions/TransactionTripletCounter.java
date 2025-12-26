package ArraysQuestions;

public class TransactionTripletCounter {

    public static int getTransactionTripletCount(int[] transactionHistory, int divisor) {
        int count = 0;
        int n = transactionHistory.length;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    long sum = (long)transactionHistory[i] + transactionHistory[j] + transactionHistory[k];
                    if (sum % divisor == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    // Example usage
    public static void main(String[] args) {
        int[] transactionHistory = {3, 7, 2, 9, 1};
        int divisor = 5;
        int result = getTransactionTripletCount(transactionHistory, divisor);
        System.out.println("Number of valid triplets: " + result);  // Output example
    }
}