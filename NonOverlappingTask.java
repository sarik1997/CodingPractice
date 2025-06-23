/**435. Non-overlapping Intervals
 * Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 *
 * Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
 * Example 2:
 *
 * Input: intervals = [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
 * Example 3:
 *
 * Input: intervals = [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 */
import java.util.Arrays; // Required for Arrays.sort
import java.util.Comparator; // Required for Comparator

class NonOverlappingTask {
    public static int eraseOverlapIntervals(int[][] intervals) {
        // Sort the intervals array based on the end time of each interval
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        // Set 'end' as the end time of the first interval
        int end = intervals[0][1];

        // Initialize 'overlaps' to count the number of overlapping intervals
        int overlaps = 0;

        // Iterate through each interval starting from the second one
        for (int i = 1; i < intervals.length; i++) {
            // If the current interval does not overlap with the previous, update 'end'
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
            } else {
                // If the current interval overlaps, increment 'overlaps'
                overlaps++;
            }
        }

        // Return the total number of overlapping intervals to be removed
        return overlaps;
    }
    //return true if overlapping
    public static boolean hasOverlap(int[][] intervals) {
        if (intervals == null || intervals.length < 2) return false;

        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Check for overlaps
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                // Current start < previous end → overlap
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args){
        int[][] intervals = new int[][]{{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(intervals));
        System.out.println(hasOverlap(intervals));
    }

}