package platform.baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution11047Test {

    @Test
    void 동적_0_테스트_기본() {

        int[] coins = {1, 5, 10, 50, 100, 500, 1000, 5000, 10000, 50000};
        assertEquals(6, Solution11047.solution(coins, 4200));
        assertEquals(12, Solution11047.solution(coins, 4790));

    }
}