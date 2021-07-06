package platform.baekjoon;

import java.io.*;

/*
11723: 집합
 */
public class Solution11723 {

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int[] setArray = new int[21];

    private static void initializeSetArray(int initialNumber) {
        for (int i = 1; i < setArray.length; i++) {
            setArray[i] = initialNumber;
        }
    }

    public static void setOperation(String command) throws IOException {
        String[] commandSplit = command.split(" ");

        String operator = commandSplit[0];
        Integer parameter = null;
        if (commandSplit.length == 2) {
            parameter = Integer.parseInt(commandSplit[1]);
        }

        switch (operator) {
            case "add":
                setArray[parameter] = 1;
                break;
            case "remove":
                setArray[parameter] = 0;
                break;
            case "check":
                bufferedWriter.write(setArray[parameter] + "\n");
                break;
            case "toggle":
                setArray[parameter] = setArray[parameter] == 1 ? 0 : 1;
                break;
            case "all":
                initializeSetArray(1);
                break;
            case "empty":
                initializeSetArray(0);
                break;
        }

    }

    public static void solution() throws IOException {
        int size = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < size; i++) {
            String command = bufferedReader.readLine();
            setOperation(command);
        }
    }

    public static void main(String[] args) throws IOException {

        solution();

        bufferedReader.close();
        bufferedWriter.close();
    }

}
