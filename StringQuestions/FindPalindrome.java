package StringQuestions;

public class FindPalindrome {

        public static void main(String[] args) {
            System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
            System.out.println(isPalindrome("race a car")); // false
            System.out.println(isPalindrome(" ")); // true
            System.out.println(isPalindrome("ab@a")); // true
        }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Skip non-letter characters
            while (left < right && !isAlphanumeric(s.charAt(left))) {
                left++;
            }
            while (left < right && !isAlphanumeric(s.charAt(right))) {
                right--;
            }

            // Compare characters (case insensitive)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    private static boolean isAlphanumeric(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

}
