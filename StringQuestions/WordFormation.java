package StringQuestions;

import java.util.*;

public class WordFormation {
    public static List<String> getFormableWords(String note, List<String> words) {
        Map<Character, Integer> noteFreq = getCharFrequency(note);
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (canForm(word, noteFreq)) {
                result.add(word);
            }
        }

        return result;
    }

    private static Map<Character, Integer> getCharFrequency(String str) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : str.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        return freq;
    }

    private static boolean canForm(String word, Map<Character, Integer> noteFreq) {
        Map<Character, Integer> wordFreq = new HashMap<>();
        for (char ch : word.toCharArray()) {
            wordFreq.put(ch, wordFreq.getOrDefault(ch, 0) + 1);
        }

        for (char ch : wordFreq.keySet()) {
            if (wordFreq.get(ch) > noteFreq.getOrDefault(ch, 0)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String note1 = "cataatsdc";
        List<String> words = Arrays.asList("cat", "dog", "refree", "acts", "sat");
        System.out.println(getFormableWords(note1, words));  // Output: [cat, acts, sat]
    }
}