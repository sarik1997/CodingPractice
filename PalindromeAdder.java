public class PalindromeAdder {

    // Check if a number is a palindrome
    public static boolean isPalindrome(long num) {
        return num == reverse(num);
    }

    // Reverse digits of a number
    public static long reverse(long num) {
        long rev = 0;
        while (num != 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }

    // Perform the operation until we get a palindrome
    public static void findPalindrome(long num) {
        int iterations = 0;
        while (!isPalindrome(num)) {
            long reversed = reverse(num);
            num += reversed;
            iterations++;
        }
        System.out.println("Iterations: " + iterations);
        System.out.println("Palindrome: " + num);
    }

    public static void main(String[] args) {
        long input = 195; // You can change this to any number
        findPalindrome(input);
    }
}