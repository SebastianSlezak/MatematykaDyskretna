class SLFColoring {
    public static void main(String[] args) {
        Graph g = new Graph();

        // Tworzenie wierzchołków
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);

        // Dodaj krawędzie
        v3.addNeighbor(v2);
        v3.addNeighbor(v4);
        v4.addNeighbor(v1);
        v4.addNeighbor(v2);
        v4.addNeighbor(v3);
        v4.addNeighbor(v5);
        v4.addNeighbor(v6);
        v5.addNeighbor(v4);
        v6.addNeighbor(v4);

        // Dodaj wierzchołki do grafu
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addVertex(v6);

        // Kolorowy wykres z wykorzystaniem algorytmu SLF
        g.colorGraphSLF();
    }
}