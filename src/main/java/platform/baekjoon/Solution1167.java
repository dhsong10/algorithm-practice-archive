package platform.baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

/*
1149: 트리의 지름
 */
public class Solution1167 {

    private static int[] getDistanceDFS(int startNode, Map<Integer, Map<Integer, Integer>> tree) {
        Stack<StackItem> stack = new Stack<>();

        int distance = 0;
        Edge startEdge = new Edge(startNode, startNode, 0);
        stack.push(new StackItem(startEdge, distance));

        boolean[] visited = new boolean[tree.size() + 1];
        int[] distanceFromStart = new int[tree.size() + 1];

        while (!stack.isEmpty()) {

            StackItem currentItem = stack.pop();
            Edge edge = currentItem.getEdge();
            int currentNode = edge.getDestNode();

            if (visited[currentNode]) {
                continue;
            }
            visited[currentNode] = true;
            
            int currentDistance = edge.getDistance();
            int cumulativeDistance = currentItem.getCumulativeDistance();
            cumulativeDistance += currentDistance;

            distanceFromStart[currentNode] = cumulativeDistance;

            for (int nextNode: tree.get(currentNode).keySet()) {

                if (visited[nextNode]) {
                    continue;
                }

                Edge nextEdge = new Edge(currentNode, nextNode, tree.get(currentNode).get(nextNode));
                stack.push(new StackItem(nextEdge, cumulativeDistance));
            }
        }

        return distanceFromStart;
    }

    public static int solution(Map<Integer, Map<Integer, Integer>> tree) {

        int startNode = 1;
        int[] distanceFromStart = getDistanceDFS(startNode, tree);

        int deepestNode = startNode;
        for (int node: tree.keySet()) {
            if (distanceFromStart[node] > distanceFromStart[deepestNode]) {
                deepestNode = node;
            }
        }

        int[] distanceTree = getDistanceDFS(deepestNode, tree);
        return Arrays.stream(distanceTree).max().getAsInt();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int size = Integer.parseInt(stringTokenizer.nextToken());

        Map<Integer, Map<Integer, Integer>> tree = new HashMap<>();
        for (int i = 0; i < size; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int node = Integer.valueOf(stringTokenizer.nextToken());
            tree.put(node, new HashMap<Integer, Integer>());

            int adjacentNode = node;
            boolean flagDistance = false;
            while (stringTokenizer.hasMoreTokens()) {
                int value = Integer.valueOf(stringTokenizer.nextToken());
                if (value == -1) {
                    break;
                }

                if (flagDistance) {
                    tree.get(node).put(adjacentNode, value);
                } else {
                    adjacentNode = value;
                }
                flagDistance = !flagDistance;
            }
        }
        bufferedReader.close();

        int answer = solution(tree);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.close();
    }

    static class Edge {
        private int srcNode;
        private int destNode;
        private int distance;

        public Edge(int srcNode, int destNode, int distance) {
            this.srcNode = srcNode;
            this.destNode = destNode;
            this.distance = distance;
        }

        public int getSrcNode() {
            return this.srcNode;
        }

        public int getDestNode() {
            return this.destNode;
        }

        public int getDistance() {
            return this.distance;
        }
    }

    static class StackItem {

        private Edge edge;
        private int cumulativeDistance;

        public StackItem(Edge edge, int cumulativeDistance) {
            this.edge = edge;
            this.cumulativeDistance = cumulativeDistance;
        }

        public Edge getEdge() {
            return this.edge;
        }

        public int getCumulativeDistance() {
            return this.cumulativeDistance;
        }

    }

}
