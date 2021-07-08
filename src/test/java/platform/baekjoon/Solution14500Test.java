package platform.baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution14500Test {

    @Test
    void 테트로미노_테스트_기본1() {
        // given
        int[][] board = {
                {1, 2, 3, 4, 5},
                {5, 4, 3, 2, 1},
                {2, 3, 4, 5, 6},
                {6, 5, 4, 3, 2},
                {1, 2, 1, 2, 1}
        };

        // when
        int counter = Solution14500.solution(board);

        // then
        assertEquals(19, counter);
    }

    @Test
    void 테트로미노_테스트_기본2() {
        // given
        int[][] board = {
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5}
        };

        // when
        int counter = Solution14500.solution(board);

        // then
        assertEquals(20, counter);
    }

    @Test
    void 테트로미노_테스트_기본3() {
        // given
        int[][] board = {
                {1, 2, 1, 2, 1, 2, 1, 2, 1, 2},
                {2, 1, 2, 1, 2, 1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1, 2, 1, 2, 1, 2},
                {2, 1, 2, 1, 2, 1, 2, 1, 2, 1}
        };

        // when
        int counter = Solution14500.solution(board);

        // then
        assertEquals(7, counter);
    }
}