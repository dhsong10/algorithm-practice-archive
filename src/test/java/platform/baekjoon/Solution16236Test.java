package platform.baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution16236Test {

    @Test
    void 아기_상어_테스트_기본1() {
        // given
        int[][] board = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 9, 0}
        };

        // when
        int answer = Solution16236.solution(board);

        // then
        assertEquals(0, answer);
    }

    @Test
    void 아기_상어_테스트_기본2() {
        // given
        int[][] board = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 9, 0}
        };

        // when
        int answer = Solution16236.solution(board);

        // then
        assertEquals(0, answer);
    }

    @Test
    void 아기_상어_테스트_기본3() {
        // given
        int[][] board = {
                {4, 3, 2, 1},
                {0, 0, 0, 0},
                {0, 0, 9, 0},
                {1, 2, 3, 4}
        };

        // when
        int answer = Solution16236.solution(board);

        // then
        assertEquals(14, answer);
    }

    @Test
    void 아기_상어_테스트_기본4() {
        // given
        int[][] board = {
                {5, 4, 3, 2, 3, 4},
                {4, 3, 2, 3, 4, 5},
                {3, 2, 9, 5, 6, 6},
                {2, 1, 2, 3, 4, 5},
                {3, 2, 1, 6, 5, 4},
                {6, 6, 6, 6, 6, 6}
        };

        // when
        int answer = Solution16236.solution(board);

        // then
        assertEquals(60, answer);
    }

    @Test
    void 아기_상어_테스트_기본5() {
        // given
        int[][] board = {
                {6, 0, 6, 0, 6, 1},
                {0, 0, 0, 0, 0, 2},
                {2, 3, 4, 5, 6, 6},
                {0, 0, 0, 0, 0, 2},
                {0, 2, 0, 0, 0, 0},
                {3, 9, 3, 0, 0, 1}
        };

        // when
        int answer = Solution16236.solution(board);

        // then
        assertEquals(48, answer);
    }

    @Test
    void 아기_상어_테스트_기본6() {
        // given
        int[][] board = {
                {1, 1, 1, 1, 1, 1},
                {2, 2, 6, 2, 2, 3},
                {2, 2, 5, 2, 2, 3},
                {2, 2, 2, 4, 6, 3},
                {0, 0, 0, 0, 0, 6},
                {0, 0, 0, 0, 0, 9}
        };

        // when
        int answer = Solution16236.solution(board);

        // then
        assertEquals(39, answer);
    }
}