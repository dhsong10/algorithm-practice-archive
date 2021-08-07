package platform.baekjoon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Solution1238Test {

    @Test
    public void 파티_테스트_기본_1() {
        // given
        List<Solution1238.Edge> edgeList = new ArrayList<>();
        edgeList.add(new Solution1238.Edge(1, 2, 4));
        edgeList.add(new Solution1238.Edge(1, 3, 2));
        edgeList.add(new Solution1238.Edge(1, 4, 7));
        edgeList.add(new Solution1238.Edge(2, 1, 1));
        edgeList.add(new Solution1238.Edge(2, 3, 5));
        edgeList.add(new Solution1238.Edge(3, 1, 2));
        edgeList.add(new Solution1238.Edge(3, 4, 4));
        edgeList.add(new Solution1238.Edge(4, 2, 3));

        // when
        int actual = Solution1238.solution(2, 4, edgeList);

        // then
        assertEquals(10, actual);

    }
}
