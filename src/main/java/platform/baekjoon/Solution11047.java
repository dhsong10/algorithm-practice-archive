package platform.baekjoon;

import java.io.*;

/*
11047: 동전 0
 */
public class Solution11047 {

    public static int solution(int[] coins, int target) {

        int counter = 0;

        for (int i = coins.length - 1; i >= 0; i--) {
            counter += (target / coins[i]);
            target = target % coins[i];
            if (target == 0) {
                break;
            }
        }

        return counter;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] line = bufferedReader.readLine().split(" ");
        int size = Integer.parseInt(line[0]);
        int target = Integer.parseInt(line[1]);

        int[] coins = new int[size];
        for (int i = 0; i < size; i++) {
            coins[i] = Integer.parseInt(bufferedReader.readLine());
        }
        bufferedReader.close();

        int answer = solution(coins, target);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.close();
    }

}
