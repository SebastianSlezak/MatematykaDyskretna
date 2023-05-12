class NTLColoring {
    void colorGraph(Graph graph) {
        for (Edge edge : graph.edges) {
            for (Edge neighbor : graph.edges) {
                if (edge != neighbor && (edge.start == neighbor.start || edge.start == neighbor.end || edge.end == neighbor.start || edge.end == neighbor.end)) {
                    if (edge.color == neighbor.color) {
                        edge.color++;
                    }
                }
            }
        }
    }
}