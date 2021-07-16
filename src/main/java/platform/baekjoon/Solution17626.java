package platform.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
17626: Four Squares
*/
public class Solution17626 {

    public static int[] dp = null;

    public static int solution(int number) {

        dp = new int[number + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= number; i++) {

            int sqrtNumber = (int) Math.sqrt(i);
            if (sqrtNumber * sqrtNumber == i) {
                dp[i] = 1;
                continue;
            }

            int counter = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                counter = Math.min(counter, dp[j * j] + dp[i - j * j]);
            }
            dp[i] = counter;
        }

        return dp[number];

    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.close();

        int answer = solution(number);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.close();
    }
}
