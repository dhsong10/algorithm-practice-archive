package platform.baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution11727Test {

    @Test
    void 타일링_테스트_기본() {

        assertEquals(1, Solution11727.solution(1));
        assertEquals(3, Solution11727.solution(2));
        assertEquals(171, Solution11727.solution(8));
        assertEquals(2731, Solution11727.solution(12));

    }
}