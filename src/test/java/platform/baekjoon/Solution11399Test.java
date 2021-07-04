package platform.baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution11399Test {

    @Test
    void ATM_테스트_기본() {
        // given
        int[] times = {3, 1, 4, 3, 2};

        // when & then
        assertEquals(32, Solution11399.solution(times));

    }
}