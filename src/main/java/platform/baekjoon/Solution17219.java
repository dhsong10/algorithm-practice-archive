package platform.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
17219: 비밀번호 찾기
*/
public class Solution17219 {

    public static Map<String, String> passwordMap = new HashMap<>();

    public static List<String> solution(List<String> keys) {
        List<String> passwordList = new ArrayList<>();
        for(String key: keys) {
            passwordList.add(passwordMap.get(key));
        }
        return passwordList;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] sizeLine = bufferedReader.readLine().split(" ");

        int passwordSize = Integer.parseInt(sizeLine[0]);
        int questionSize = Integer.parseInt(sizeLine[1]);

        for (int i = 0; i < passwordSize; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            passwordMap.put(line[0], line[1]);
        }

        List<String> questionList = new ArrayList<>(questionSize);
        for (int i = 0; i < questionSize; i++) {
            questionList.add(bufferedReader.readLine());
        }

        bufferedReader.close();

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        List<String> answerList = solution(questionList);
        for (String answer: answerList) {
            bufferedWriter.write(answer + "\n");
        }
        bufferedWriter.close();
    }
}
