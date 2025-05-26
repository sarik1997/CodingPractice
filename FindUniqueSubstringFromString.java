public class FindUniqueSubstringFromString {
    // Method to count the number of special substrings
    // A special substring consists of a unique character
    public int numberOfSpecialSubstrings(String s) {
        int n = s.length(); // Length of the string
        int specialSubstrCount = 0; // Counter for special substrings
        int[] charCount = new int[26]; // Count array for each character 'a'-'z'

        // Using two pointers, 'start' and 'end', to define the current substring
        for (int start = 0, end = 0; start < n; ++start) {
            // 'currentCharIdx' is the index based on the current character
            int currentCharIdx = s.charAt(start) - 'a';
            // Increase the count for the current character
            ++charCount[currentCharIdx];

            // If there is more than one occurrence of the character, move 'end' forward
            // to reduce the count of the character at the 'end' pointer
            while (charCount[currentCharIdx] > 1) {
                --charCount[s.charAt(end++) - 'a'];
            }

            // The number of special substrings that end at 'start' equals 'start' - 'end' + 1
            // because all substrings between 'end' and 'start' (inclusive) are special
            specialSubstrCount += start - end + 1;
        }

        return specialSubstrCount; // Return the total count of special substrings
    }

    public static void main(String[] args) {
        String s2 = "hello";
        FindUniqueSubstringFromString find = new FindUniqueSubstringFromString();
        System.out.println(find.numberOfSpecialSubstrings("abc"));
    }
}
