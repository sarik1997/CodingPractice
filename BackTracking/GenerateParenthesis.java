package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    static List<String> result = new ArrayList<>();
    static int pairCount;

    public static List<String> generateParenthesis(int n) {
        pairCount = n;
        backtrack(0, 0, "");
        return result;
    }

    private static void backtrack(int openCount, int closeCount, String currentString) {
        if (openCount > pairCount || closeCount > pairCount || openCount < closeCount) {
            return;
        }
        if (openCount == pairCount && closeCount == pairCount) {
            result.add(currentString);
            return;
        }
        backtrack(openCount + 1, closeCount, currentString + "(");

        backtrack(openCount, closeCount + 1, currentString + ")");
    }


    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
        System.out.println(generateParenthesis(1));
    }
}
