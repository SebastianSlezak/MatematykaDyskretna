import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(1, 2));
        edges.add(new Edge(2, 3));
        edges.add(new Edge(1, 4));
        edges.add(new Edge(3, 4));
        edges.add(new Edge(2, 4));

        Graph graph = new Graph(edges);
        System.out.println("NC: " + graph.getNC());

        graph.colorEdges();
        for (Edge edge : edges) {
            System.out.println("Krawędź " + edge.getStart() + "-" + edge.getEnd() + " kolor: " + edge.getColor());
        }
    }
}