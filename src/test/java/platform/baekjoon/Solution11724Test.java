package platform.baekjoon;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution11724Test {

    @Test
    void 연결_요소의_개수_테스트_기본1() {
        // given
        List<Integer> nodeList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Edge> edgeList = Arrays.asList(
                new Edge(1, 2), new Edge(2, 5),
                new Edge(5, 1), new Edge(3, 4), new Edge(4, 6));

        // when
        int actual = Solution11724.solution(nodeList, edgeList);

        // then
        assertEquals(2, actual);
    }

    @Test
    void 연결_요소의_개수_테스트_기본2() {
        // given
        List<Integer> nodeList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Edge> edgeList = Arrays.asList(
                new Edge(1, 2), new Edge(2, 5),
                new Edge(5, 1), new Edge(3, 4),
                new Edge(4, 6), new Edge(5, 4),
                new Edge(2, 4), new Edge(2, 3));

        // when
        int actual = Solution11724.solution(nodeList, edgeList);

        // then
        assertEquals(1, actual);
    }
}