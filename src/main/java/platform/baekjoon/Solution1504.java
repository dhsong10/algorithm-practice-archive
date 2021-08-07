package platform.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


/*
1504: 특정한 최단 경로
*/
public class Solution1504 {

    static class Edge {
        int nodeU;
        int nodeV;
        int distance;

        public Edge(int nodeU, int nodeV, int distance) {
            this.nodeU = nodeU;
            this.nodeV = nodeV;
            this.distance = distance;
        }

        public int getNodeU() {
            return nodeU;
        }

        public int getNodeV() {
            return nodeV;
        }

        public int getDistance() {
            return distance;
        }

    }

    private static Map<Integer, Map<Integer, Integer>> graph;

    private static Map<Integer, List<Integer>> distanceList;

    private static void initializeGraph(int numNode, List<Edge> edgeList) {

        graph = new HashMap<>();

        for (int node = 1; node <= numNode; node++) {
            graph.put(node, new HashMap<>());
        }

        for (Edge edge: edgeList) {
            int nodeU = edge.getNodeU();
            int nodeV = edge.getNodeV();
            int distance = edge.getDistance();

            graph.get(nodeU).put(nodeV, distance);
            graph.get(nodeV).put(nodeU, distance);
        }
        
    }

    private static void initializeDistanceList(int numNode, int[] intermediateNodeArray) {

        distanceList = new HashMap<>();

        distanceList.put(1, new ArrayList<>(numNode + 1));
        for (int node: intermediateNodeArray) {
            distanceList.put(node, new ArrayList<>(numNode + 1));
        }

        for (int nodeU: distanceList.keySet()) {
            int[] distanceArray = new int[numNode + 1];
            for (int nodeV = 1; nodeV <= numNode; nodeV++) {
                if (nodeU == nodeV) {
                    distanceArray[nodeV] = 0;
                } else {
                    distanceArray[nodeV] = Integer.MAX_VALUE;
                }
            }
            distanceList.put(nodeU, Arrays.stream(distanceArray).boxed().collect(Collectors.toList()));
        }
    }

    private static int findNextNode(int baseNode, boolean[] visited) {

        int nextNode = -1;
        int numNode = graph.size();

        int shortestDistance = Integer.MAX_VALUE;
        for (int node = 1; node <= numNode; node++) {
            if (visited[node]) {
                continue;
            }

            if (distanceList.get(baseNode).get(node) < shortestDistance) {
                shortestDistance = distanceList.get(baseNode).get(node);
                nextNode = node;
            }
        }

        return nextNode;
    }

    private static void calculateShortestDistance(int baseNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(baseNode);

        int numNode = graph.size();
        boolean[] visited = new boolean[numNode + 1];

        while (!queue.isEmpty()) {

            int currentNode = queue.poll();
            if (visited[currentNode]) {
                continue;
            }
            visited[currentNode] = true;

            for (int adjacentNode: graph.get(currentNode).keySet()) {
                int originalDistance = distanceList.get(baseNode).get(adjacentNode);

                int updatedDistance = distanceList.get(baseNode).get(currentNode) + graph.get(currentNode).get(adjacentNode);
                
                distanceList.get(baseNode).set(adjacentNode, Math.min(originalDistance, updatedDistance));
            }

            int nextNode = findNextNode(baseNode, visited);
            if (nextNode != -1 && !visited[nextNode]) {
                queue.offer(nextNode);
            }
        }

    }

    private static boolean isConnected(int numNode, int[] intermediateNodeArray) {
        int firstNode = intermediateNodeArray[0];
        int secondNode = intermediateNodeArray[1];

        if (distanceList.get(firstNode).get(secondNode) == Integer.MAX_VALUE) {
            return false;
        }

        if (distanceList.get(1).get(firstNode) == Integer.MAX_VALUE && distanceList.get(1).get(secondNode) == Integer.MAX_VALUE) {
            return false;
        }

        if (distanceList.get(firstNode).get(numNode) == Integer.MAX_VALUE && distanceList.get(secondNode).get(numNode) == Integer.MAX_VALUE) {
            return false;
        }

        return true;

    }

    public static int solution(int numNode, int[] intermediateNodeArray, List<Edge> edgeList) {
        
        initializeGraph(numNode, edgeList);

        initializeDistanceList(numNode, intermediateNodeArray);

        for (int baseNode: distanceList.keySet()) {
            calculateShortestDistance(baseNode);
        }

        if (!isConnected(numNode, intermediateNodeArray)) {
            return -1;
        }

        int firstNode = intermediateNodeArray[0];
        int secondNode = intermediateNodeArray[1];

        int shortestDistance = Math.min(
            distanceList.get(1).get(firstNode) + distanceList.get(firstNode).get(secondNode) + distanceList.get(secondNode).get(numNode), 
            distanceList.get(1).get(secondNode) + distanceList.get(secondNode).get(firstNode) + distanceList.get(firstNode).get(numNode));

        return shortestDistance;
    }

    public static void main(String[] args) throws IOException {
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int numNode = Integer.parseInt(stringTokenizer.nextToken());
        int numEdge = Integer.parseInt(stringTokenizer.nextToken());
        
        List<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < numEdge; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int nodeU = Integer.parseInt(stringTokenizer.nextToken());
            int nodeV = Integer.parseInt(stringTokenizer.nextToken());
            int distance = Integer.parseInt(stringTokenizer.nextToken());

            edgeList.add(new Edge(nodeU, nodeV, distance));
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] intermediateNodeArray = new int[2];
        intermediateNodeArray[0] = Integer.parseInt(stringTokenizer.nextToken());
        intermediateNodeArray[1] = Integer.parseInt(stringTokenizer.nextToken());

        bufferedReader.close();

        int answer = solution(numNode, intermediateNodeArray, edgeList);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.close();
    }

}
