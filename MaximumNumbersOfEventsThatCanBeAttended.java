import java.util.*;

/**Maximum Number of Events That Can Be Attended
 * You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.
 * You can attend an event i at any day d where startTimei <= d <= endTimei. You can only attend one event at any time d.
 * Return the maximum number of events you can attend.
 * Example 1:
 * Input: events = [[1,2],[2,3],[3,4]]
 * Output: 3
 * Explanation: You can attend all the three events.
 * One way to attend them all is as shown.
 * Attend the first event on day 1.
 * Attend the second event on day 2.
 * Attend the third event on day 3.
 * Example 2:
 * Input: events= [[1,2],[2,3],[3,4],[1,2]]
 * Output: 4
 */
public class MaximumNumbersOfEventsThatCanBeAttended {
    public static int maxEvents(int[][] events) {
        // Create a map to associate start days with a list of their respective end days
        Map<Integer, List<Integer>> dayToEventsMap = new HashMap<>();
        int earliestStart = Integer.MAX_VALUE; // Initialize earliest event start day
        int latestEnd = 0; // Initialize latest event end day

        // Process the events to populate the map and find the range of event days
        for (int[] event : events) {
            int startDay = event[0];
            int endDay = event[1];

            // Map the start day to the end day of the event
            dayToEventsMap.computeIfAbsent(startDay, k -> new ArrayList<>()).add(endDay);

            // Update earliest start and latest end
            earliestStart = Math.min(earliestStart, startDay);
            latestEnd = Math.max(latestEnd, endDay);
        }

        // Create a min-heap to manage event end days
        PriorityQueue<Integer> eventsEndingQueue = new PriorityQueue<>();

        int attendedEventsCount = 0; // Initialize the count of events attended

        // Iterate over each day within the range of event days
        for (int currentDay = earliestStart; currentDay <= latestEnd; ++currentDay) {
            // Remove past events that have already ended
            while (!eventsEndingQueue.isEmpty() && eventsEndingQueue.peek() < currentDay) {
                eventsEndingQueue.poll();
            }

            // Add new events that start on the current day
            List<Integer> eventsStartingToday = dayToEventsMap.getOrDefault(currentDay, Collections.emptyList());
            for (int endDay : eventsStartingToday) {
                eventsEndingQueue.offer(endDay);
            }

            // Attend the event that ends the earliest, if any are available
            if (!eventsEndingQueue.isEmpty()) {
                eventsEndingQueue.poll();
                ++attendedEventsCount; // Increment the count of events attended
            }
        }

        return attendedEventsCount;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 2}, {3, 4}, {3, 4}, {1, 3}};
        System.out.println(NonOverlappingTask.eraseOverlapIntervals(intervals));
    }
}
