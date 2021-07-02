package platform.baekjoon;

/*
11650: 좌표 정렬하기
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Coordinator {
    private Integer coordinateX;
    private Integer coordinateY;

    public Coordinator(Integer coordinateX, Integer coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public Integer getCoordinateX() {
        return coordinateX;
    }

    public Integer getCoordinateY() {
        return coordinateY;
    }

}

public class Solution11650 {

    public static List<Coordinator> solution(List<Coordinator> coordinatorList) {

        Comparator<Coordinator> coordinatorComparator = (source, target) -> {
            if (source.getCoordinateX().equals(target.getCoordinateX())) {
                return source.getCoordinateY() - target.getCoordinateY();
            } else {
                return source.getCoordinateX() - target.getCoordinateX();
            }
        };

        coordinatorList.sort(coordinatorComparator);

        return coordinatorList;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(bufferedReader.readLine());

        List<Coordinator> coordinatorList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            String[] numbers = bufferedReader.readLine().split(" ");

            Coordinator coordinator = new Coordinator(
                    Integer.parseInt(numbers[0]),
                    Integer.parseInt(numbers[1]));

            coordinatorList.add(coordinator);
        }

        bufferedReader.close();

        coordinatorList = solution(coordinatorList);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        for (Coordinator coordinator: coordinatorList) {
            bufferedWriter.write(coordinator.getCoordinateX() + " " + coordinator.getCoordinateY() + "\n");
        }

        bufferedWriter.close();
    }

}
