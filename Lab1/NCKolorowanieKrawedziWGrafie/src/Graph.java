import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private List<Edge> edges;
    private int nc;

    public Graph(List<Edge> edges) {
        this.edges = edges;
        this.nc = calculateNC();
    }

    public int getNC() {
        return nc;
    }

    public void colorEdges() {
        Map<Integer, List<Edge>> colorMap = new HashMap<>();
        for (Edge edge : edges) {
            int color = 1;
            while (isColorUsed(color, colorMap, edge)) {
                color++;
            }
            edge.setColor(color);
            if (!colorMap.containsKey(color)) {
                colorMap.put(color, new ArrayList<>());
            }
            colorMap.get(color).add(edge);
        }
    }

    private boolean isColorUsed(int color, Map<Integer, List<Edge>> colorMap, Edge edge) {
        if (!colorMap.containsKey(color)) {
            return false;
        }
        for (Edge e : colorMap.get(color)) {
            if (e.intersect(edge)) {
                return true;
            }
        }
        return false;
    }

    private int calculateNC() {
        int maxDegree = 0;
        for (Edge edge : edges) {
            int degree = 0;
            for (Edge e : edges) {
                if (e.intersect(edge)) {
                    degree++;
                }
            }
            maxDegree = Math.max(maxDegree, degree);
        }
        return maxDegree + 1;
    }
}
