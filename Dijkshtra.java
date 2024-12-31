// A Java program for Dijkstra's single source shortest path
// algorithm. The program is for adjacency matrix
// representation of the graph

import java.lang.*;

class ShortestPath {
    // A utility function to find the vertex with minimum distance value, from the set of vertices not yet included in shortest path tree
    static final int V = 6;

    public static void main(String[] args) {
        /* Let us create the example graph discussed above
//         */
//        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
//                {4, 0, 8, 0, 0, 0, 0, 11, 0},
//                {0, 8, 0, 7, 0, 4, 0, 0, 2},
//                {0, 0, 7, 0, 9, 14, 0, 0, 0},
//                {0, 0, 0, 9, 0, 10, 0, 0, 0},
//                {0, 0, 4, 14, 10, 0, 2, 0, 0},
//                {0, 0, 0, 0, 0, 2, 0, 1, 6},
//                {8, 11, 0, 0, 0, 0, 1, 0, 7},
//                {0, 0, 2, 0, 0, 0, 6, 7, 0}};
        int graph[][] = new int[][]{{0, 4, 4, 0, 0, 0},
                {4, 0, 2, 3, 1, 6},
                {4, 2, 0, 0, 0, 0},
                {0, 3, 0, 0, 0, 2},
                {0, 1, 0, 0, 0, 3},
                {0, 6, 0, 2, 3, 0}};
        ShortestPath t = new ShortestPath();

        // Function call
        t.dijkstra(graph, 0);
    }

    // Function that implements Dijkstra's single source
    // shortest path algorithm for a graph represented using
    // adjacency matrix representation
    void dijkstra(int graph[][], int src) {
        int dist[] = new int[V]; // The output array.
        // dist[i] will hold the shortest distance from src to i
        // shortestDistanceFinal[i] will true if vertex i is included in shortest path tree or shortest distance from src to i is finalized
        Boolean shortestDistanceFinal[] = new Boolean[V];

        // Initialize all distances as INFINITE and shortestDistanceFinal[] as false
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            shortestDistanceFinal[i] = false;
        }

        // Distance of source vertex from itself is always 0
        dist[src] = 0;

        // Find the shortest path for all vertices
        for (int i = 0; i < V - 1; i++) {
            // Pick the minimum distance vertex from the set of vertices not yet processed. u is always equal to src in first iteration.
            int u = minDistance(dist, shortestDistanceFinal);
            // Mark the picked vertex as processed
            shortestDistanceFinal[u] = true;
//            System.out.println(u);
//            printSolution(dist);
            // Update dist value of the adjacent vertices of the picked vertex.
            for (int v = 0; v < V; v++)

                // Update dist[v] only if is not in shortestDistanceFinal, there is an edge from u to v, and total weight of path from src to v through u is
                // smaller than current value of dist[v]
                if (!shortestDistanceFinal[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
        }
        printSolution(dist);
    }

    int minDistance(int dist[], Boolean shortestDistanceFinal[]) {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int i = 0; i < V; i++)
            if (shortestDistanceFinal[i] == false && dist[i] <= min) {
                min = dist[i];
                min_index = i;
            }

        return min_index;
    }

    // A utility function to print the constructed distance
    // array
    void printSolution(int dist[]) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }
}
