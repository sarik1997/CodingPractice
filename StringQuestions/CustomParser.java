package StringQuestions;

import java.util.*;

/**🧪 Input
 * 🧩 Problem Statement
 *
 * You’re given a string in this format:
 * "team:alice,bob;group:john,doe;"
 *
 * Write a function to parse it and return a Map<String, List<String>>, where:
 * 	•	Keys are the group names ("team", "group")
 * 	•	Values are the list of members (e.g., ["alice", "bob"])
 * Output
 * {
 *   "team": ["alice", "bob"],
 *   "group": ["john", "doe"]
 * }
 */
public class CustomParser {

    public static Map<String, List<String>> parseGroups(String input) {
        Map<String, List<String>> result = new HashMap<>();

        if (input == null || input.isEmpty()) return result;

        // Split by ';' to separate each group definition
        String[] groups = input.split(";");

        for (String group : groups) {
            if (group.isEmpty()) continue;

            // Split by ':' to separate group name and members
            String[] parts = group.split(":");
            if (parts.length != 2) continue;

            String groupName = parts[0];
            String[] members = parts[1].split(",");

            result.put(groupName, Arrays.asList(members));
        }

        return result;
    }

    public static void main(String[] args) {
        String input = "team:alice,bob;group:john,doe;";
        Map<String, List<String>> output = parseGroups(input);

        for (Map.Entry<String, List<String>> entry : output.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}