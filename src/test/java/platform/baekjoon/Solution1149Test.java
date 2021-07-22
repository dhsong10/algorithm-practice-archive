package platform.baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution1149Test {

    @Test
    void RGB거리_테스트_기본1() {
        // given
        int[][] houseCost = {
            {26, 40, 83},
            {49, 60, 57},
            {13, 89, 99}};

        // when
        int actual = Solution1149.solution(houseCost);

        // then
        assertEquals(96, actual);
    }

}