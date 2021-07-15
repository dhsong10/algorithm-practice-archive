package platform.baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
16928: 뱀과 사다리 게임
*/
public class Solution16928 {

    public static int solution(Map<Integer, Integer> stairMap, Map<Integer, Integer> snakeMap) {

        Queue<Item> queue = new LinkedList<>();
        queue.offer(new Item(1, 0));

        int distance = -1;

        boolean[] visited = new boolean[101];
        while(!queue.isEmpty()) {
            
            Item currentItem = queue.poll();
            int currentPosition = currentItem.getPosition();
            int currentDistance = currentItem.getDistance();

            if (currentPosition == 100) {
                distance = currentDistance;
                break;
            }

            if (visited[currentPosition]) {
                continue;
            }
            visited[currentPosition] = true;

            for (int delta = 1; delta <= 6; delta++) {
                int nextPosition = currentPosition + delta;

                // out of boundary
                if (nextPosition > 100) {
                    continue;
                }

                // visited
                if (visited[nextPosition]) {
                    continue;
                }

                if (stairMap.containsKey(nextPosition)) {
                    queue.offer(new Item(stairMap.get(nextPosition), currentDistance + 1));
                } else if (snakeMap.containsKey(nextPosition)) {
                    queue.offer(new Item(snakeMap.get(nextPosition), currentDistance + 1));
                } else {
                    queue.offer(new Item(nextPosition, currentDistance + 1));
                }

            }

        }

        return distance;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] sizeLine = bufferedReader.readLine().split(" ");

        int stairSize = Integer.parseInt(sizeLine[0]);
        int snakeSize = Integer.parseInt(sizeLine[1]);

        Map<Integer, Integer> stairMap = new HashMap<>();
        for (int i = 0; i < stairSize; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            stairMap.put(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }

        Map<Integer, Integer> snakeMap = new HashMap<>();
        for (int i = 0; i < snakeSize; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            snakeMap.put(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }

        bufferedReader.close();

        int answer = solution(stairMap, snakeMap);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.close();
    }


    static class Item {

        private int position;
        private int distance;

        public Item(int position, int distance) {
            this.position = position;
            this.distance = distance;
        }

        public int getPosition() {
            return this.position;
        }

        public int getDistance() {
            return this.distance;
        }

    }

}
