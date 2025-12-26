package StringQuestions;

import java.util.*;
public class PermutationString {
    static  int counter =0;
    public static void mf(String str, String result) {
        if (str.equals("")) {
            System.out.println(result);
            return;
        }
        for (int i = 0; i < str.length(); ++i) {
            result += str.charAt(i);
            mf(str.substring(0, i ) + str.substring(i+1,str.length()), result);
            result = result.substring(0, result.length() - 1);
        }
    }

    public static void main(String args[]){
        String name = "ABC";
        String result = "";
        mf(name, "");

//        Question2Below unique String permutation like XYZ,ZYX,YZX..
        String str = "XXYYzz";

        // Step 1: Extract unique characters
        String unique = getUniqueCharacters(str);

        // Step 2: Generate permutations of unique characters
        List<String> results = new ArrayList<>();
        permute(unique.toCharArray(), 0, results);

        System.out.println("Total distinct permutations: " + results.size());
        for (String s : results) {
            System.out.println(s);
        }
    }
    private static String getUniqueCharacters(String str) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : set) {
            sb.append(c);
        }
        return sb.toString();
    }

    // Standard permutation generator
    private static void permute(char[] arr, int index, List<String> result) {
        if (index == arr.length) {
            result.add(new String(arr));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            permute(arr, index + 1, result);
            swap(arr, i, index); // backtrack
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
