package Djkshitra;

/**
 * 🔐 Updated Problem Statement (Final)
 *
 * You are given:
 * 	•	N → total number of locks (indexed 0 to N-1)
 * 	•	target → lock number to unlock (not necessarily last)
 * 	•	For each lock i:
 * 	1.	forward[i] → maximum forward jump
 * 	2.	backward[i] → backward jump distance
 * 	3.	cost[i] → cost to unlock lock i
 *
 * Rules
 * 	•	You start at lock 0
 * 	•	Unlocking lock i costs cost[i]
 * 	•	From lock i:
 * 	•	Can jump to any lock j where
 * i < j ≤ i + forward[i]
 * 	•	Can jump to i - backward[i] (if ≥ 0)
 * 	•	Find minimum cost to unlock lock target
 *
 * ⸻
 *
 * 🧠 Correct Approach
 *
 * This is still a shortest-path problem because:
 * 	•	Forward + backward jumps create cycles
 * 	•	Greedy DP won’t work
 * 	•	Costs are positive
 *
 * ✅ Use Dijkstra’s Algorithm
 *
 * Index:     0   1   2   3
 * Forward:   2   1   1   0
 * Backward:  0   1   1   0
 * Cost:      5  10   3   1
 * Target:    2
 *
 * Optimal Path
 * 0 → 2
 * Cost = 5 + 3 = 8
 *
 *
 ⸻

 ⏱️ Complexity
 •	Time: O((N + edges) log N)
 •	Space: O(N)

 ⸻

 🎯 Interview One-Liner

 Model locks as graph nodes with forward and backward edges.
 Use Dijkstra’s algorithm to find the minimum cost to reach the given target lock.

 Dijkstra Example
 import java.util.*;

 public class Dijkstra {

 static class Edge {
 int to, weight;
 Edge(int to, int weight) {
 this.to = to;
 this.weight = weight;
 }
 }

 public static int[] dijkstra(List<List<Edge>> graph, int src) {
 int n = graph.size();
 int[] dist = new int[n];
 Arrays.fill(dist, Integer.MAX_VALUE);

 PriorityQueue<int[]> pq =
 new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

 dist[src] = 0;
 pq.offer(new int[]{src, 0});

 while (!pq.isEmpty()) {
 int[] cur = pq.poll();
 int u = cur[0];
 int d = cur[1];

 if (d > dist[u]) continue;

 for (Edge e : graph.get(u)) {
 int v = e.to;
 int newDist = dist[u] + e.weight;

 if (newDist < dist[v]) {
 dist[v] = newDist;
 pq.offer(new int[]{v, newDist});
 }
 }
 }
 return dist;
 }
 }
 */
import java.util.*;

public class MinCostToUnlockTarget {

    static class State {
        int index;
        int cost;

        State(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

    public static int minCost(
            int[] forward,
            int[] backward,
            int[] cost,
            int target
    ) {
        int n = cost.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<State> pq =
                new PriorityQueue<>(Comparator.comparingInt(s -> s.cost));

        dist[0] = cost[0];
        pq.offer(new State(0, cost[0]));

        while (!pq.isEmpty()) {
            State curr = pq.poll();
            int i = curr.index;

            // Reached target
            if (i == target) return curr.cost;

            if (curr.cost > dist[i]) continue;

            // Forward jumps
            for (int j = i + 1; j <= Math.min(n - 1, i + forward[i]); j++) {
                int newCost = curr.cost + cost[j];
                if (newCost < dist[j]) {
                    dist[j] = newCost;
                    pq.offer(new State(j, newCost));
                }
            }

            // Backward jump
            int back = i - backward[i];
            if (back >= 0) {
                int newCost = curr.cost + cost[back];
                if (newCost < dist[back]) {
                    dist[back] = newCost;
                    pq.offer(new State(back, newCost));
                }
            }
        }

        return -1; // target unreachable
    }

    public static void main(String[] args) {
        int[] forward  = {2, 1, 1, 0};
        int[] backward = {0, 1, 1, 0};
        int[] cost     = {5, 10, 3, 1};

        int target = 2;
        System.out.println(minCost(forward, backward, cost, target));
    }
}
