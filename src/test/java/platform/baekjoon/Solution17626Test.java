package platform.baekjoon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution17626Test {

    @Test
    void Four_Squares_테스트_기본() {
        // given & when & then
        assertEquals(1, Solution17626.solution(25));
        assertEquals(2, Solution17626.solution(26));
        assertEquals(3, Solution17626.solution(11339));
        assertEquals(4, Solution17626.solution(34567));
    }

    @BeforeEach
    void 초기화() {
        Solution17626.dp = null;
    }
}