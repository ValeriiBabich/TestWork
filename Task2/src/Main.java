import java.util.*;

public class Main {
    static class City {
        String name;
        List<Edge> neighbors = new ArrayList<>();
    }

    static class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt(); // Number of test cases

        while (testCases-- > 0) {
            int n = scanner.nextInt(); // Number of cities
            Map<String, Integer> cityIndex = new HashMap<>(); // Map to store city name and its index
            City[] cities = new City[n + 1];

            // Input for cities and their neighbors
            for (int i = 1; i <= n; i++) {
                String name = scanner.next(); // City name
                cityIndex.put(name, i); // Map city name
                cities[i] = new City(); // Create new city object
                cities[i].name = name;

                int p = scanner.nextInt(); // Number of neighbors
                for (int j = 0; j < p; j++) {
                    int neighbor = scanner.nextInt(); // Neighbor city index
                    int cost = scanner.nextInt(); // Cost to reach the neighbor
                    cities[i].neighbors.add(new Edge(neighbor, cost)); // Add the edge
                }
            }

            int r = scanner.nextInt(); // Number of queries
            for (int i = 0; i < r; i++) {
                String start = scanner.next();
                String end = scanner.next();

                // Result
                int result = dijkstra(cityIndex.get(start), cityIndex.get(end), cities);
                System.out.println(result);
            }

            if (testCases > 0) {
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    // Function to implement Dijkstra's algorithm
    static int dijkstra(int start, int end, City[] cities) {
        int n = cities.length;
        int[] dist = new int[n]; // Array to store the shortest distances
        Arrays.fill(dist, Integer.MAX_VALUE); // Initialize all distances to infinity
        dist[start] = 0; // Distance to the start city is 0

        // Priority queue to store cities to be processed (min-heap by distance)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0}); // Add the start city with distance 0

        while (!pq.isEmpty()) {
            int[] current = pq.poll(); // Get the city with the smallest distance
            int currentCity = current[0];
            int currentCost = current[1];

            // If we reached the destination city, return the distance
            if (currentCity == end) {
                return currentCost;
            }

            // If the current cost is greater than the stored distance, skip this city
            if (currentCost > dist[currentCity]) {
                continue;
            }

            // Process all neighbors of the current city
            for (Edge edge : cities[currentCity].neighbors) {
                int nextCity = edge.to;
                int newCost = currentCost + edge.cost; // Calculate new cost to reach the neighbor

                // If the new cost is smaller, update and add to the priority queue
                if (newCost < dist[nextCity]) {
                    dist[nextCity] = newCost;
                    pq.add(new int[]{nextCity, newCost});
                }
            }
        }
        return -1;
    }
}
