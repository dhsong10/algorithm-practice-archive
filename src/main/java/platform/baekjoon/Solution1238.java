package platform.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

/*
1238: 파티
*/
public class Solution1238 {
    
    static int[][] distanceArray = null;
    static Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

    private static void initialzeDistanceArray(int size) {
        distanceArray = new int[size][size];
        for (int u = 1; u < size; u++) {
            for (int v = 1; v < size; v++) {
                if (u == v) {
                    distanceArray[u][v] = 0;
                } else {
                    distanceArray[u][v] = Integer.MAX_VALUE;
                }
            }
        }
    }

    private static void initializeGraph(int numNode, List<Edge> edgeList) {
        
        for (int node = 1; node <= numNode; node++) {
            graph.put(node, new HashMap<Integer, Integer>());
        }

        for (Edge edge: edgeList) {
            int srcNode = edge.getSrcNode();
            int dstNode = edge.getDstNode();
            int distance = edge.getDistance();

            graph.get(srcNode).put(dstNode, distance);
        }

    }
    
    private static int findNextNode(int baseNode, boolean[] visited) {

        int nextNode = baseNode;
        int minimumDistance = Integer.MAX_VALUE;
        int nodeSize = distanceArray.length - 1;
        for (int node = 1; node <= nodeSize; node++) {
            if (visited[node]) {
                continue;
            }

            if (distanceArray[baseNode][node] < minimumDistance) {
                minimumDistance = distanceArray[baseNode][node];
                nextNode = node;
            }
        }

        return nextNode;

    }

    private static void calculateShortesDistance(int node) {

        boolean[] visited = new boolean[distanceArray.length];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {

            int srcNode = queue.poll();

            if (visited[srcNode]) {
                continue;
            }
            visited[srcNode] = true;

            for (int dstNode: graph.get(srcNode).keySet()) {

                int originalDistance = distanceArray[node][dstNode];

                int distance = graph.get(srcNode).get(dstNode);
                int updatedDistance = distanceArray[node][srcNode] + distance;

                distanceArray[node][dstNode] = Math.min(originalDistance, updatedDistance);
            }

            int nextNode = findNextNode(node, visited);
            if (!visited[nextNode]) {
                queue.offer(nextNode);
            }

        }

    }

    public static int solution(int baseNode, int numNode, List<Edge> edgeList) {

        initialzeDistanceArray(numNode + 1);

        initializeGraph(numNode, edgeList);
        
        for (int node = 1; node <= numNode; node++) {
            calculateShortesDistance(node);
        }

        int longestDistance = Integer.MIN_VALUE;
        for (int node = 1; node <= numNode; node++) {
            longestDistance = Math.max(longestDistance, distanceArray[node][baseNode] + distanceArray[baseNode][node]);
        }
        return longestDistance;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int numNode = Integer.parseInt(stringTokenizer.nextToken());
        int numEdge = Integer.parseInt(stringTokenizer.nextToken());
        int baseNode = Integer.parseInt(stringTokenizer.nextToken());

        List<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < numEdge; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int srcNode = Integer.parseInt(stringTokenizer.nextToken());
            int dstNode = Integer.parseInt(stringTokenizer.nextToken());
            int distance = Integer.parseInt(stringTokenizer.nextToken());

            edgeList.add(new Edge(srcNode, dstNode, distance));
        }

        bufferedReader.close();

        int answer = solution(baseNode, numNode, edgeList);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.close();
    }

    public static class Edge {

        private int srcNode;
        private int dstNode;
        private int distance;

        public Edge(int srcNode, int dstNode, int distance) {
            this.srcNode = srcNode;
            this.dstNode = dstNode;
            this.distance = distance;
        }

        public int getSrcNode() {
            return srcNode;
        }

        public int getDstNode() {
            return dstNode;
        }

        public int getDistance() {
            return distance;
        }

    }

}
