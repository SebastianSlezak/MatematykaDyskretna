    import java.util.*;

    public class FleuryAlgorithm {
        private int vertices;
        private LinkedList<Integer>[] adjacencyList;

        public FleuryAlgorithm(int vertices) {
            this.vertices = vertices;
            adjacencyList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination) {
            adjacencyList[source].add(destination);
            adjacencyList[destination].add(source);
        }

        public void findEulerianPath() {
            // Sprawdź, czy graf ma ścieżkę lub cykl Euleriana
            int oddDegreeCount = 0;
            int startVertex = 0;
            for (int i = 0; i < vertices; i++) {
                if (adjacencyList[i].size() % 2 != 0) {
                    oddDegreeCount++;
                    startVertex = i;
                }
            }

            if (oddDegreeCount > 2) {
                System.out.println("Graf nie posiada ścieżki Eulerowskiej ani cyklu Eulerowskiego.");
                return;
            }

            // Utwórz stos do przechowywania eulerowskiej ścieżki lub cyklu
            Stack<Integer> stack = new Stack<>();
            ArrayList<Integer> path = new ArrayList<>();

            // Dodaj początkowy wierzchołek do stosu
            stack.push(startVertex);

            while (!stack.isEmpty()) {
                int currentVertex = stack.peek();

                if (adjacencyList[currentVertex].size() == 0) {
                    path.add(stack.pop());
                } else {
                    int nextVertex = adjacencyList[currentVertex].get(0);
                    adjacencyList[currentVertex].remove(Integer.valueOf(nextVertex));
                    adjacencyList[nextVertex].remove(Integer.valueOf(currentVertex));
                    stack.push(nextVertex);
                }
            }

            // Wydrukuj ścieżkę lub cykl eulerowski
            for (int i = path.size() - 1; i >= 0; i--) {
                System.out.print(path.get(i));
                if (i != 0) {
                    System.out.print(" -> ");
                }
            }
        }

        public static void main(String[] args) {
            FleuryAlgorithm graph = new FleuryAlgorithm(5);
            graph.addEdge(0, 1);
            graph.addEdge(0, 2);
            graph.addEdge(1, 2);
            graph.addEdge(2, 3);
            graph.addEdge(3, 4);
            graph.findEulerianPath();
        }
    }
