import java.util.*;

/**
 * 💬 Problem Statement:
 * Given:
 * 	•	A main word (target string),
 * 	•	A list of words,
 * 	•	And a search string (in which we will look for anagrams),
 *
 * Find and return the first word from the list whose anagram exists as a substring in the search string.
 * mainWord = "listen"
 * words = ["enlist", "google", "silent", "abc"]
 * searchString = "silexxntgoogle"
 *
 ✅ Approach (Using HashMap):
 Use a sliding window + frequency HashMap to check if any anagram of each word is a substring of searchString.
 Steps:
 1.	For each word in the list:
 •	Generate a frequency map of characters (targetMap)
 •	Use a sliding window of word length over the searchString
 •	At each position, build a frequency map for the substring (windowMap)
 •	If targetMap.equals(windowMap) → it’s an anagram → return the word
 */
public class AnagramFinder {
    public static void main(String args[]){
        String mainword = "listen";
        List<String> words = Arrays.asList("enlist", "google", "silent", "abc");
        System.out.print(findWordWithAnagram(words,mainword));
    }
    public static String findWordWithAnagram(List<String> words, String searchString) {
        for (String word : words) {
            if (containsAnagram(searchString, word)) {
                return word;
            }
        }
        return null; // or "Not found"
    }

    private static boolean containsAnagram(String s, String word) {
        int len = word.length();
        if (s.length() < len) return false;

        Map<Character, Integer> wordMap = buildFreqMap(word);

        for (int i = 0; i <= s.length() - len; i++) {
            String sub = s.substring(i, i + len);
            Map<Character, Integer> subMap = buildFreqMap(sub);
            if (wordMap.equals(subMap)) {
                return true;
            }
        }
        return false;
    }

    private static Map<Character, Integer> buildFreqMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}