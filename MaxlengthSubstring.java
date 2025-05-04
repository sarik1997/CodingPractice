public class MaxlengthSubstring {
    public static String longestSameCharSubstring(String s) {
        if (s == null || s.isEmpty()) return "";

        int maxLen = 1, currentLen = 1, start = 0, maxStart = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currentLen++;
                if (currentLen > maxLen) {
                    maxLen = currentLen;
                    maxStart = start;
                }
            } else {
                currentLen = 1;
                start = i;
            }
        }
        System.out.println(maxLen);
        return s.substring(maxStart, maxStart + maxLen);
    }

    public static void main(String[] args) {
        String s = "aaabbccccddee";
        System.out.println("Longest same character substring length: " + longestSameCharSubstring(s));
    }
}
