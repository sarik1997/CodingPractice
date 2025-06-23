import java.util.*;
import java.time.*;
import java.time.format.*;

public class SessionAnalysis {

    public static int timeToMinutes(String timeStr) {
        LocalTime time = LocalTime.parse(timeStr, DateTimeFormatter.ofPattern("HH:mm"));
        return time.getHour() * 60 + time.getMinute();
    }

    public static Map<String, Integer> getSessionDurations(List<String[]> events) {
        Map<String, Integer> loginTimes = new HashMap<>();
        Map<String, Integer> durations = new HashMap<>();

        for (String[] event : events) {
            String action = event[0];
            String user = event[1];
            int minutes = timeToMinutes(event[2]);

            if (action.equals("login")) {
                loginTimes.put(user, minutes);
            } else {
                if (loginTimes.containsKey(user)) {
                    int duration = minutes - loginTimes.get(user);
                    durations.put(user, durations.getOrDefault(user, 0) + duration);
                    loginTimes.remove(user);
                }
            }
        }

        return durations;
    }

    public static int getMaxConcurrentSessions(List<String[]> events) {
        List<int[]> timeline = new ArrayList<>();

        for (String[] event : events) {
            int time = timeToMinutes(event[2]);
            timeline.add(new int[]{time, event[0].equals("login") ? 1 : -1});
        }

        timeline.sort((a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int max = 0, current = 0;
        for (int[] entry : timeline) {
            current += entry[1];
            max = Math.max(max, current);
        }

        return max;
    }

    public static void main(String[] args) {
        List<String[]> logs = Arrays.asList(
                new String[]{"login", "alice", "09:00"},
                new String[]{"logout", "alice", "09:30"},
                new String[]{"login", "bob", "09:10"},
                new String[]{"logout", "bob", "09:20"}
        );

        System.out.println("Session Durations: " + getSessionDurations(logs));  // {alice=30, bob=10}
        System.out.println("Max Concurrent Sessions: " + getMaxConcurrentSessions(logs)); // 2
    }
}