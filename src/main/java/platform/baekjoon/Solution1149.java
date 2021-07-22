package platform.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/*
1149: RGB거리
 */
public class Solution1149 {

    static final int RED = 0;
    static final int GREEN = 1;
    static final int BLUE = 2;

    public static int solution(int[][] houseCost) {

        int size = houseCost.length;
        int[][] dp = new int[size][3];

        dp[0][RED] = houseCost[0][RED];
        dp[0][GREEN] = houseCost[0][GREEN];
        dp[0][BLUE] = houseCost[0][BLUE];

        for (int i = 1; i < size; i++) {
            dp[i][RED] = Math.min(dp[i - 1][BLUE], dp[i - 1][GREEN]) + houseCost[i][RED];
            dp[i][GREEN] = Math.min(dp[i - 1][RED], dp[i - 1][BLUE]) + houseCost[i][GREEN];
            dp[i][BLUE] = Math.min(dp[i - 1][RED], dp[i - 1][GREEN]) + houseCost[i][BLUE];
        }

        return Math.min(Math.min(dp[size - 1][RED], dp[size - 1][GREEN]), dp[size - 1][BLUE]);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int size = Integer.parseInt(stringTokenizer.nextToken());

        int[][] houseCost = new int[size][3];
        for (int i = 0; i < size; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < 3; j++) {
                houseCost[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        bufferedReader.close();

        int answer = solution(houseCost);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.close();
    }

}
