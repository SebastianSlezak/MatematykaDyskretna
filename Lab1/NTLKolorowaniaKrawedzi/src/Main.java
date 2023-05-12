public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);
        graph.addEdge(2, 4);
        graph.addEdge(1, 3);

        NTLColoring coloring = new NTLColoring();
        coloring.colorGraph(graph);

        for (Edge edge : graph.edges) {
            System.out.println("Krawędź: " + edge.start + " - " + edge.end + " kolor: " + edge.color);
        }
    }
}