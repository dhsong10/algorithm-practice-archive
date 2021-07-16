package platform.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
18870: 좌표 압축
*/
public class Solution18870 {

    public static int[] solution(int[] numberArray) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (Integer number: numberArray) {
            priorityQueue.offer(number);
        }

        Map<Integer, Integer> compressedMap = new HashMap<>();
        int compressedNumber = 0;
        while (!priorityQueue.isEmpty()) {
            int number = priorityQueue.poll();
            if (compressedMap.containsKey(number)) {
                continue;
            }
            compressedMap.put(number, compressedNumber++);
        }

        int size = numberArray.length;
        int[] compressedNumberArray = new int[size];
        for (int i = 0; i < size; i++) {
            compressedNumberArray[i] = compressedMap.get(numberArray[i]);
        }

        return compressedNumberArray;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(bufferedReader.readLine());
        int[] numberArray = new int[size];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int index = 0;
        while (stringTokenizer.hasMoreTokens()) {
            numberArray[index++]  = Integer.parseInt(stringTokenizer.nextToken());
        }
        bufferedReader.close();
        
        int[] answer = solution(numberArray);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        for(Integer number: answer) {
            bufferedWriter.write(number + " ");
        }
        bufferedWriter.close();
    }
}
