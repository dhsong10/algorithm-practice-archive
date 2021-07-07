package platform.baekjoon;

import java.io.*;

/*
11727: 2xn 타일링 2
 */
public class Solution11727 {

    private static int[] dp;

    public static int solution(int size) {
        dp = new int[size + 2];
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= size; i++) {
            dp[i] = (dp[i - 1] + (2 * dp[i - 2]) % 10007) % 10007;
        }

        return dp[size];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.close();

        int answer = solution(size);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.close();
    }

}
