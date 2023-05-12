import java.util.*;

class LFColoringAlgorithm {
    public void color(Graph graph) {
        List<Color> availableColors = new ArrayList<>();
        for (int i = 0; i < graph.getNumVertices(); i++) {
            availableColors.add(new Color(i));
        }

        // Sortuj wierzchołki według stopnia (liczby sąsiadów)
        List<Graph.Vertex> vertices = graph.getVertices();
        Collections.sort(vertices);

        // Pokoloruj wierzchołki w kolejności malejącego stopnia.
        for (Graph.Vertex v : vertices) {
            if (v.isColored()) {
                continue;
            }

            Set<Color> neighborColors = new HashSet<>();
            for (Graph.Vertex neighbor : v.getNeighbors()) {
                if (neighbor.isColored()) {
                    neighborColors.add(neighbor.getColor());
                }
            }

            for (Color color : availableColors) {
                if (!neighborColors.contains(color)) {
                    v.setColor(color);
                    break;
                }
            }
        }
    }
}
