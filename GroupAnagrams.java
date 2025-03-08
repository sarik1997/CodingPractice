import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(str);
        for (List<String> list : result) {
            System.out.println(list);
        }
    }
    public static List<List<String>> groupAnagrams(String[] str) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : str) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            map.get(sortedWord).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
