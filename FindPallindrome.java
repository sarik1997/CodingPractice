public class FindPallindrome {
        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(sol.isPalindrome("A man, a plan, a canal: Panama")); // true
            System.out.println(sol.isPalindrome("race a car")); // false
            System.out.println(sol.isPalindrome(" ")); // true
            System.out.println(sol.isPalindrome("ab@a")); // true
        }

    }
class Solution {
    public boolean isPalindrome(String s) {
//        String s1 = s.toLowerCase(); // Convert to lowercase
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

    private boolean isAlphanumeric(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

}
