import java.util.ArrayList;
import java.util.List;

class Graph {
    List<Edge> edges;
    List<Integer> vertices;

    Graph() {
        edges = new ArrayList<>();
        vertices = new ArrayList<>();
    }

    void addEdge(int start, int end) {
        edges.add(new Edge(start, end));
        if (!vertices.contains(start)) {
            vertices.add(start);
        }
        if (!vertices.contains(end)) {
            vertices.add(end);
        }
    }
}