package platform.baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution10026Test {

    @Test
    void 적록색약_테스트_기본() {

        char[][] board = {
                {'R', 'R', 'R', 'B', 'B'},
                {'G', 'G', 'B', 'B', 'B'},
                {'B', 'B', 'B', 'R', 'R'},
                {'B', 'B', 'R', 'R', 'R'},
                {'R', 'R', 'R', 'R', 'R'}
        };

        assertEquals(4, Solution10026.countBoardGroupByColor(board, false));
        assertEquals(3, Solution10026.countBoardGroupByColor(board, true));

    }
}