import java.util.ArrayList;
import java.util.List;

class Vertex {
    int id;
    List<Vertex> neighbors;
    int color;

    public Vertex(int id) {
        this.id = id;
        this.neighbors = new ArrayList<>();
        this.color = -1;
    }

    public void addNeighbor(Vertex v) {
        this.neighbors.add(v);
    }

    public boolean isColored() {
        return color != -1;
    }

    public boolean hasNeighborWithColor(int c) {
        for (Vertex v : neighbors) {
            if (v.color == c) {
                return true;
            }
        }
        return false;
    }
}
