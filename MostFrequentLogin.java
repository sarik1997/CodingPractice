/**
 * 🧩 Karat Question (Typical Framing)
 *
 * You are given a list of events in the form of strings. Each string represents an event like "login:alice" or "logout:bob".
 *
 * Write a function that returns the user with the highest number of login events.
 *
 * ⸻
 *
 * ✅ Clarifying Assumptions (Important in Karat Rounds)
 * 	•	What are the formats of the strings?
 * 	•	Format is "action:username" (e.g., login:alice)
 * 	•	Do we care about logout events?
 * 	•	No, just count login events.
 * 	•	Should we handle malformed strings?
 * 	•	Ignore them (or throw if asked).
 * 	•	What if there’s a tie?
 * 	•	Return any one of the top users.
 *
 * ⸻
 *
 * 📥 Input Example
 * String[] events = {
 *     "login:alice",
 *     "login:bob",
 *     "logout:alice",
 *     "login:alice",
 *     "login:bob",
 *     "login:alice"
 * };
 * 📤 Output
 * "alice"
 * (because alice logged in 3 times, bob logged in 2 times)
 */
import java.util.*;

public class MostFrequentLogin {

    public static String mostFrequentLogin(String[] events) {
        Map<String, Integer> loginCount = new HashMap<>();

        for (String event : events) {
            String[] parts = event.split(":");
            if (parts.length != 2) continue;

            String action = parts[0];
            String user = parts[1];

            if (action.equals("login")) {
                loginCount.put(user, loginCount.getOrDefault(user, 0) + 1);
            }
        }

        String topUser = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : loginCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                topUser = entry.getKey();
            }
        }

        return topUser;
    }

    public static void main(String[] args) {
        String[] logs = {
                "login:alice",
                "login:bob",
                "logout:alice",
                "login:alice",
                "login:bob",
                "login:alice"
        };

        System.out.println(mostFrequentLogin(logs)); // Output: alice
    }
}
