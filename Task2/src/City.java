import java.util.ArrayList;
import java.util.List;

// This class representing a city in the graph
public class City {
    String name;
    List<Edge> neighbors = new ArrayList<>(); // List of neighboring cities with costs

    public City(String name) {
        this.name = name;
    }
}
