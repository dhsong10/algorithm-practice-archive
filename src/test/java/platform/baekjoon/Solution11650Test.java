package platform.baekjoon;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution11650Test {

    @Test
    void 좌표_정렬하기_테스트_기본() {

        // given
        List<Coordinator> coordinatorList = new ArrayList<>();
        coordinatorList.add(new Coordinator(3, 4));
        coordinatorList.add(new Coordinator(1, 1));
        coordinatorList.add(new Coordinator(1, -1));
        coordinatorList.add(new Coordinator(2, 2));
        coordinatorList.add(new Coordinator(3, 3));

        List<Coordinator> expectedCoordinatorList = new ArrayList<>();
        expectedCoordinatorList.add(new Coordinator(1, -1));
        expectedCoordinatorList.add(new Coordinator(1, 1));
        expectedCoordinatorList.add(new Coordinator(2, 2));
        expectedCoordinatorList.add(new Coordinator(3, 3));
        expectedCoordinatorList.add(new Coordinator(3, 4));

        // when
        Solution11650.solution(coordinatorList);

        // then
        assertEquals(expectedCoordinatorList.size(), coordinatorList.size());

        for (int i = 0; i < expectedCoordinatorList.size(); i++) {
            assertEquals(expectedCoordinatorList.get(i).getCoordinateX(), coordinatorList.get(i).getCoordinateX());
            assertEquals(expectedCoordinatorList.get(i).getCoordinateY(), coordinatorList.get(i).getCoordinateY());
        }

    }
}