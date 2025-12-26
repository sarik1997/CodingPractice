package StringQuestions;

import java.util.*;

public class LongestUniqueSubstring {

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int maxLen = 0;
        int left = 0;
        int startIdx = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            while (seen.contains(current)) {
                seen.remove(s.charAt(left));
                left++; // shrink from the left
            }

            seen.add(current);
            if (right - left + 1 > maxLen) {
                maxLen = right - left + 1;
                startIdx = left;  // remember where the max window starts
            }
            //if we dont want string only length then this and above if is not req
//            maxLen = Math.max(maxLen, right - left + 1);
        }
    System.out.println(s.substring(startIdx, startIdx + maxLen));
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));  // 3
        System.out.println(lengthOfLongestSubstring("bbbbb"));     // 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));    // 3
        System.out.println(lengthOfLongestSubstring(""));          // 0
    }
}