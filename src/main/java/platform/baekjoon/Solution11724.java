package platform.baekjoon;

import java.io.*;
import java.util.*;

/*
11724: 연결 요소의 개수
 */
class Edge {
    int nodeU;
    int nodeV;

    public Edge(int nodeU, int nodeV) {
        this.nodeU = nodeU;
        this.nodeV = nodeV;
    }

    public int getNodeU() {
        return nodeU;
    }

    public int getNodeV() {
        return nodeV;
    }
}

public class Solution11724 {

    public static int solution(List<Integer> nodeList, List<Edge> edgeList) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (Integer node: nodeList) {
            graph.put(node, new ArrayList<>());
        }

        for (Edge edge: edgeList) {
            graph.get(edge.getNodeU()).add(edge.getNodeV());
            graph.get(edge.getNodeV()).add(edge.getNodeU());
        }

        Map<Integer, Boolean> visited = new HashMap<>();
        for (Integer node: nodeList) {
            visited.put(node, false);
        }

        int counter = 0;
        Stack<Integer> stack = new Stack<>();
        for (Integer node: nodeList) {
            if (visited.get(node)) {
                continue;
            }

            stack.push(node);
            while (!stack.isEmpty()) {
                int currentNode = stack.pop();
                if (visited.get(currentNode)) {
                    continue;
                }
                visited.replace(currentNode, true);

                for (Integer nextNode: graph.get(currentNode)) {
                    if (visited.get(nextNode)) {
                        continue;
                    }

                    stack.push(nextNode);
                }
            }

            counter++;
        }

        return counter;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] sizeArray = bufferedReader.readLine().split(" ");
        int numNode = Integer.parseInt(sizeArray[0]);
        int numEdge = Integer.parseInt(sizeArray[1]);

        List<Integer> nodeList = new ArrayList<>();
        for (int i = 1; i <= numNode; i++) {
            nodeList.add(i);
        }

        List<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < numEdge; i++) {
            String[] nodeArray = bufferedReader.readLine().split(" ");
            Edge edge = new Edge(Integer.parseInt(nodeArray[0]), Integer.parseInt(nodeArray[1]));
            edgeList.add(edge);
        }

        bufferedReader.close();

        int answer = solution(nodeList, edgeList);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.close();

    }

}
