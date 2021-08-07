package platform.baekjoon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Solution1504Test {
    @Test
    void 특정한_최단_경로_테스트_기본_1() {
        // given
        List<Solution1504.Edge> edgeList = new ArrayList<>();
        edgeList.add(new Solution1504.Edge(1, 2, 3));
        edgeList.add(new Solution1504.Edge(2, 3, 3));
        edgeList.add(new Solution1504.Edge(3, 4, 1));
        edgeList.add(new Solution1504.Edge(1, 3, 5));
        edgeList.add(new Solution1504.Edge(2, 4, 5));
        edgeList.add(new Solution1504.Edge(1, 4, 4));

        int[] intermediateNodeArray = {2, 3};

        // when
        int actual = Solution1504.solution(4, intermediateNodeArray, edgeList);

        // then
        assertEquals(7, actual);
    }

    @Test
    void 특정한_최단_경로_테스트_1() {
        // given
        List<Solution1504.Edge> edgeList = new ArrayList<>();
        edgeList.add(new Solution1504.Edge(1, 2, 3));
        edgeList.add(new Solution1504.Edge(2, 3, 3));
        edgeList.add(new Solution1504.Edge(3, 4, 1));
        edgeList.add(new Solution1504.Edge(1, 3, 5));
        edgeList.add(new Solution1504.Edge(2, 4, 5));
        edgeList.add(new Solution1504.Edge(1, 4, 4));

        int[] intermediateNodeArray = {2, 3};

        // when
        int actual = Solution1504.solution(5, intermediateNodeArray, edgeList);

        // then
        assertEquals(-1, actual);
    }

    @Test
    void 특정한_최단_경로_테스트_2() {
        // given
        List<Solution1504.Edge> edgeList = new ArrayList<>();

        int[] intermediateNodeArray = {1, 2};

        // when
        int actual = Solution1504.solution(2, intermediateNodeArray, edgeList);

        // then
        assertEquals(-1, actual);
    }
}
