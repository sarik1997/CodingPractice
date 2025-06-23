/**
 * 🔍 Karat-style Problem: First Repeated Word
 *
 * 🧾 Problem Statement:
 * Implement a function that takes a paragraph as a string and returns the
 * first repeated word. The comparison should be case-insensitive, and punctuation should be ignored.


        📥 Example Input
String paragraph = "He had had quite enough of this nonsense.";
 📤 Output
 "had"
 */
import java.util.*;

public class FirstRepeatedWord {

    public static String firstRepeatedWord(String paragraph) {
        if (paragraph == null || paragraph.isEmpty()) return null;

        // Remove punctuation and make lowercase
        String cleaned = paragraph.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        String[] words = cleaned.split("\\s+");

        Set<String> seen = new HashSet<>();
        for (String word : words) {
            if (seen.contains(word)) {
                return word;
            }
            seen.add(word);
        }

        return null; // or "None"
    }

    public static void main(String[] args) {
        String input = "He had had quite enough of this nonsense.";
        System.out.println(firstRepeatedWord(input));  // Output: had

        String input2 = "This is a simple sentence.";
        System.out.println(firstRepeatedWord(input2));  // Output: null
    }
}
