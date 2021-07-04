package platform.baekjoon;

import java.io.*;
import java.util.Arrays;

/*
11399: ATM
 */
public class Solution11399 {

    public static int solution(int[] times) {

        Arrays.sort(times);

        int counter = 0;
        int waitTime = 0;

        for (int time: times) {
            counter += (waitTime + time);
            waitTime += time;
        }

        return counter;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());
        int[] times = new int[size];
        int index = 0;
        for (String timeString: bufferedReader.readLine().split(" ")) {
            times[index] = Integer.parseInt(timeString);
            index++;
        }
        bufferedReader.close();

        int answer = solution(times);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.close();
    }

}
