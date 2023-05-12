import java.util.ArrayList;
import java.util.List;

class Graph {
    List<Vertex> vertices;

    public Graph() {
        this.vertices = new ArrayList<>();
    }

    public void addVertex(Vertex v) {
        this.vertices.add(v);
    }

    public void colorGraphSLF() {
        // Sortuj wierzchołki według malejącego stopnia
        vertices.sort((v1, v2) -> v2.neighbors.size() - v1.neighbors.size());

        // Zainicjuj kolory
        int numColors = 0;
        for (Vertex v : vertices) {
            v.color = -1;
        }

        // Przyporządkuj kolory
        for (Vertex v : vertices) {
            if (!v.isColored()) {
                int c = 0;
                while (v.hasNeighborWithColor(c)) {
                    c++;
                }
                v.color = c;
                numColors = Math.max(numColors, c+1);
            }
        }
        System.out.println("Liczba użytych kolorów: " + numColors);
    }
}
