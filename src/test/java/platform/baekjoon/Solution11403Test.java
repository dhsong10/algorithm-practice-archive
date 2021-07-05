package platform.baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution11403Test {

    @Test
    void 경로_찾기_테스트_기본_1() {

        // given
        int[][] graph = {
                {0,  1,  0},
                {0,  0,  1},
                {1,  0,  0}
        };
        boolean[][] expected = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        // when
        boolean[][] actual = Solution11403.solution(graph);

        // then
        for (int node = 0; node < graph.length; node++) {
            assertArrayEquals(expected[node], actual[node]);
        }

    }

    @Test
    void 경로_찾기_테스트_기본_2() {

        // given
        int[][] graph = {
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0},
                {1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 0}
        };
        boolean[][] expected = {
                {true, false, true, true, true, true, true},
                {false, false, true, false, false, false, true},
                {false, false, false, false, false, false, false},
                {true, false, true, true, true, true, true},
                {true, false, true, true, true, true, true},
                {false, false, true, false, false, false, true},
                {false, false, true, false, false, false, false}
        };

        // when
        boolean[][] actual = Solution11403.solution(graph);

        // then
        for (int node = 0; node < graph.length; node++) {
            assertArrayEquals(expected[node], actual[node]);
        }

    }}