import java.util.*;

public class EulerCycle {

    public static List<Integer> findEulerCycle(int[][] graph) {
        List<Integer> cycle = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int n = graph.length;

        // Wybierz wierzchołek startowy i dodaj go na stos
        stack.push(0);

        while (!stack.isEmpty()) {
            int u = stack.peek();

            // Sprawdź, czy wierzchołek u ma jakieś nieodwiedzone krawędzie
            boolean hasUnvisitedEdge = false;
            for (int v = 0; v < n; v++) {
                if (graph[u][v] > 0) {
                    graph[u][v]--;
                    graph[v][u]--;
                    stack.push(v);
                    hasUnvisitedEdge = true;
                    break;
                }
            }

            // Jeśli wierzchołek nie ma już nieodwiedzonych krawędzi, usuń go ze stosu i dodaj na początek cyklu
            if (!hasUnvisitedEdge) {
                stack.pop();
                cycle.add(0, u);
            }
        }

        return cycle;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 0, 0, 1},
                {0, 1, 1, 1, 0}
        };
        List<Integer> cycle = findEulerCycle(graph);
        System.out.println(cycle);
    }
}
