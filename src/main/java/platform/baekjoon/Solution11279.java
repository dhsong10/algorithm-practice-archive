package platform.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
11279: 최대 힙
 */
public class Solution11279 {

    public static List<Integer> solution(List<Integer> commands) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        List<Integer> results = new ArrayList<>();
        for (Integer command: commands) {
            if (command == 0) {
                if (priorityQueue.isEmpty()) {
                    results.add(0);
                } else {
                    results.add(priorityQueue.poll());
                }
            } else {
                priorityQueue.offer(command);
            }
        }

        return results;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());
        List<Integer> commands = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            commands.add(Integer.parseInt(bufferedReader.readLine()));
        }
        bufferedReader.close();

        List<Integer> answer = solution(commands);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Integer result: answer) {
            bufferedWriter.write(result + "\n");
        }
        bufferedWriter.close();

    }

}
