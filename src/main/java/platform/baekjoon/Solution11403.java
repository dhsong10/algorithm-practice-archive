package platform.baekjoon;

import java.io.*;
import java.util.Stack;

/*
11403: 경로 찾
 */
public class Solution11403 {

    public static void dfsVisited(int node, boolean[][] connectedMap, int[][] graph) {

        boolean[] visited = new boolean[graph.length];

        Stack<Integer> stack = new Stack<>();
        for (int nextNode = graph.length - 1; nextNode >= 0; nextNode--) {
            if (graph[node][nextNode] == 1 && !visited[nextNode]) {
                stack.push(nextNode);
            }
        }

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();

            if (visited[currentNode]) {
                continue;
            }
            visited[currentNode] = true;
            connectedMap[node][currentNode] = true;

            for (int nextNode = graph.length - 1; nextNode >= 0; nextNode--) {
                if (graph[currentNode][nextNode] == 1 && !visited[nextNode]) {
                    stack.push(nextNode);
                }
            }

        }
    }

    public static boolean[][] solution(int[][] graph) {
        int numNode = graph.length;
        boolean[][] connectedMap = new boolean[numNode][numNode];

        for (int i = 0; i < numNode; i++) {
            dfsVisited(i, connectedMap, graph);
        }

        return connectedMap;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int numNode = Integer.parseInt(bufferedReader.readLine());
        int[][] graph = new int[numNode][numNode];
        for (int i = 0; i < numNode; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            for (int j = 0; j < numNode; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
            }
        }

        bufferedReader.close();

        boolean[][] connectedMap = solution(graph);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < numNode; i++) {
            for (int j = 0; j < numNode; j++) {
                bufferedWriter.write((connectedMap[i][j] ? "1" : "0") + " ");
            }
            bufferedWriter.write("\n");
        }
        bufferedWriter.close();

    }

}
