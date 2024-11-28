
// Class representing a connection between two cities
// Connection == edge in graph
public class Edge {
    int to; // Index of the destination city
    int cost;

    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}
