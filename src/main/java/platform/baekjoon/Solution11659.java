package platform.baekjoon;

import java.io.*;

/*
11659: 구간 합 구하기
 */
public class Solution11659 {
    
    private static int[] prefixSum;

    private static void initializePrefixSum(int[] numbers) {

        prefixSum = new int[numbers.length];
        prefixSum[0] = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + numbers[i]; 
        }

    }

    public static int getPartialSum(int start, int end) {
        if (start == 1) {
            return prefixSum[end - 1];
        } else {
            return prefixSum[end - 1] - prefixSum[start - 2];
        }
    }

    public static int[] solution(int[][] testCase, int[] numbers) {

        initializePrefixSum(numbers);

        int[] answer = new int[testCase.length];
        for (int i = 0; i < testCase.length; i++) {
            answer[i] = getPartialSum(testCase[i][0], testCase[i][1]);
        }

        return answer;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String line[] = bufferedReader.readLine().split(" ");
        int size = Integer.parseInt(line[0]);
        int numTest = Integer.parseInt(line[1]);

        int[] numbers = new int[size];
        line = bufferedReader.readLine().split(" ");
        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(line[i]);
        }

        int[][] testCase = new int[numTest][2];
        for (int i = 0; i < numTest; i++) {
            line = bufferedReader.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);

            testCase[i][0] = start;
            testCase[i][1] = end;
        }

        bufferedReader.close();

        int[] answer = solution(testCase, numbers);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < answer.length; i++) {
            bufferedWriter.write(answer[i] + "\n");
        }

        bufferedWriter.close();
    }

}
