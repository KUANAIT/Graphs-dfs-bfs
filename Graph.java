import java.util.*;

class Graph {
    private Map<String, List<String>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
        adjacencyList.put("A", Arrays.asList("C", "B", "D"));
        adjacencyList.put("B", Arrays.asList("A", "C", "E", "G"));
        adjacencyList.put("C", Arrays.asList("A", "B", "D"));
        adjacencyList.put("D", Arrays.asList("C", "A"));
        adjacencyList.put("E", Arrays.asList("G", "F", "B"));
        adjacencyList.put("F", Arrays.asList("G", "E"));
        adjacencyList.put("G", Arrays.asList("F", "B"));
    }

    public List<String> dfs(String start) {
        Set<String> visited = new HashSet<>();
        List<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            String node = stack.pop();
            if (!visited.contains(node)) {
                visited.add(node);
                result.add(node);
                List<String> neighbors = adjacencyList.get(node);
                if (neighbors != null) {
                    for (int i = neighbors.size() - 1; i >= 0; i--) {
                        stack.push(neighbors.get(i));
                    }
                }
            }
        }
        return result;
    }

    public List<String> bfs(String start) {
        Set<String> visited = new HashSet<>();
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            String node = queue.poll();
            if (!visited.contains(node)) {
                visited.add(node);
                result.add(node);
                List<String> neighbors = adjacencyList.get(node);
                if (neighbors != null) {
                    for (String neighbor : neighbors) {
                        if (!visited.contains(neighbor)) {
                            queue.offer(neighbor);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        List<String> dfsResult = graph.dfs("A");
        List<String> bfsResult = graph.bfs("A");

        System.out.println("DFS Result: " + dfsResult);
        System.out.println("BFS Result: " + bfsResult);
    }
}
