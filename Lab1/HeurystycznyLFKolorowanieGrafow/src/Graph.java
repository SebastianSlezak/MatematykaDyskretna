import java.util.*;

public class Graph {
    private List<Vertex> vertices;
    private int numVertices;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        vertices = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            vertices.add(new Vertex(i));
        }
    }

    public void addEdge(int u, int v) {
        vertices.get(u).addNeighbor(vertices.get(v));
        vertices.get(v).addNeighbor(vertices.get(u));
    }

    public int getNumVertices() {
        return numVertices;
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public static class Vertex implements Comparable<Vertex> {
        private int id;
        private Set<Vertex> neighbors;
        private Color color;

        public Vertex(int id) {
            this.id = id;
            neighbors = new HashSet<>();
        }

        public int getId() {
            return id;
        }

        public Set<Vertex> getNeighbors() {
            return neighbors;
        }

        public void addNeighbor(Vertex v) {
            neighbors.add(v);
        }

        public boolean isColored() {
            return color != null;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(o.neighbors.size(), this.neighbors.size());
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        LFColoringAlgorithm algorithm = new LFColoringAlgorithm();
        algorithm.color(graph);

        for (Vertex v : graph.getVertices()) {
            System.out.println("Wierzchołek " + v.getId() + " jest pokolorowany " + v.getColor().getId());
        }
    }
}


