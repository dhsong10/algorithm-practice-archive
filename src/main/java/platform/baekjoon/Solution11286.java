package platform.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution11286 {

    public static List<Integer> solution(List<Integer> commands) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((source, target) -> {
            if (Math.abs(source) == Math.abs(target)) {
                return source - target;
            } else {
                return Math.abs(source) - Math.abs(target);
            }
        });

        List<Integer> resultList = new ArrayList<>();
        for (Integer command: commands) {
            if (command == 0) {
                if (priorityQueue.isEmpty()) {
                    resultList.add(0);
                } else {
                    resultList.add(priorityQueue.poll());
                }
            } else {
                priorityQueue.offer(command);
            }
        }

        return resultList;

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
